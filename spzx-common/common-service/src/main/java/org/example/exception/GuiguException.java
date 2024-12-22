package org.example.exception;

import lombok.Data;
import org.example.spzx.model.vo.common.ResultCodeEnum;

@Data
public class GuiguException extends RuntimeException {

    private Integer code ;          // 错误状态码
    private String message ;        // 错误消息

    private ResultCodeEnum resultCodeEnum ;     // 封装错误状态码和错误消息

    public GuiguException(ResultCodeEnum resultCodeEnum) {
        this.resultCodeEnum = resultCodeEnum ;
        this.code = resultCodeEnum.getCode() ;
        this.message = resultCodeEnum.getMessage();
    }

    public GuiguException(Integer code , String message) {
        this.code = code ;
        this.message = message ;
    }

}