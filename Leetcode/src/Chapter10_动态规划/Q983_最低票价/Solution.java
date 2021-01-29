package Chapter10_动态规划.Q983_最低票价;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/01/2021 22:08
 **/

public class Solution {
    /**
     * 动态规划计算最小值,计算方式是动态从后往前遍历，因为当前的选择或影响到后续的开销
     * 所以选择从后往前的遍历方式
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        int min = days[0];
        int len = days.length;
        int max = days[len - 1];
        //为了简化代码，防止对末尾365的判断，所以这里特意多申请了一个月的空间
        int[] dp = new int[max + 31];
        int i = len - 1;
        for(int d = max; d >= min; d--){
            //因为d代表的是天数，所以只考虑当天要出去的情况，其余不用考虑
            //不出去的那天的话费和后一天一模一样
            if(days[i] == d){
                //考虑三种不同的买票方案，选择其中话费最小的一种方案
                dp[d] = Math.min(dp[d+1] + costs[0], dp[d+7]+costs[1]);
                dp[d] = Math.min(dp[d],dp[d+30] + costs[2]);
                i--;
            }else{
                //今天不出去那么话费不变
                dp[d] = dp[d+1];
            }
        }
        return dp[min];
    }
}
