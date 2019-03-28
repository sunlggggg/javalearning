package com.github.sunlggggg.javalearning.classloader;


import com.github.sunlggggg.util.Log;

import java.net.URL;
import java.util.Arrays;

import static com.github.sunlggggg.util.Log.println;

/**
 * @author sunligang
 * @date 2019/03/28
 */
public class ParentalEntrustment {
    public static void main(String[] args) {
        Class<?> clazz = ParentalEntrustment.class;
        ClassLoader classLoader01 = clazz.getClassLoader();
        println(classLoader01);
        assert classLoader01 != null;
        ClassLoader classLoader02 = classLoader01.getParent();
        println(classLoader02);
        assert classLoader02 != null;
        ClassLoader classLoader03 = classLoader02.getParent();
        println(classLoader03);

        URL[] urLs = sun.misc.Launcher.getBootstrapClassPath().getURLs();

        println(sun.misc.Launcher.getBootstrapClassPath());
        // all the classes loaded by Bootstrap ClassLoader
        Arrays.stream(urLs).forEach(Log::println);

        ClassLoader classLoader = String.class.getClassLoader();
        // null，because of Bootstrap classLoader can not see by Java
        println(classLoader);
    }
}
