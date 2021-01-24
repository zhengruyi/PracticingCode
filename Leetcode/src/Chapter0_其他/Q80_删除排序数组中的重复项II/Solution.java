package Chapter0_其他.Q80_删除排序数组中的重复项II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/01/2021 19:19
 **/

public class Solution {
    /**
     * 双指针法，一个用于遍历，一个用于指向要覆盖元素的索引位置
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        //出现次数至少为1
        int count = 1;
        //由于遍历位置是从i = 1,开始的所以 j也从1处开始
        int j =1;
        for(int i = 1; i < nums.length; i++){
            //如果当前元素和前一个元素相同，那么就出现次数加1
            count = nums[i] == nums[i-1] ? count + 1 : 1;
            //多余有效的元素进行逐步覆盖,出现次数大于2次的元素则i移动而j不动
            if(count <= 2){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
