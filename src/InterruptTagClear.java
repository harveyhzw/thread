import utils.SleepUtils;

import java.util.concurrent.TimeUnit;

public class InterruptTagClear {
    public static void main(String[] args) {
        Thread sleepThread = new Thread(new SleepRuner(), "SleepThread");
        sleepThread.setDaemon(true);

        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        SleepUtils.second(5);

        sleepThread.interrupt(); // cause InterruptedException exception
        busyThread.interrupt();

        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());

        SleepUtils.second(40);

    }

    static class SleepRuner implements Runnable{

        @Override
        public void run() {
            while(true) {
                SleepUtils.second(10);//before throw interrupted exception, the interrupt tag was be cleared
                System.out.println("SleepThread end");
            }

        }
    }

    static class BusyRunner implements Runnable{

        @Override
        public void run() {
            while(true) {
                System.out.println("BusyRunner running");
            }
        }
    }
}
