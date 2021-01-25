package Q1_工厂模式;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/01/2021 20:54
 **/

/**
 * 意图：定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。
 * 不用向客户端暴露创建逻辑,适用于复杂对象的创建,而不适用于简单对象的创建
 * 如何解决：让其子类实现工厂接口(Shape接口)，返回的也是一个抽象的产品。
 *
 * 优点： 1、一个调用者想创建一个对象，只要知道其名称就可以了。 2、扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以。
 * 3、屏蔽产品的具体实现，调用者只关心产品的接口。
 *
 * 缺点：每次增加一个产品时，都需要增加一个具体类和对象实现工厂，使得系统中类的个数成倍增加，在一定程度上增加了系统的复杂度，
 * 同时也增加了系统具体类的依赖。这并不是什么好事。
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory sf = new ShapeFactory();
        Shape s1 = sf.getShape("SQUARE");
        s1.draw();
        Shape s2 = sf.getShape("CIRCLE");
        s2.draw();
        Shape s3 = sf.getShape("RECTANGLE");
        s3.draw();
    }
}
