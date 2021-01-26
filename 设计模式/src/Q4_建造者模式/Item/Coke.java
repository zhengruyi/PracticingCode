package Q4_建造者模式.Item;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/01/2021 19:41
 **/

public class Coke extends ColdDrink{
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
