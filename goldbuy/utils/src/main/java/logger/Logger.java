package logger;

public class Logger {


    public void log(Class clazz, String message) {

        log(clazz.getName() + "   " + message);

    }

    public void log(String message) {

        System.out.println("Logger : "+message);

    }

    public void log(Class clazz, Exception e) {
        log(clazz + "  " + e);
    }

    public void log(String message, Throwable cause) {

        log(message + cause);

    }
}
