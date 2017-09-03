package cc.anjun.girl.handle;

import cc.anjun.girl.domain.Result;
import cc.anjun.girl.exception.GirlException;
import cc.anjun.girl.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ExceptionHandle {
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException ge = (GirlException) e;
            return ResultUtil.error(ge.getCode(),ge.getMessage());
        }else{
            log.error("[系统异常:{}]",e);
            return ResultUtil.error(-1,"未知错误");
        }

    }
}
