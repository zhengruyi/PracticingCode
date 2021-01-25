package Q2_抽象工厂.Shape;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/01/2021 21:17
 **/

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
