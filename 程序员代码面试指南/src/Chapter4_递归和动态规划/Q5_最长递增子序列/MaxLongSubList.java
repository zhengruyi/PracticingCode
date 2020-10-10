package Chapter4_递归和动态规划.Q5_最长递增子序列;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/06/2020 14:05
 **/

public class MaxLongSubList {
    public static int[] getIncreasingSubList(int[] nums){
        if(nums == null || nums.length == 0){
            return null;
        }
        int[] dp = getDP(nums);
        int[] result = generateLIS(dp,nums);
        return result;
    }
    public static int[] getIncreasingSubListLevelTwo(int[] nums){
        if(nums == null || nums.length == 0){
            return null;
        }
        int[] dp = getDPLevelTwo(nums);
        int[] result = generateLIS(dp,nums);
        return result;
    }

    /**
     * 得到dp数组的暴力方法，时间复杂度O(N^2)，每次都要遍历生成的数组
     * @param nums
     * @return
     */
    public static int[] getDP(int[] nums){
        int min = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        dp[0] =1;
        for (int i = 1; i < nums.length; i++) {
            int res = min;
            for (int j = i - 1; j >=0; j--) {
                if(nums[j] < nums[i]){
                    res = Math.max(dp[j]+1,res);
                }
            }
            dp[i] = res == min ? 1 : res;
        }
        return dp;
    }

    public static int[] getDPLevelTwo(int[] nums){
        if(nums == null || nums.length == 0){
            return null;
        }
        int[] dp = new int[nums.length];
        int[] end = new int[nums.length];
        dp[0] =1;
        end[0] = nums[0];
        int endIndex = 1;
        int[] variable = new int[1];
        for (int i = 1; i < nums.length; i++) {
            if(findMax(end, endIndex,nums[i],variable)){
                end[variable[0]] = nums[i];
                dp[i] = variable[0] +1;
            }else{
                end[endIndex++] = nums[i];
                dp[i] = endIndex;
            }
        }
        return  dp;
    }
    public static boolean findMax(int[] ends, int index, int target, int[] variable){
        boolean result = false;
        for (int i = index - 1; i >=0 ; i--) {
            if(ends[i] > target){
                variable[0] = i;
                result = true;
            }
        }
        return result;
    }

    /**
     * 根据给定的最长上升子序列长度和原数组生成最大上升子序列，两个方法通用
     * @param dp
     * @param nums
     * @return
     */
    public static int[] generateLIS(int[] dp,int[] nums){
        if(dp == null || dp.length == 0){
            return null;
        }
        int max = -1;
        int index = -1;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max,dp[i]);
            index = max == dp[i] ? i : index;
        }
        int[]res = new int[max];
        res[--max] = nums[index];
        int end = index;
        for (int i = end - 1; i >=0 ; i--) {
            if(dp[i] == dp[index] - 1 && nums[i] < nums[index]){
                res[--max] = nums[i];
                index = i;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {2,1,5,3,6,4,8,9,7};
        getIncreasingSubList(nums);
        getIncreasingSubListLevelTwo(nums);
    }

}
