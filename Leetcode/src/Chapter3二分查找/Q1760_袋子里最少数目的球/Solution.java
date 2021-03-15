package Chapter3二分查找.Q1760_袋子里最少数目的球;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/03/2021 22:45
 **/

public class Solution {
    /**
     * mid代表要求所有袋子里面的球的数目不大于mid,所需要的最少的operation
     * 理论上y越大需要的operation越小,所以存在线性关系,可以用二分搜索
     * @param nums
     * @param maxOperations
     * @return
     */
    public int minimumSize(int[] nums, int maxOperations) {
        //获取数组里面的最大值
        int right = Arrays.stream(nums).max().getAsInt();
        //左边界值
        int left = 1;
        while(left <= right){
            //计算出的袋子中球的数量上限
            int mid = left + (right - left) / 2;
            //因为总的计算数目可能过大
            long operationNumber = getNumber(nums, mid);
            //求左边界的方式缩小范围
            if(operationNumber <= maxOperations){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    public long getNumber(int[] nums, int y){
        long res = 0;
        for(int num : nums){
            res += (num - 1)/y;
        }
        return res;
    }
}
