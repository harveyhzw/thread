import java.util.concurrent.TimeUnit;

public class InterruptExceptionDemo  {
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadExceptionTest(), "ThreadExceptionTest");
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("before: " + thread.isInterrupted());

        thread.interrupt(); //安全 优雅

        System.out.println("after: " + thread.isInterrupted());
    }
}

class ThreadExceptionTest implements Runnable{

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {  //InterruptedException异常的抛出并不意味 着线程必须终止，而是提醒当前线程有中断的操作发生，
                e.printStackTrace();
            }

            System.out.println("run");
        }
    }
}
