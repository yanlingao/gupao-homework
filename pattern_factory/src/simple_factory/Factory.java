package simple_factory;

import entity.Product;
import entity.ProductA;
import entity.ProductB;

/**
 * 简单工厂模式，工厂中可以生产任何类型的产品
 *
 * @author AYL    2018/3/24 19:11
 */
public class Factory {
    public Product produceProduct(String name){
        if("A".equals(name)){
            return new ProductA();
        } else if("B".equals(name)){
            return new ProductB();
        } else {
            System.out.println("can not produce this kind of product.");
            return null;
        }
    }
}
