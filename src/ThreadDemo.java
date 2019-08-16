public class ThreadDemo extends Thread{

    public static void main(String[] args) {
        ThreadDemo thread1 = new ThreadDemo();
        ThreadDemo thread2 = new ThreadDemo();

        thread1.start();
        thread2.start();
    }
    @Override
    public void run() {
        super.run();
        System.out.println("Extend class Thread run () ...");
    }
}
