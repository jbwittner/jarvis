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
public class RepositoriesInterceptor extends GeneralInterceptor {

    Logger logger = LoggerFactory.getLogger(RepositoriesInterceptor.class);

    @Around("execution(* fr.jarvis.server.repositories.*.*(..))")
    public Object logInterceptor(ProceedingJoinPoint joinPoint) throws Throwable {

        final Object proceed = this.logExecutionTime(joinPoint, this.logger);

        return proceed;
    }

}