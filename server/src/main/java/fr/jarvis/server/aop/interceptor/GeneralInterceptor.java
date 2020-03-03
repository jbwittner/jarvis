package fr.jarvis.server.aop.interceptor;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;

public class GeneralInterceptor {

    public Object logExecutionTime(ProceedingJoinPoint joinPoint, Logger logger) throws Throwable {
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