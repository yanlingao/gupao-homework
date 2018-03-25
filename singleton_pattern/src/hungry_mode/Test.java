package hungry_mode;

/**
 * @author AYL    2018/3/25 7:08
 */
public class Test {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton == singleton1);

        long start = System.currentTimeMillis();
        for(int i = 0; i< 20000000; i++){
            System.out.println(Singleton.getInstance());
        }
        long end = System.currentTimeMillis();
        System.out.println("total milseconds:" + (end - start));
    }
}
