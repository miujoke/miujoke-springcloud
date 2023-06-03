package com.miujoke.common.annotation;

import java.lang.annotation.*;

/**
 * @author miujoke
 * @date 2023/6/4 0:23
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IdempotentAnnotation {
    String key() default "";

    long expireTime() default 30;
}
