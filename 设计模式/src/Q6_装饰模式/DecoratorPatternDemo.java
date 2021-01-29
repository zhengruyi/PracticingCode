package Q6_装饰模式;

import Q6_装饰模式.Shape.Circle;
import Q6_装饰模式.Shape.Rectangle;
import Q6_装饰模式.Shape.Shape;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/01/2021 11:25
 **/

public class DecoratorPatternDemo {
    public static void main(String[] args) {

        Shape circle = new Circle();
        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
        //Shape redCircle = new RedShapeDecorator(new Circle());
        //Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
