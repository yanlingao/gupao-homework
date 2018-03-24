package func_factory;

import entity.Product;
import entity.ProductA;

/**
 * @author AYL    2018/3/24 19:41
 */
public class AFactory implements Factory {
    @Override
    public Product getProduct() {
        return new ProductA();
    }
}
