package abstractfactory;

import entity.Product;
import entity.ProductA;

/**
 * @author AYL    2018/3/24 19:53
 */
public class AFactory {

    Product produceProduct() {
        return new ProductA();
    }
}
