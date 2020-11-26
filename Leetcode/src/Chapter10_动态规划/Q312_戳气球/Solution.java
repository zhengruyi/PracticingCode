package Chapter10_动态规划.Q312_戳气球;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/11/2020 23:00
 **/

public class Solution {
    public int maxCoins(int[] nums) {
        int[] table = new int[nums.length +2];
        table[0] = 1;
        table[nums.length+1] = 1;
        //创建一个新的数组，在两端各自创建一个虚拟节点值为1
        for(int i = 1; i <= nums.length; i++){
            table[i] = nums[i-1];
        }
        //为了符合子问题的独立性，所以需要定义dp[i][j]为i..j最后戳破k时能得到的最大分数
        //由于要提前计算好,dp[i][k]和dp[k][j]所以采用倒序遍历
        int[][] dp = new int[table.length][table.length];
        for(int i = nums.length -1; i>= 0; i--){
            for(int j = i + 2; j < table.length; j++){
                //遍历所有可能的位置来获取最大值
                int num = Integer.MIN_VALUE;
                for(int k = i+1; k < j; k++){
                    num = Math.max(num, dp[i][k] + dp[k][j] + table[i]*table[k]*table[j]);
                }
                dp[i][j] = num;
            }
        }
        return dp[0][dp.length -1];
    }
}
