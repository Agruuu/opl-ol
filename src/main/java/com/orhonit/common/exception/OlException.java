package com.orhonit.common.exception;

import com.orhonit.common.enums.ResultEnum;

/**
 * @auther:Agruuu
 */
public class OlException extends RuntimeException {

    private Integer code;

    public OlException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
    public OlException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
