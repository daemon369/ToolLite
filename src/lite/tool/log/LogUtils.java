package lite.tool.log;

import lite.tool.log.ILogger.Level;

public final class LogUtils {
    private static ILogger logger = null;
    private static DefaultLogger defaultLogger = null;

    public static boolean debug = false;
    public static final Level DEFAULT_LOG_LEVEL = Level.WARN;
    private static Level logLevel = Level.DEBUG;

    public static void setLogger(final ILogger logger) {
        LogUtils.logger = logger;
    }

    public static void setLogLevel(final Level level) {
        LogUtils.logLevel = level;
    }

    public static Level getLogLevel() {
        if (null == LogUtils.logLevel) {
            return DEFAULT_LOG_LEVEL;
        }

        return LogUtils.logLevel;
    }

    private static ILogger getDefaultLogger() {
        if (null == defaultLogger) {
            synchronized (LogUtils.class) {
                if (null == defaultLogger) {
                    defaultLogger = new DefaultLogger();
                }
            }
        }

        return defaultLogger;
    }

    static ILogger getLogger() {
        if (null != logger) {
            return logger;
        }

        return getDefaultLogger();
    }

    public static void v(String tag, String msg) {
        getLogger().v(tag, msg);
    }

    public static void v(String tag, String msg, Throwable tr) {
        getLogger().v(tag, msg, tr);
    }

    public static void d(String tag, String msg) {
        getLogger().d(tag, msg);
    }

    public static void d(String tag, String msg, Throwable tr) {
        getLogger().d(tag, msg, tr);
    }

    public static void i(String tag, String msg) {
        getLogger().i(tag, msg);
    }

    public static void i(String tag, String msg, Throwable tr) {
        getLogger().i(tag, msg, tr);
    }

    public static void w(String tag, String msg) {
        getLogger().w(tag, msg);
    }

    public static void w(String tag, String msg, Throwable tr) {
        getLogger().w(tag, msg, tr);
    }

    public static void w(String tag, Throwable tr) {
        getLogger().w(tag, tr);
    }

    public static void e(String tag, String msg) {
        getLogger().e(tag, msg);
    }

    public static void e(String tag, String msg, Throwable tr) {
        getLogger().e(tag, msg, tr);
    }
}
