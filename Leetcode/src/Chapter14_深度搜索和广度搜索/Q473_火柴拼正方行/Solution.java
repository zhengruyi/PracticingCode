package Chapter14_深度搜索和广度搜索.Q473_火柴拼正方行;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/01/2021 16:35
 **/

public class Solution {
    /**
     * 基本思路就是把数组总长度计算出来，然后看能不能把数组的元素分成相等的四组
     * @param nums
     * @return
     */
    public boolean makeSquare(int[] nums) {
        if(nums.length == 0){
            return false;
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        int target = sum /4;
        int[] groups = new int[4];
        int index = nums.length - 1;
        return dfs(groups,nums,target,index);
    }

    /**
     * 这个函数的功能就是看能不能把这么多长度的火柴分成四组,每组和长度总和等于总长度的四分之一
     * @param groups
     * @param nums
     * @param target
     * @param index
     * @return
     */
    public boolean dfs(int[] groups, int[] nums, int target, int index){
        //从高往低遍历，效率更高
        if(index < 0){
            return true;
        }
        int value = nums[index--];
        for(int i = 0; i < groups.length; i++){
            //如果容量未满，那么放入这个桶中
            if(groups[i] + value <= target){
                groups[i] += value;
                //继续搜索
                if(dfs(groups,nums,target,index)){
                    return true;
                }
                groups[i] -= value;
            }
            //由于所有桶的容量相同,所以如果这个桶都无法安排，那么其实吧这些球放入别的桶中也无法安排
            //所以直接跳出
            if(groups[i] == 0){
                break;
            }
        }
        return false;
    }
}
