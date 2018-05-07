package xyz.neolith.javalearning.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationDemo {
    @PermissionChecker({UserType.COSTOMER})
    public void test02() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> demoClass = Class.forName("xyz.neolith.javalearning.annotation.AnnotationDemo");
        Method method = demoClass.getMethod("test02");
        PermissionChecker permissionChecker = method.getAnnotation(PermissionChecker.class);
        for (UserType userType : permissionChecker.value()) {
            System.out.println(userType);
        }
    }

    @PermissionChecker({UserType.COSTOMER, UserType.MANAGER})
    public void test01() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> demoClass = Class.forName("xyz.neolith.javalearning.annotation.AnnotationDemo");
        Method method = demoClass.getMethod("test01");
        PermissionChecker permissionChecker = method.getAnnotation(PermissionChecker.class);
        for (UserType userType : permissionChecker.value()) {
            System.out.println(userType);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        new AnnotationDemo().test01();
        System.out.println();
        new AnnotationDemo().test02();
    }
}
