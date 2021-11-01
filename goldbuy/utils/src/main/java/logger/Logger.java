package logger;

public class Logger {


    public static void log(Class clazz, String message) {

        log(clazz.getName() + "   " + message);

    }

    public static void log(String message) {

        System.out.println("Logger : "+message);

    }

    public static void log(Class clazz, Exception e) {
        log(clazz + "  " + e);
    }

    public static void log(String message, Throwable cause) {

        log(message + cause);

    }
}
