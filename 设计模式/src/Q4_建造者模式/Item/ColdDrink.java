package Q4_建造者模式.Item;

import Q4_建造者模式.Packing.Bottle;
import Q4_建造者模式.Packing.Packing;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/01/2021 19:33
 **/

public abstract class ColdDrink implements Item{
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public float price() {
        return 0;
    }
}
