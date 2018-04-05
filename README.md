
####[字节码重组，自己编码实现JDK动态代理]

proxy_pattern/src/com/ayl/gupao/homework/proxy_pattern

###[3 kinds of factory pattern]

1.简单工厂
产品抽象成接口，在工厂类中根据指定名称生产产品。可以生产各种类型的产品，无规范标准。

2.工厂方法
工厂定义为接口。每个类别的产品实现工厂接口，在自己工厂内部完成产品生产。用户要获取到产品的话，需要先指定相应的工厂。

3.抽象工厂
工厂定义为抽象类，这个抽象工厂可以生产各种类别的产品（抽象方法），同时设计成抽象类的话可以在其中实现公共的业务逻辑。
抽象工厂的具体实现类中，调用各个产品各自的工厂进行产品生产。
抽象工厂是用户的主入口，拥有抽象工厂的对象后用户可以选择性地调用某个生产产品方法。并且如果有新的产品类别，用户调用端无需改动。

###[4 kinds of singleton pattern]

1.hungry
使用静态属性，共享内存空间，缺点：类不会被使用到的时候也会创建实例对象，造成内存空间浪费  优点：效率高

2.lazy
创建单例对象前判断是否已经被创建。 缺点：线程安全  优点：避免了hungry模式的内存空间浪费问题

3.lazy synchronized
创建单例对象方法增加synchronized锁。避免了线程安全，但是因为增加锁导致性能下降

4.lazy static inner class
利用静态内部类的“在外部类被调用的时候内部类才能被加载”的特性。即避免了线程安全，也解决了内存浪费。并且不需要增加synchronized锁。
在这里例子中也实现了增加boolean initialized属性避免反射入侵。


###[prototype implement and shallow copy and deep copy]
1. shallow copy
使用jdk自动的clonable接口实现。拷贝对象只是复制了原生对象的属性的内存地址。并没有属于自己的一份在内存中的空间。

2.deep copy
使用读取原生对象的字节码实现拷贝。得到的拷贝对象拥有自己独立的属性。

###[my own implementation of ibatis]
1.todo:parameterHandler/cachingExecutor/友好错误提示



