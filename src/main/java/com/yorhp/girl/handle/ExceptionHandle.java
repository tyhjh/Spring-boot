package com.yorhp.girl.handle;

import com.yorhp.girl.Exception.GirlException;
import com.yorhp.girl.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yorhp.girl.util.ResultUtil;

@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.erro(girlException.getCode(), girlException.getMessage());
        } else {
            logger.info("【系统异常】",e);
            return ResultUtil.erro(100, "未知错误");
        }
    }

}
