package Chapter10_动态规划.Q300_最长上升子序列;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/10/2020 21:53
 **/

/**
 * 时间复杂度O(NlogN),空间复杂度O(N)
 */
public class SolutionPoker {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int piles = 0;
        int[] table = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int poker = nums[i];
            int left = 0;
            int right = piles;
            while(left < right){
                int mid = left + (right - left)/2;
                if(table[mid] < poker){
                    left = mid +1;
                }else{
                    right = mid;
                }
            }
            if(left == piles){
                piles++;
            }
            table[left] = poker;
        }
        return piles;
    }
}
