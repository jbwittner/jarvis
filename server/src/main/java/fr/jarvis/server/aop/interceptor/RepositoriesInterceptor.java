package fr.jarvis.server.aop.interceptor;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RepositoriesInterceptor {

    Logger logger = LoggerFactory.getLogger(RepositoriesInterceptor.class);

    @Around("execution(* fr.jarvis.server.repositories.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        final long start = System.currentTimeMillis();

        String method = joinPoint.getSignature().getDeclaringTypeName();
        method += "." + joinPoint.getSignature().getName();

        logger.info("ENTERING :: " + method);

        List<Object> list = Arrays.asList(joinPoint.getArgs());
        Iterator<Object> iterator =  list.iterator();

        while(iterator.hasNext()){
            Object object = iterator.next();
            logger.debug("Args list :: " + method + " :: " + object.toString());
        }
        final Object proceed = joinPoint.proceed();

        final long executionTime = System.currentTimeMillis() - start;

        logger.info("EXITING :: " + method + " executed in " + executionTime + "ms");

        return proceed;
    }

}