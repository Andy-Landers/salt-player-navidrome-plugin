package top.andylanders.develop.dict;

/**
 * Navidrome API枚举
 * @author Andy Landers
 * @date 2025-10-23
 * @description 通过此枚举可以快速通过URL构建器组装API请求URL
 */
public enum NavidromeAPIEnum {
    //TODO 接口列表待完善，接口来源地址：https://www.subsonic.org/pages/api.jsp

    GET_SONG("/getSong", "获取歌曲详细信息"),
    PING("/ping", "服务器验活"),
    STREAM("/stream", "流式传输"),
    DOWNLOAD("/download", "下载媒体文件"),
    HLS("/hls.m3u8", "HLS流式传输"),
    SEARCH2("/search2", "分页搜索"),
    SEARCH3("/search3", "分页搜索（支持根据ID3标签聚合）"),
    ;
    private String val;
    private String desc;

    NavidromeAPIEnum(String val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    public String getVal() {
        return this.val;
    }
}
