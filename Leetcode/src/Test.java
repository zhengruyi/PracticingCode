import Chapter13_二叉树.TreeNode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    @org.junit.jupiter.api.Test
    void test() {
        int[] staple = {10,20,5};
        int[] drinks = {5,5,2};
        breakfastNumber(staple,drinks,15);
    }

    public static void main(String[] args) {
        System.out.println(IntStream.range(0,4).sum());
    }
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int res = 0;
        int j = drinks.length - 1;
        for(int i = 0; i < staple.length; i++){
            int price = x - staple[i];
            for(j = drinks.length - 1; j>= 0; j--){
                if(drinks[j] < price){
                    break;
                }
            }
            res += (j+1);
        }
        return res;
    }
}