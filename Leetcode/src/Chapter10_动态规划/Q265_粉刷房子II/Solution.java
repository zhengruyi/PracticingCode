package Chapter10_动态规划.Q265_粉刷房子II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/11/2020 19:01
 **/

public class Solution {
    public int minCostII(int[][] costs) {
        if(costs.length == 0){
            return 0;
        }else if(costs[0].length == 1){
            return costs[0][0];
        }
        //要保证O(nk)的时间复杂度，就要求在k中颜色中找最小值的过程为O(1)
        //这里的技巧是保存上一轮循环的最小值，最小值下标和次小值
        //每轮循环，如果当前的颜色和上一栋房子不同，直接取最小值，如果相同则取次小值
        int minColor = -1;
        int minCost =0;
        int secondMinCost = 0;
        for(int[] cost : costs){
            //保存这轮循环选的参数
            int tmpMinCost = Integer.MAX_VALUE;
            int tmpSecondCost = Integer.MAX_VALUE;
            int tmpMinColor = -1;
            int currentCost = 0;
            for(int i =0; i < cost.length; i++){
                currentCost = cost[i] + (i == minColor ? secondMinCost : minCost);
                //更新最小值，次小值和最小值下标
                if(currentCost < tmpMinCost){
                    tmpSecondCost = tmpMinCost;
                    tmpMinCost = currentCost;
                    tmpMinColor = i;
                    //更新次小值
                }else if(currentCost < tmpSecondCost){
                    tmpSecondCost = currentCost;
                }
            }
            minCost = tmpMinCost;
            secondMinCost = tmpSecondCost;
            minColor = tmpMinColor;
        }
        return minCost;
    }
}
