package Chapter0_其他.Q526_优美的排列;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/03/2021 21:35
 **/

public class Solution {
    int res = 0;

    /**
     * 用迭代来检索所有的可能性,进行剪枝优化
     * @param n
     * @return
     */
    public int countArrangement(int n) {
        int[] nums = new int[n];
        dfs(nums,1,n);
        return res;
    }

    /**
     * 回溯算法,找到一个位置安排数字，然后迭代的安排下一个数字
     * @param nums
     * @param curr
     * @param n
     */
    public void dfs(int[] nums, int curr, int n){
        if(curr == n + 1){
            res++;
            return;
        }
        for(int i = 1; i <= n; i++){
            if(nums[i-1] == 0){
                if(curr % i == 0 || i % curr == 0){
                    nums[i-1] = 1;
                    dfs(nums,curr+1,n);
                    nums[i-1] = 0;
                }
            }
        }
    }
}
