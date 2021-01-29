package Q6_装饰模式;

import Q6_装饰模式.Shape.Shape;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/01/2021 11:08
 **/

public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;
    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        this.decoratedShape.draw();
    }
}
