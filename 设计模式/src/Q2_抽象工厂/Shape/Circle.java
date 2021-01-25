package Q2_抽象工厂.Shape;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/01/2021 21:18
 **/

public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
