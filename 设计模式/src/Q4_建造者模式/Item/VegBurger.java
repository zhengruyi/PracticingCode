package Q4_建造者模式.Item;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/01/2021 19:34
 **/

public class VegBurger extends Burger {
    @Override
    public String name() {
        return "veg burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
