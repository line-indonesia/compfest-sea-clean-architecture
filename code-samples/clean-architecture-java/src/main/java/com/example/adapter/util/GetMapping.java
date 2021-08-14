package com.example.adapter.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface GetMapping {
    String value() default "";
}
