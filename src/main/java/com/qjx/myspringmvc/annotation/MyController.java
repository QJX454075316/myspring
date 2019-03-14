package com.qjx.myspringmvc.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyController {
    /**
     * controller 的注册名
     */
    String value() default "";
}
