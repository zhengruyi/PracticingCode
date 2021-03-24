package Chapter0_其他.Q1674_使数组互补的最少操作次数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/03/2021 23:39
 **/

public class Solution {
    /**
     * 在不对数组的两个元素A = nums[i]和 B = nums[n-i-1]做修改时,那么数字和为 A+B
     * 在只做一次修改时,那么数字和的范围为[1 + min(A,B),limit + max(A,B)]
     * 做两次修改的范围是[2,2*limit]
     * 所以我们可以用差分数组,diff[0..i]表示两个元素和为i所需要的操作次和
     * @param nums
     * @param limit
     * @return
     */
    public int minMoves(int[] nums, int limit) {
        int[] diff = new int[2 * limit + 2];
        int n = nums.length;
        for(int i = 0; i < n / 2; i++){
            int A = nums[i];
            int B = nums[n - 1 - i];
            int l = 2, r = 2 * limit;
            //表示在[2,2*limit]需要两次操作达到
            diff[l] += 2;
            diff[r + 1] -= 2;
            l = 1 + Math.min(A,B);
            r = limit + Math.max(A,B);
            //表示在[1 + min(A,B),limit + max(A,B)]只用一次更改就可达到
            diff[l] -= 1;
            diff[r+1] += 1;
            l = A + B;
            r = A + B;
            //在[A+B]不修改就能达到
            diff[l] -= 1;
            diff[r+1] += 1;
        }
        int sum = 0;
        int res = Integer.MAX_VALUE;
        //表示整个[2,2*limit]看需要的最少次数
        for(int i = 2; i <= 2 * limit; i++){
            sum += diff[i];
            res = Math.min(res, sum);
        }
        return res;
    }
}
