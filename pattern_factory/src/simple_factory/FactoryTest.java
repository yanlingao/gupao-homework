package simple_factory;


import entity.Product;
import entity.ProductA;

/**
 * @author AYL    2018/3/24 19:03
 */
public class FactoryTest {
    public static void main(String[] args) {
        Factory factory = new Factory();

        //简单工厂模式，工厂中可以生产任何类型的产品
        //在调用过程中，“A”可能传错
        factory.produceProduct("A");
    }
}
