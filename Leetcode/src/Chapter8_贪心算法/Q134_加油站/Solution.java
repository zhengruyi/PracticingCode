package Chapter8_贪心算法.Q134_加油站;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/12/2020 19:14
 **/

public class Solution {
    /**
     * 经过证明，如果从x到y后不能继续到达y的下一个站点，那么从x到y中的任意一个节点都不可能到达y的下一个节点
     * 具体证明过程:https://leetcode-cn.com/problems/gas-station/solution/jia-you-zhan-by-leetcode-solution/
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0;
        int n = cost.length;
        //表示出发点可能是0..n-1
        while(i < n){
            int cnt = 0;
            int sumGas = 0;
            int sumCost = 0;
            //从当前出发点出发经过的节点数目
            while(cnt < n){
                int j = (i + cnt)%n;
                sumCost += cost[j];
                sumGas += gas[j];
                //如果花费总和大于气体总和，表示无法到达下一个节点
                if(sumCost > sumGas){
                    break;
                }
                cnt++;
            }
            //说明这个节点从当前出发又回到了当前节点，则可以返回i
            if(cnt == n){
                return i;
            }else{
                //说明从i节点出发不能再回到刚才的节点，由数学证明可以获得
                //从i到i+cnt之间的所有节点都没办法完成出发再返回的操作，所以i = i+cnt+1
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
