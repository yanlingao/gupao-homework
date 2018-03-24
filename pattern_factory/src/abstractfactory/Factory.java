package abstractfactory;

import entity.Product;

/**
 * 抽象工厂是用户的主入口
 *
 * @author AYL    2018/3/24 19:52
 */
public abstract class Factory {
    //设定成抽象类而不是接口，可以在这个抽象工厂类中写一些公共的业务逻辑

    abstract Product produceProductA();

    abstract Product produceProductB();
}
