package utils;

import java.util.concurrent.TimeUnit;

public class SleepUtils {
    public static final void second(long seconds) {
        try{
            TimeUnit.SECONDS.sleep(seconds);
        }catch (InterruptedException e) {
            System.out.println("InterruptedException:" + e);
        }
    }
}
