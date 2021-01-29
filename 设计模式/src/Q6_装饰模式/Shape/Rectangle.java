package Q6_装饰模式.Shape;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/01/2021 11:07
 **/

public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("this is a rectangle");
    }
}
