package func_factory;

/**
 * @author AYL    2018/3/24 19:43
 */
public class Func_FactoryTest {
    public static void main(String[] args) {
        //与简单工厂相比，工厂方法模式中，工厂也有了细分，A类产品由A工厂生产，B类产品由B类工厂生产
        Factory factory = new AFactory();
        factory.getProduct();
    }
}
