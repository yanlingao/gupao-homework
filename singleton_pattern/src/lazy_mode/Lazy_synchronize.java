package lazy_mode;

/**
 * @author AYL    2018/3/25 8:01
 */
public class Lazy_synchronize {
    private Lazy_synchronize(){}

    private static Lazy_synchronize lazy_synchronize = null;

    //相对于第一种的懒汉模式，在方法上增加synchronized锁，可以保证线程安全问题。
    //但是加锁增加了开销，效率降低
    public static synchronized Lazy_synchronize getInstance(){
        if(lazy_synchronize == null){
            lazy_synchronize = new Lazy_synchronize();
        }
        return lazy_synchronize;
    }
}
