package chapter2;

/**
 * @author yang
 * Date 2020/4/9 22:33
 */
public class AccountingVol implements Runnable {
    static AccountingVol instance = new AccountingVol();
    static volatile int j = 0;
    public  synchronized void  increase(){
        j++;
    }
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("j="+j);
    }
}
