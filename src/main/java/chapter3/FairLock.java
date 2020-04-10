package chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yang
 * Date 2020/4/10 17:08
 */
public class FairLock implements Runnable {
    public static ReentrantLock fairLock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true){
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName()+"获得锁");
            }finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new FairLock(), "t1");
        Thread t2 = new Thread(new FairLock(), "t2");
        Thread t3 = new Thread(new FairLock(), "t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
