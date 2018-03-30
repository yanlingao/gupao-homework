package shallow_copy;

import java.util.Date;

/**
 * @author AYL    2018/3/30 23:50
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        QiTianDaShen qiTianDaShen = new QiTianDaShen();
        qiTianDaShen.setBirthday(new Date());
        JinGuBang jinGuBang = new JinGuBang();
        qiTianDaShen.setJinGuBang(jinGuBang);

        QiTianDaShen copy = (QiTianDaShen)qiTianDaShen.clone();

        System.out.println(qiTianDaShen == copy);
        System.out.println(qiTianDaShen.getJinGuBang());
        System.out.println(copy.getJinGuBang());
        System.out.println(qiTianDaShen.getJinGuBang() == copy.getJinGuBang());
        /**
         * 打印结果如下：
         * false
         * java.lang.Object@2ac1fdc4
         * java.lang.Object@2ac1fdc4
         * true
         * 使用jdk的clonable接口实现的clone方法，只是将对象中属性的内存地址进行拷贝，拷贝后的对象共用了原生对象的属性
         */
        copy.getJinGuBang().setD(200);
        System.out.println(qiTianDaShen.getJinGuBang().getD());
        System.out.println(copy.getJinGuBang().getD());
        /**
         * 打印结果：
         * 200
         * 200
         * 拷贝对象跟原生对象属性存储在同一个内存地址空间，copy对象对属性的改变会影响原生对象。
         * 就是所谓的浅拷贝。接下来我们读取原生对象的字节码方式实现深拷贝。
         */

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("----------------------------以下是深拷贝打印结果-------------------------------");
        System.out.println("---------------------------------------------------------------------------");
        QiTianDaShen copyDeep = (QiTianDaShen)qiTianDaShen.deepCopy();

        System.out.println(qiTianDaShen == copyDeep);
        System.out.println(qiTianDaShen.getJinGuBang());
        System.out.println(copyDeep.getJinGuBang());
        System.out.println(qiTianDaShen.getJinGuBang() == copyDeep.getJinGuBang());
        /**
         * 打印结果如下：
         * false
         * shallow_copy.JinGuBang@f5f2bb7
         * shallow_copy.JinGuBang@5d624da6
         * false
         */
        copyDeep.getJinGuBang().setD(888);
        System.out.println(qiTianDaShen.getJinGuBang().getD());
        System.out.println(copyDeep.getJinGuBang().getD());
        /**
         * 打印结果：
         * 200
         * 888
         * 拷贝对象跟原生对象是完全隔离的，拷贝对象完全拥有自己独立的一份属性。
         */
    }
}
