package Q6_装饰模式;

import Q6_装饰模式.Shape.Shape;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/01/2021 11:24
 **/

public class RedShapeDecorator extends ShapeDecorator{
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}
