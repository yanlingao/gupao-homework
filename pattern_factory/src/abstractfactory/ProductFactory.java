package abstractfactory;

import entity.Product;

/**
 * @author AYL    2018/3/25 0:18
 */
public class ProductFactory extends Factory {
    @Override
    Product produceProductA() {
        return new AFactory().produceProduct();
    }

    @Override
    Product produceProductB() {
        return new BFactory().produceProduct();
    }
}
