package func_factory;

import entity.Product;
import entity.ProductB;

/**
 * @author AYL    2018/3/24 19:42
 */
public class BFactory implements Factory {
    @Override
    public Product getProduct() {
        return new ProductB();
    }
}
