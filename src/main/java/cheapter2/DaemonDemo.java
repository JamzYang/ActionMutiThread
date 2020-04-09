package cheapter2;

/**
 * @author yang
 * Date 2020/4/9 21:11
 */
public class DaemonDemo {
    public static class DaemonTread extends Thread{
        @Override
        public void run() {
            while(true){
                System.out.println("I'm daemon thread, I am alive!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        DaemonTread daemon = new DaemonTread();
//        daemon.setDaemon(true);   //如果将此行注释, 线程为不停的打印.
        daemon.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
