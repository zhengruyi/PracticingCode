package Q4_建造者模式.Item;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/01/2021 19:42
 **/

public class Pepsi extends ColdDrink{
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}
