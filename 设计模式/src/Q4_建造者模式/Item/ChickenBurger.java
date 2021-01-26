package Q4_建造者模式.Item;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/01/2021 19:41
 **/

public class ChickenBurger extends Burger{
    @Override
    public float price() {
        return 50.0f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
