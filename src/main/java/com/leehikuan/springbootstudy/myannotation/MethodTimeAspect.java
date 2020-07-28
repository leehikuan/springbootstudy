package com.leehikuan.springbootstudy.myannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 注解实现逻辑
 */
@Aspect
@Component
public class MethodTimeAspect {

    //切点
    @Pointcut("@annotation(com.leehikuan.springbootstudy.myannotation.MethodTime)")
    private void pointCut(){

    };

    //切点前执行
    @Before("pointCut()")
    public void beforeMethod(){
        System.out.println("我是before方法");
    }
    //切点后执行
    @After("pointCut()")
    public void afterMethod(){
        System.out.println("我是After方法");

    }
    
    @Around("pointCut()")
    public  <T> T around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("进入around方法");
        Long startTime = System.currentTimeMillis();

        Object[] args = pjp.getArgs();
        T result;
        Method methodClass;
        try {
            result = (T)pjp.proceed(args);//执行方法
        }finally {
            long endTime = System.currentTimeMillis();
            Signature signature = pjp.getSignature();
            String methodName = signature.getName();
            Class<?> targetClass = pjp.getTarget().getClass();
            Class[] parameterTypes = ((MethodSignature) pjp.getSignature()).getParameterTypes();
            methodClass = targetClass.getMethod(methodName, parameterTypes);
            Annotation[] annotations = methodClass.getAnnotations();
            for (Annotation annotation : annotations){
                Class<? extends Annotation> aClass = annotation.annotationType();
                String simpleName = aClass.getSimpleName();
                if("MethodTime".equals(simpleName)){
                    MethodTime timeConsume = (MethodTime) annotation;
                    String value = timeConsume.value();
//                    log.info(value+"[{}] 执行耗时：{}ms",methodName,endTime-startTime);
                    System.out.println(value+"[{}] 执行耗时：{}ms "+methodName+"  "+(endTime-startTime));
                    break;
                }
            }

        }
        System.out.println("result======"+result);
        return result;
    }

}
