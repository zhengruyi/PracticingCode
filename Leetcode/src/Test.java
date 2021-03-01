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
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] nums = new int[len];
        in.nextLine();
        String input = in.nextLine();
        for(int i = 0; i < len; i++){
            nums[i] = input.charAt(i) - '0';
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
        }
        int[] dp = new int[len+1];
        for(int i = 2; i <= len; i++){
            int jump = Integer.MAX_VALUE;
            if(map.containsKey(nums[i-1]) && map.get(nums[i-1]) != i-1){
                jump = dp[map.get(nums[i-1]) + 1] + 1;
            }
            dp[i] = Math.min(dp[i-1]+ 1, jump);
        }
        System.out.println(dp[len]);
    }
}