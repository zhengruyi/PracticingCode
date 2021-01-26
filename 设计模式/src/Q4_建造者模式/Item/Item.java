package Q4_建造者模式.Item;

import Q4_建造者模式.Packing.Packing;

public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
