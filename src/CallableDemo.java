import java.util.concurrent.*;

public class CallableDemo implements Callable<String> {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        CallableDemo callableDemo = new CallableDemo();

        Future<String> future = executorService.submit(callableDemo);

        try {
            String result  = future.get();
            System.out.println( result);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }


    @Override
    public String call() throws Exception {

        int a = 1;
        int b = 2;

        System.out.println(a+b);
        return "result : " + (a+b);
    }
}
