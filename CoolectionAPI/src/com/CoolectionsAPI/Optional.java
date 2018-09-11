package com.CoolectionsAPI;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
public @interface  Optional{
     String Default() default "";
}
