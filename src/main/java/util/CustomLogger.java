package util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class CustomLogger {
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("HH:mm:ss");
    public static void logger(Object obj){
        String time = LocalTime.now().format(formatter);
        System.out.printf("%s [%10s] %s\n",time, Thread.currentThread().getName(), obj);
    }
}
