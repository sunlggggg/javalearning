package xyz.neolith.javalearning.utils.logger;

/**
 * 个人日志小工具
 *
 * @author sunlggggg
 * @date 2018-05-11 20:42.
 */
public class LoggerUtil {
    public static Logger getLogger(Class<?> clazz) {
        return new Logger(clazz);
    }
}
