package Chapter0_其他.Q1133_最大唯一数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/03/2021 23:06
 **/

public class Solution {
    /**
     * 数字边界有限,直接统计数字出现频率,倒序数一下就可以
     * @param A
     * @return
     */
    public int largestUniqueNumber(int[] A) {
        int[] nums = new int[1001];
        for( int index : A){
            nums[index]++;
        }
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] == 1){
                return i;
            }
        }
        return -1;
    }
}
