
### [4 kinds of singleton pattern]

1. hungry
使用静态属性，共享内存空间，缺点：类不会被使用到的时候也会创建实例对象，造成内存空间浪费  优点：效率高
2. lazy
创建单例对象前判断是否已经被创建。 缺点：线程安全  优点：避免了hungry模式的内存空间浪费问题
3. lazy synchronized
创建单例对象方法增加synchronized锁。避免了线程安全，但是因为增加锁导致性能下降
4. lazy static inner class
利用静态内部类的“在外部类被调用的时候内部类才能被加载”的特性。即避免了线程安全，也解决了内存浪费。并且不需要增加synchronized锁。
在这里例子中也实现了增加boolean initialized属性避免反射入侵。




