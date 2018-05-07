package xyz.neolith.javalearning.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface PermissionChecker {
    UserType[] value() default UserType.TOURIST;
}
