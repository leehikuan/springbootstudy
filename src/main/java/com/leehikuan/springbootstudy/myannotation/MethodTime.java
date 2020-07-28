package com.leehikuan.springbootstudy.myannotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodTime {
    String value() default "方法";
}
