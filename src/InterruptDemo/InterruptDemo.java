package InterruptDemo;

import java.util.concurrent.TimeUnit;

public class InterruptDemo  {
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadTest(), "Thread_interrupt");
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       thread.interrupt(); //安全 优雅
    }
}

 class ThreadTest implements Runnable{

     private static int i;
     @Override
     public void run() {
         while(!Thread.currentThread().isInterrupted()){
             i++;
         }

         System.out.println("Num: " + i);
     }
 }
