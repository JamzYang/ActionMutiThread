package chapter2;

/**
 * @author yang
 * Date 2020/4/9 22:33
 * 错误范例 代码21行加了 synchronized 两个线程都拿不到锁了
 */
public class AccountingVol4 implements Runnable {
    static AccountingVol4 instance = new AccountingVol4();
    static volatile int j = 0;
    public static synchronized void  increase(){
        j++;
    }
    public void run() {
        for (int i = 0; i < 10000; i++) {
            increase();
        }
        System.out.println(Thread.currentThread().getName()+" is end.\t"+j);
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("j="+j);
    }
}
