package com.senla.haltvinizki.util;

public class Logger {


    public static void execute(Class clazz, Exception e) {
        System.out.println(clazz.getName() +" "+ e);
    }
}
