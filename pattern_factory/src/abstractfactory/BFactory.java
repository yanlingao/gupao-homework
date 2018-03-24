package abstractfactory;

import entity.Product;
import entity.ProductA;
import entity.ProductB;

/**
 * @author AYL    2018/3/24 19:53
 */
public class BFactory {

    Product produceProduct() {
        return new ProductB();
    }
}
