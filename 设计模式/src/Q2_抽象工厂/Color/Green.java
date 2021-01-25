package Q2_抽象工厂.Color;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/01/2021 21:21
 **/

public class Green implements Color{
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
