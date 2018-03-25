package lazy_mode;

import java.util.concurrent.CountDownLatch;

/**
 * @author AYL    2018/3/25 7:08
 */
public class Lazy_InnerClass_Test {
    public static void main(String[] args) {
        Lazy_InnerClass lazy_ = Lazy_InnerClass.getInstance();
        Lazy_InnerClass lazy_11 = Lazy_InnerClass.getInstance();
        System.out.println(lazy_ == lazy_11);

        long start = System.currentTimeMillis();
        int count = 200;
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
                    System.out.println(Lazy_InnerClass.getInstance());
                }
            }.start();
            latch.countDown();
        }
        long end = System.currentTimeMillis();
        System.out.println("total milseconds:" + (end - start));
    }
}
