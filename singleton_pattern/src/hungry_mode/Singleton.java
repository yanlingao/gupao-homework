package hungry_mode;

/**
 * @author AYL    2018/3/25 6:51
 */
public class Singleton {
    private Singleton(){}
    //静态属性，保证了资源的共享
    //在类加载的时候就立即初始化，并且创建单例对象
    //优点：没有线程安全问题，性能高
    //缺点：存在这个类不被使用到的情况，不管三七二十一先创建对象，对内存资源造成浪费
    //final关键字保证了创建的对象实例不会因为继承等被改写
    private static final Singleton singleton = new Singleton();

    public static Singleton getInstance(){
        return singleton;
    }
}
