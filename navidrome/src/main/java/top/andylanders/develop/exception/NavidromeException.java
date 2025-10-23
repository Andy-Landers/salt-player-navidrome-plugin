package top.andylanders.develop.exception;

import top.andylanders.develop.exception.dict.NavidromeExceptionEnum;

import java.util.Objects;

public class NavidromeException extends RuntimeException {
    public NavidromeException(NavidromeExceptionEnum Dict) {
        super(Dict.getDesc());
    }

    public NavidromeException(String errorCode) {
        super(Objects.requireNonNull(NavidromeExceptionEnum.getByVal(errorCode)).getDesc());
    }

    public NavidromeException(NavidromeExceptionEnum Dict, Throwable cause) {
        super(Dict.getDesc(), cause);
    }
}
