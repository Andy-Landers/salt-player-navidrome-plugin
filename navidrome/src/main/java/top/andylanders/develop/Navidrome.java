package top.andylanders.develop;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.MD5;
import top.andylanders.develop.dict.NavidromeAPIEnum;
import top.andylanders.develop.exception.NavidromeException;
import top.andylanders.develop.exception.dict.NavidromeExceptionEnum;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;
import java.util.Properties;

/**
 * Navidrome Connector
 * @author Andy Landers
 * @date 2025-10-23
 * @description 用于实现对Navidrome服务器的连接与各种拓展接口调用的工具包，包括流式传输与获取媒体ID3信息等功能。
 */
public class Navidrome {

    private String navidromeUrl;
    private String navidromeToken;
    private String username;
    private String password;

    /**
     * Navidrome工具对象构造器
     */
    public Navidrome() {
        // 加载配置文件
        loadConfig();
        // 构建token
        buildAccessParam();
    }

    /**
     * hash生成器
     * @return 随机生成的8位hash
     */
    private String randomHashGenerator() {
        return RandomUtil.randomString(8);
    }

    /**
     * token构建器
     */
    private void buildAccessParam() {
        String hash = randomHashGenerator();
        // 根据Navidrome与Subsonic API文档提供的算法，此处md5计算方法为将用户的密码与hash拼接后求md5
        //TIP 接口文档原文摘要如下：“Calculate the authentication token as follows: token = md5(password + salt). The md5() function takes a string and returns the 32-byte ASCII hexadecimal representation of the MD5 hash, using lower case characters for the hex values. The '+' operator represents concatenation of the two strings. Treat the strings as UTF-8 encoded when calculating the hash.”
        String md5 = MD5.create().digestHex(password + hash);
        this.navidromeToken = "u=" + username + "&t=" + md5 + "&s=" + hash + "&v=1.16.1&c=spw-navidrome-plugin";
    }

    /**
     * 配置文件加载器
     */
    private void loadConfig() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            this.navidromeUrl = properties.getProperty("navidromeUrl");
            this.username = properties.getProperty("username");
            this.password = properties.getProperty("password");
        } catch (IOException e) {
            throw new NavidromeException(NavidromeExceptionEnum.WRONG_CONFIG);
        }
    }

    /**
     * URL构建器
     * @param api 接口枚举
     * @param extraParams 额外参数
     * @return 构建后的完整URL
     */
    private String urlBuilder(NavidromeAPIEnum api, String extraParams) {
        if (extraParams == null || extraParams.isEmpty()) {
            return navidromeUrl + "/rest" + api.getVal() + "?" + navidromeToken;
        } else {
            return navidromeUrl + "/rest" + api.getVal() + "?" + extraParams + "&" + navidromeToken;
        }
    }

    /**
     * 服务器Ping接口
     * @return 服务器连通性结果，true表示服务器正常
     */
    public boolean ping() {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlBuilder(NavidromeAPIEnum.PING, null)))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 根据HTTP状态码判断服务器是否可用
            int statusCode = response.statusCode();
            if (statusCode == 200) {
                return true; // 成功状态码表示服务在线
            } else {
                throw new NavidromeException(Objects.requireNonNull(NavidromeExceptionEnum.getByVal(String.valueOf(statusCode))));
            }
        } catch (IOException e) {
            // 网络错误、连接失败等情况
            throw new NavidromeException(NavidromeExceptionEnum.INTERNAL_SERVER_ERROR, e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 恢复中断状态
            throw new NavidromeException(NavidromeExceptionEnum.INTERNAL_SERVER_ERROR, e);
        }
    }


}
