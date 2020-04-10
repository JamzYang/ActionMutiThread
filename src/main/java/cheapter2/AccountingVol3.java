package cheapter2;

/**
 * @author yang
 * Date 2020/4/9 22:33
 * 错误的同步范例
 */
public class AccountingVol3 implements Runnable {
    static AccountingVol3 instance = new AccountingVol3();
    static volatile int j = 0;
    public  synchronized void  increase(){
        j++;
    }
    public void run() {
        for (int i = 0; i < 100000000; i++) {
            increase();
        }
    }



    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AccountingVol3());
        t1.setName("t1");
        Thread t2 = new Thread(new AccountingVol3());
        t2.setName("t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("j="+j);
    }
}
