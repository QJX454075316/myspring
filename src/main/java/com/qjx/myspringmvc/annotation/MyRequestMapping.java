package com.qjx.myspringmvc.annotation;

import java.lang.annotation.*;

/**
 * 定义RequestMapping 的注解
 * @author qjx
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestMapping {
    /**
     * url
     */
    String value() default "";
}
