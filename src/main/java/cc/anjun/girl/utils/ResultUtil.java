package cc.anjun.girl.utils;

import cc.anjun.girl.domain.Result;

public class ResultUtil {
    public static Result sucess(Object obj){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(obj);
        return  result;
    }
    public static Result sucess(){
        return sucess(null);
    }
    public  static Result error(Integer code ,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
