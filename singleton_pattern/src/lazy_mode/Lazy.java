package lazy_mode;

/**
 * @author AYL    2018/3/25 7:19
 */
public class Lazy {
    private Lazy(){}

    private static Lazy lazy_ = null;

    //懒汉式1
    //在需要使用到的时候再创建对象
    //优点：减少了内存资源的浪费
    //缺点：但是存在线程安全问题。如果两个线程在微秒/纳秒级别同时访问这个类获取对象，则可能出现创建出两个不同的Lazy_1对象
    public static Lazy getInstance(){
        if(lazy_ == null){
            lazy_ = new Lazy();
        }
        return lazy_;
    }
}
