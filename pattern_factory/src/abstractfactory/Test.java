package abstractfactory;

/**
 * @author AYL    2018/3/25 0:45
 */
public class Test {
    public static void main(String[] args) {
        //抽象工厂类Factory是用户的主入口
        //用户只有选择权
        //如果有新的产品类别，在内部修改，client调用端无需更改
        Factory factory = new ProductFactory();
        factory.produceProductA();
    }
}
