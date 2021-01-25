package Q2_抽象工厂.Color;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/01/2021 21:22
 **/

public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
