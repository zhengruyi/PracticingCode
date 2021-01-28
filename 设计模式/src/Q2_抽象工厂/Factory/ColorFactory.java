package Q2_抽象工厂.Factory;

import Q2_抽象工厂.Color.Blue;
import Q2_抽象工厂.Color.Color;
import Q2_抽象工厂.Color.Green;
import Q2_抽象工厂.Color.Red;
import Q2_抽象工厂.Shape.Shape;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/01/2021 21:26
 **/

public class ColorFactory extends AbstractFactory{
    @Override
    public Shape getShape(String shapeType) {
        return null;
    }

    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }
}
