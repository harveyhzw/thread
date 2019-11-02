package InterruptDemo;

import java.util.concurrent.TimeUnit;

public class InterruptDemo1  {
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadTest1(), "Thread1_interrupt");
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt(); //安全 优雅
    }
}

class ThreadTest1 implements Runnable{
    @Override
    public void run() {
        while(true){
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("before: " + Thread.currentThread().isInterrupted());
                Thread.interrupted();
                System.out.println("after: " + Thread.currentThread().isInterrupted());
            }
        }
    }
}

