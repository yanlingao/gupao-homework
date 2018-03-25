package lazy_mode;

import java.util.concurrent.CountDownLatch;

/**
 * @author AYL    2018/3/25 7:08
 */
public class Lazy_Test {
    public static void main(String[] args) {
        Lazy lazy_ = Lazy.getInstance();
        Lazy lazy_11 = Lazy.getInstance();
        System.out.println(lazy_ == lazy_11);

        long start = System.currentTimeMillis();
        int count = 2000;
        CountDownLatch latch = new CountDownLatch(count);
        for(int i = 0; i< count; i++){
            new Thread(){
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Lazy.getInstance());
                }
            }.start();
            latch.countDown();
        }
        long end = System.currentTimeMillis();
        System.out.println("total milseconds:" + (end - start));
    }
}
