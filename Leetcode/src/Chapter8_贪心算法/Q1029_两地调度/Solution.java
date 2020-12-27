package Chapter8_贪心算法.Q1029_两地调度;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/12/2020 22:50
 **/

public class Solution {
    /**
     * 基本思想是所有人先去A地，然后跳出一部分人再去B点，因为要补钱
     * 所以需要按照机票的价格差来从小到大选取n个人,所以直接根据机票差来
     * 排序，前半部分去A，后半部分去B
     * @param costs
     * @return
     */
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        int sum = 0;
        Arrays.sort(costs,(o1, o2) -> (o1[0] - o1[1]) - (o2[0] - o2[1]));
        for(int i = 0; i < n; i++){
            sum += costs[i][0] + costs[i+n][1];
        }
        return sum;
    }
}
