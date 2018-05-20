package xyz.neolith.javalearning.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解用于用户权限检查
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface PermissionChecker {
    UserType[] value() default UserType.TOURIST;
}
