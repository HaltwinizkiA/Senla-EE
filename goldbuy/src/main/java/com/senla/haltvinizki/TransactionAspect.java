package com.senla.haltvinizki;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


import java.sql.Connection;

@Aspect
@Component
public class TransactionAspect {

    private final Connection connection;

    public TransactionAspect(Connection connection) {
        this.connection = connection;
    }

    @Around("@within(com.senla.haltvinizki.annotation.Transactional) || @annotation(com.senla.haltvinizki.annotation.Transactional)")
    public Object runInTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            connection.setAutoCommit(false);
            Object object = joinPoint.proceed();
            connection.commit();
            return object;
        } catch (RuntimeException r) {
            connection.rollback();
            throw r;
        } finally {
            connection.setAutoCommit(true);
        }

    }
}
