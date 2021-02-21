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
        int[] n1 = {1972,1908,1915,1957,1960,1948,1912,1903,1949,1977,1900,1957,1934,1929,1913,1902,1903,1901
};
        int[] n2 = {1997,1932,1963,1997,1983,2000,1926,1962,1955,1997,1998,1989,1992,1975,1940,1903,1983,1969};
        maxAliveYear(n1,n2);
    }

    public static void main(String[] args) {
        System.out.println(IntStream.range(0,4).sum());
    }
    public int maxAliveYear(int[] birth, int[] death) {
        int[] nums = new int[10002];
        int[] sum = new int[10002];
        for(int i = 0; i < birth.length; i++){
            nums[birth[i]] += 1;
            nums[death[i] + 1] -= 1;
        }
        for(int i = 1; i < nums.length; i++){
            sum[i] = sum[i-1] + nums[i];
        }
        int max = Arrays.stream(nums).max().getAsInt();
        for(int i = 0; i < nums.length; i++){
            if(sum[i] == max){
                return i;
            }
        }
        return -1;
    }
}