package chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yang
 * Date 2020/4/12 14:10
 */
public class TryLock implements Runnable {
    static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            String name = Thread.currentThread().getName();
            if(lock.tryLock()){
                System.out.println(name+"获得了锁..");
            }else{
                System.out.println(name+"没获取到锁...");
            }

        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new TryLock(),"t1");
        Thread t2 = new Thread(new TryLock(),"t2");
        t1.start();
        t2.start();
    }
}
