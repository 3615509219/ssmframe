package com.xtkj.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class TxContext {

    public void before(){
        System.out.println("前置通知");
    }
    public void after(){
        System.out.println("后置通知");
    }

    public Object round(ProceedingJoinPoint point){
        Object[] args = point.getArgs();
        System.out.println("方法执行前");
        Object object = null;
        try {
            object = point.proceed(args);
        } catch (Throwable throwable) {
            System.out.println("方法执行报错");
            throwable.printStackTrace();
        }
        System.out.println("方法执行后");
        return object;
    }
    public void ex(Exception e){
        System.out.println(e.getMessage());
    }
}
