package waitAndNotify;

import utils.SleepUtils;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitAndNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) {
        Thread waitThread = new Thread(new Wait());
        waitThread.start();
        SleepUtils.second(1);

        Thread notifyThread  = new Thread(new Notify());
        notifyThread.start();
    }

    static class Wait implements Runnable{

        @Override
        public void run() {

            // monitor.enter
            synchronized (lock) {
                while(flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true. wait @ "
                                + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait(); // monitor.exit -> go to WaitQueue
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread() + " flag is false. running @ "
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));

            }
        }
    }

    static class Notify implements Runnable{

        @Override
        public void run() {
            //monitor.enter
            synchronized (lock){
                System.out.println(Thread.currentThread() + " hold lock. notify @ "
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notify();
                flag = false;
                SleepUtils.second(5);
            }
            // monitor.enter again
            synchronized (lock){
                System.out.println(Thread.currentThread() + "  hold lock again. running @ "
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5);
            }

        }
    }
}
