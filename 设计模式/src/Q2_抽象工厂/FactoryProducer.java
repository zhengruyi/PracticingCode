package Q2_抽象工厂;

import Q2_抽象工厂.Factory.AbstractFactory;
import Q2_抽象工厂.Factory.ColorFactory;
import Q2_抽象工厂.Factory.ShapeFactory;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/01/2021 21:27
 **/

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
