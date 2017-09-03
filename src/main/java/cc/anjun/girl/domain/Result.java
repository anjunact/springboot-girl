package cc.anjun.girl.domain;

import lombok.Data;

@Data
public class Result<T> {
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 最体内容
     */
    private T data;
}
