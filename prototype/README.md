

### prototype implement   
1. shallow copy  
使用jdk自动的clonable接口实现。拷贝对象只是复制了原生对象的属性的内存地址。并没有属于自己的一份在内存中的空间。
2. deep copy
使用读取原生对象的字节码实现拷贝。得到的拷贝对象拥有自己独立的属性。


