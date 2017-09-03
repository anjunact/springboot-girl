package cc.anjun.girl.exception;

import cc.anjun.girl.enums.ResultEnum;
import lombok.Data;

@Data
public class GirlException extends  RuntimeException {
    private Integer code;
    public  GirlException(ResultEnum re){
        super((re.getMsg()));
        this.code=re.getCode();
    }
}
