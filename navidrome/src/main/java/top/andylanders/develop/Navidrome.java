package top.andylanders.develop;

import top.andylanders.develop.exception.NavidromeException;
import top.andylanders.develop.exception.dict.NavidromeExceptionEnum;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

/**
 * Navidrome Object
 * @author Andy Landers
 * @date 2025-10-23
 * @description 用于实现对Navidrome服务器的连接与各种拓展接口调用的工具包，包括流式传输与获取媒体ID3信息等功能。
 */
public class Navidrome {

    private String navidromeUrl;
    private String navidromeToken;
    private String username;
    private String password;

    public Navidrome() {
        loadConfig();
    }

    private void loadConfig() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            this.navidromeUrl = properties.getProperty("navidromeUrl");
            this.username = properties.getProperty("username");
            this.password = properties.getProperty("password");
            this.navidromeToken = properties.getProperty("navidromeToken");
        } catch (IOException e) {
            throw new NavidromeException(NavidromeExceptionEnum.WRONG_CONFIG);
        }
    }

    // 检测服务器是否在线
    public boolean ping() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.navidromeUrl))
                .build();
        HttpResponse response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            //todo 此处存疑，抛出异常的时候到底能不能捕获到response？要怎么做才能捕获到http状态码然后按状态码优雅抛出自定义异常？
//            throw new NavidromeException(String.valueOf(response.statusCode()));
            throw new RuntimeException(e);
        }
        return true;
    }

}
