package Chapter7_位运算.Q1_不用额外变量交换两个整数的值;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/06/2020 13:57
 **/

public class ExchangeTwoValue {
    public static  void exchange(int a, int b){
        System.out.println(" before "+a);
        System.out.println(" before "+b);
        a = a ^ b;
        b = a ^ b;
        a = b ^ a;
        System.out.println(" after "+a);
        System.out.println(" after "+b);
    }
    public static  void exchangeTwo(int a, int b){
        System.out.println(" before "+a);
        System.out.println(" before "+b);
        a = b - a;
        b = b - a;
        a = b + a;
        System.out.println(" after "+a);
        System.out.println(" after "+b);
    }

    public static void main(String[] args) {
        exchange(5,10);
        exchangeTwo(5,10);
    }
}
