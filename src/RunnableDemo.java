public class RunnableDemo implements Runnable {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableDemo());
        Thread thread2 = new Thread(new RunnableDemo());

        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        System.out.println("Implements Runnable run()..");
    }
}
