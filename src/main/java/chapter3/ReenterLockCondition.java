package chapter3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yang
 * Date 2020/4/12 16:17
 */
public class ReenterLockCondition implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("Thread is going to be waited");
            condition.await();
//            synMethod();
            System.out.println("Thread is going on");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ReenterLockCondition(),"t1");
        t1.start();
        Thread.sleep(2000);
        lock.lock();    // condition.signal()之前要获取锁
        condition.signal();
        lock.unlock();  //被唤醒的线程要执行必须先获取锁, 所以这里必须要释放锁.
    }

    public synchronized void synMethod(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
