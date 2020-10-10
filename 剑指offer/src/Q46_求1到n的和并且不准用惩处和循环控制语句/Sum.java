package Q46_求1到n的和并且不准用惩处和循环控制语句;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/04/2020 11:14
 **/

public class Sum {
    static int sum =0;
    public Sum(int n){
        sum += n;
    }
    public static int getSum(){
        return sum;
    }

    public static void main(String[] args) {
        Sum s1 = new Sum(1);
        Sum s2 = new Sum(2);
        Sum s3 = new Sum(3);
        System.out.println(Sum.getSum());
    }
}
