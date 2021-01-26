package Q4_建造者模式.Item;

import Q4_建造者模式.Packing.Packing;
import Q4_建造者模式.Packing.Wrapper;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/01/2021 19:31
 **/

public abstract class Burger implements Item{
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public float price() {
        return 0;
    }
}
