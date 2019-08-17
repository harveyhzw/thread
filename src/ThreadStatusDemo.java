import java.util.concurrent.TimeUnit;

public class ThreadStatusDemo {
/**
 * "Thread_Block_2" #14 prio=5 os_prio=0 tid=0x00000000186eb800 nid=0x1f2c waiting for monitor entry [0x000000001955f000]
 *    java.lang.Thread.State: BLOCKED (on object monitor)
 *         at Thread_Block.run(ThreadStatusDemo.java:53)
 *         - waiting to lock <0x00000000d6094000> (a java.lang.Class for Thread_Block)
 *         at java.lang.Thread.run(Thread.java:748)
 *
 * "Thread_Block_1" #13 prio=5 os_prio=0 tid=0x00000000186eb000 nid=0x3820 waiting on condition [0x000000001945f000]
 *    java.lang.Thread.State: TIMED_WAITING (sleeping)
 *         at java.lang.Thread.sleep(Native Method)
 *         at java.lang.Thread.sleep(Thread.java:340)
 *         at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
 *         at Thread_Block.run(ThreadStatusDemo.java:53)
 *         - locked <0x00000000d6094000> (a java.lang.Class for Thread_Block)
 *         at java.lang.Thread.run(Thread.java:748)
 *
 * "Thread_Wait" #12 prio=5 os_prio=0 tid=0x00000000186ea000 nid=0x175c in Object.wait() [0x000000001935f000]
 *    java.lang.Thread.State: WAITING (on object monitor)
 *         at java.lang.Object.wait(Native Method)
 *         - waiting on <0x00000000d60922c0> (a java.lang.Class for Thread_Wait)
 *         at java.lang.Object.wait(Object.java:502)
 *         at Thread_Wait.run(ThreadStatusDemo.java:36)
 *         - locked <0x00000000d60922c0> (a java.lang.Class for Thread_Wait)
 *         at java.lang.Thread.run(Thread.java:748)
 *
 * "Thread_TimeWaiting" #11 prio=5 os_prio=0 tid=0x00000000186ee000 nid=0x2568 waiting on condition [0x000000001925f000]
 *    java.lang.Thread.State: TIMED_WAITING (sleeping)
 *         at java.lang.Thread.sleep(Native Method)
 *         at java.lang.Thread.sleep(Thread.java:340)
 *         at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
 *         at Thread_TimeWaiting.run(ThreadStatusDemo.java:21)
 *         at java.lang.Thread.run(Thread.java:748)
 */
    public static void main(String[] args) {
        new Thread(new Thread_TimeWaiting(), "Thread_TimeWaiting").start();

        new Thread(new Thread_Wait(), "Thread_Wait").start();

        new Thread(new Thread_Block(), "Thread_Block_1").start();
        new Thread(new Thread_Block(), "Thread_Block_2").start();
    }
}

class Thread_TimeWaiting implements  Runnable {

    @Override
    public void run() {
        while(true) {
            try {
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread_Wait implements  Runnable {

    @Override
    public void run() {
        synchronized (Thread_Wait.class) {
            while(true) {
                try {
                    Thread_Wait.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

class Thread_Block implements  Runnable {

    @Override
    public void run() {
        synchronized (Thread_Block.class) {
            while(true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

