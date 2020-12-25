import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 1){
            return 10;
        }
        int sum = 10;
        int times = 9;
        for(int j = 2; j <= n; j++){
            for(int i = 1; i < n; i++){
                times *= (10 - i);
            }
            sum += times;
            times = 9;
        }

        return sum;
    }
    @org.junit.jupiter.api.Test
    void test(){
        countNumbersWithUniqueDigits(3);
    }

    public static void main(String[] args) {
        int i = 5;
        while (i > 0) {
            i -= lowbit(i);
            System.out.println(i);
        }

    }
    public static int lowbit(int x) {
        // 等价：x & (~x +1)
        return x & (-x);
    }

}
