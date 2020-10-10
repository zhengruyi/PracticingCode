package Q9_斐波那契数列;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/04/2020 20:26
 **/

public class Fibonacci {
    public int fibonacci(int target){
        if(target == 1)
            return 1;
        else if(target <= 0 )
            return 0;
        else
            return fibonacci(target-1)+fibonacci(target-2);
    }

    public int fibonacci1(int target){
        if(target == 1)
            return 1;
        else if(target <= 0 )
            return 0;
        int fibonacci_2 = 0;
        int fibonacci_1 = 1;
        int fibn = 0;
        for(int i = 1; i < target; i++){
            fibn = fibonacci_1 + fibonacci_2;
            fibonacci_1 = fibn;
            fibonacci_2 = fibonacci_1;
        }
        return fibn;
    }

    @Test
    void test(){
        Assertions.assertEquals(2,fibonacci(3));
        Assertions.assertEquals(2,fibonacci1(3));
        Assertions.assertEquals(0,fibonacci(0));
        Assertions.assertEquals(0,fibonacci1(0));
        Assertions.assertEquals(1,fibonacci(1));
        Assertions.assertEquals(1,fibonacci1(1));
    }
}
