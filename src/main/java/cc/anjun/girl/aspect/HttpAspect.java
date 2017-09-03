package cc.anjun.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.context.request.RequestContextHolder.getRequestAttributes;

@Component
@Aspect
public class HttpAspect {
    Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * cc.anjun.girl.controller.GirlController.*(..))")
    public void log() {

    }

    @Before("log()")
    public void beforeDo(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("url:{}",request.getRequestURL());
        logger.info("ip:{}",request.getRemoteAddr());
        logger.info("method:{}",request.getMethod());
        logger.info("class_mothed={}",joinPoint.getSignature().getDeclaringTypeName()+joinPoint.getSignature().getName());


        logger.info("args:{}",joinPoint.getArgs());
    }

    @After("log()")
    public void afterDo() {

        logger.info("2222");
    }
    @AfterReturning(pointcut = "log()",returning = "obj")
    public void doAfterReturning(Object obj){
        logger.info("response:{}",obj.toString());
    }
}
