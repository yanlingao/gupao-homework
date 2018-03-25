package lazy_mode;

/**
 * 使用静态内部类实现单例模式
 * 避免了饿汉式的内存浪费问题
 * 也避免了线程安全问题
 * 同时也不需要锁的开销导致的性能下降
 * @author AYL    2018/3/25 8:38
 */
public class Lazy_InnerClass {
    private static boolean initialized = false;
    //反射可以访问私有属性和方法
    //在构造函数中可以通过如下操作避免反射入侵
    private Lazy_InnerClass(){
        synchronized (Lazy_InnerClass.class){
            if(! initialized){
                initialized = !initialized;
            } else {
                throw new RuntimeException("单例已经被入侵");
            }
        }
    }

    //static是为了保证单例的内存空间共享
    //final保证这个方法不会被重载
    public static final Lazy_InnerClass getInstance(){
        return inner.lazy_innerClass;
    }

    //在外部类被调用的时候内部类才会被加载
    private static class inner{
        private static Lazy_InnerClass lazy_innerClass = new Lazy_InnerClass();
    }
}
