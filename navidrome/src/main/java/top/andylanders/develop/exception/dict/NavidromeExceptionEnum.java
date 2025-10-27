package top.andylanders.develop.exception.dict;

public enum NavidromeExceptionEnum {
    NOT_FOUND("404", "未找到该资源"),
    UNAUTHORIZED("401", "未授权"),
    FORBIDDEN("403", "禁止访问"),
    NOT_ACCEPTABLE("406", "请求的资源不可接受"),
    REQUEST_TIMEOUT("408", "请求超时"),
    CONFLICT("409", "资源冲突"),
    UNSUPPORTED_MEDIA_TYPE("415", "不支持的媒体类型"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误"),
    WRONG_CONFIG("808", "配置文件有误"),
    XML_PARSE_ERROR("666", "XML返回捕获异常");

    private final String val;
    private final String desc;

    NavidromeExceptionEnum(String val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    public String getVal() {
        return val;
    }

    public String getDesc() {
        return desc;
    }

    public static NavidromeExceptionEnum getByVal(String val) {
        for (NavidromeExceptionEnum item : NavidromeExceptionEnum.values()) {
            if (item.val.equals(val)) {
                return item;
            }
        }
        return null;
    }
}
