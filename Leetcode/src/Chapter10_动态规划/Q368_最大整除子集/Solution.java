package Chapter10_动态规划.Q368_最大整除子集;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/11/2020 21:22
 **/

public class Solution {
    public List <Integer> largestDivisibleSubset(int[] nums) {
        //因为最后要反向添加，所以这里采用LinkedList
        LinkedList <Integer> list = new LinkedList<Integer>();
        if(nums.length == 0){
            return list;
        }
        int len = nums.length;
        int[] dp = new int[len];
        //对数据进行排序
        Arrays.sort(nums);
        //数组中最少包含一个元素
        dp[0] = 1;
        //记录最大的整除子集中的元素数目
        int max = 0;
        //记录最大的整除子集中的最右一位元素，用来进行方向索引
        int index = 0;
        for(int i =0; i < len; i++){
            int t = 0;
            //在0..i-1中能被nums[i]整除最大子集的大小
            for(int j= i -1; j >=0; j--){
                if(nums[i] % nums[j] == 0){
                    t = Math.max(t,dp[j]);
                }
            }
            //dp[i] = max(dp[0..i-1])+1
            dp[i] = t + 1;
            //更新相关信息
            if(dp[i] > max){
                max = dp[i];
                index = i;
            }
        }
        int num = nums[index];
        //开始反向遍历，知道最大整除子集的大小和dp数组，可以反推出元素
        for(int i = index; i >=0; i--){
            if(num % nums[i] == 0 && dp[i] == max){
                //addFirst表示每次都将元素放在首位，可以实现输入顺序和结果相反的效果
                list.addFirst(nums[i]);
                num = nums[i];
                max--;
            }
        }
        return list;
    }
}
