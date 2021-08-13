package com.example.adapter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@interface GetMapping {
    String value() default "";
}
