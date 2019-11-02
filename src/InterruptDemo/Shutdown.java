package InterruptDemo;

import utils.SleepUtils;

public class Shutdown {

    public static void main(String[] args) {
        Runner runner1 = new Runner();
        Thread countThread = new Thread(runner1, "CountThread");
        countThread.start();

        SleepUtils.second(2);
        countThread.interrupt();

        Runner runner2 = new Runner();
        Thread countThread2 = new Thread(runner2, "CountThread2");
        countThread2.start();

        SleepUtils.second(2);
        runner2.cancel();


        SleepUtils.second(2);

    }

    private static class Runner implements Runnable{

        private long i;
        private volatile boolean on = true;

        @Override
        public void run() {
            while(on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i = " + i);
        }

        public void cancel(){
            on = false;
        }
    }
}
