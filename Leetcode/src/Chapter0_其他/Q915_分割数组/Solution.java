package Chapter0_其他.Q915_分割数组;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/03/2021 22:05
 **/

public class Solution {
    public int partitionDisjoint(int[] A) {
        int pos = 0;
        int max = A[0];
        int leftMax = A[0];
        for(int i = 1; i < A.length; i++){
            //记录左边的最大值
            max = Math.max(max,A[i]);
            //如果当前元素大于左边区间的最大值，可以暂时放入右区间
            if(A[i] >= leftMax){
                continue;
            }
            //不然的话，当前的数字必须归入左边的数组
            //更新左边数组的最大值和切割位置
            leftMax = max;
            pos = i;
        }
        return pos + 1;
    }
}
