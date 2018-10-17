package com.github.sunlggggg.javalearning.utils.logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 个人日志工具类实现
 *
 * @author sunlggggg
 * @date 2018-05-11 20:49.
 */
public class Logger {

    public static class Builder {
        public static Logger getLogger(Class<?> clazz) {
            return new Logger(clazz);
        }
    }

    private static final int COMPLETE_DISPLAY_PACKAGE_NAME = 2;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private StringBuilder simpleClazzName = new StringBuilder();

    private Calendar calendar = Calendar.getInstance();

    Logger(Class<?> clazz) {
        String[] packageNameArray = clazz.getName().split("\\.");
        for (int i = 0; i < packageNameArray.length; i++) {
            if (i < packageNameArray.length - COMPLETE_DISPLAY_PACKAGE_NAME) {
                simpleClazzName.append(packageNameArray[i], 0, 1);
            } else {
                simpleClazzName.append(packageNameArray[i]);
            }
            if (i < packageNameArray.length - 1) {
                simpleClazzName.append(".");
            }
        }
    }


    public void info(Object info) {
        System.out.println(simpleDateFormat.format(calendar.getTime()) + "[" + simpleClazzName + "] info : " + info);
    }

    public void err(Object info) {
        System.err.println(simpleDateFormat.format(calendar.getTime()) + "[" + simpleClazzName + "]  err : " + info);
    }

    public void warn(Object info) {
        System.err.println(simpleDateFormat.format(calendar.getTime()) + "[" + simpleClazzName + "] warm : " + info);
    }

    public void blackLine() {
        System.out.println();
    }
}
