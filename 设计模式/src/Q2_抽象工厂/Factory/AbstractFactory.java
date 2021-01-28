package Q2_抽象工厂.Factory;

import Q2_抽象工厂.Color.Color;
import Q2_抽象工厂.Shape.Shape;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/01/2021 21:23
 **/

public abstract class AbstractFactory {
    public abstract Shape getShape(String shapeType);
    public abstract Color getColor(String color);
}
