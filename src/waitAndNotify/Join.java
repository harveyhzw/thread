package waitAndNotify;

import java.util.concurrent.TimeUnit;

public class Join {

    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for(int i=0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }

        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminated.");
    }


    static class Domino implements Runnable{

        private Thread previousThread;
        public Domino(Thread previousThread) {
            this.previousThread = previousThread;
        }

        @Override
        public void run() {
            try {
                previousThread.join();
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " terminated.");

        }
    }
}
