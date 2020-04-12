package chapter3;

import java.util.concurrent.CountDownLatch;

/**
 * @author yang
 * Date 2020/4/12 17:44
 */
public class CountDownLatchDemo implements Runnable  {
    public static CountDownLatch latch = new CountDownLatch(10);
    private int waitTime = 2000;


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+"started");
        try {
            Thread.sleep(waitTime);
            System.out.println(name+" check completed");
            waitTime += 500;
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 1; i < 11; i++) {
            Thread t = new Thread(new CountDownLatchDemo(), "t" + i);
            t.start();
        }
        try {
            latch.await();
            System.out.println("FIRE!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()-start);
    }
}
