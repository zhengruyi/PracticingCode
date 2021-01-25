package Q2_抽象工厂.Factory;

import Q2_抽象工厂.Color.Color;
import Q2_抽象工厂.Shape.Circle;
import Q2_抽象工厂.Shape.Rectangle;
import Q2_抽象工厂.Shape.Shape;
import Q2_抽象工厂.Shape.Square;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/01/2021 21:24
 **/

public class ShapeFactory extends AbstractFactory{
    @Override
    public Shape getShapeFactory(String shapeType) {
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColorFactory(String color) {
        return null;
    }
}
