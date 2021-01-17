package Chapter11_单调栈.Q907_子数组的最小值之和;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/01/2021 21:26
 **/

public class Solution {
    /**
     * 子数组的定义是连续相邻的元素组合的数组
     * 解释比较复杂:https://leetcode-cn.com/problems/sum-of-subarray-minimums/solution/dan-diao-zhan-zuo-you-liang-bian-di-yi-g-ww3n/
     * @param arr
     * @return
     */
    public int sumSubarrayMins(int[] arr) {
        long res = 0;
        int mod = 1_000_000_000 + 7;
        Stack <Integer> stack = new Stack<>();
        //为了保证单调递增栈里面的所有元素可以被弹出处理所以创建一个新的数组并在末尾放上最小的元素0
        int[] nums = new int[arr.length + 1];
        System.arraycopy(arr,0,nums,0,arr.length);
        nums[arr.length] = 0;
        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && nums[i] <= nums[stack.peek()]){
                //说明当前元素nums[i]比栈顶元素大并且由于是单调递增的单调栈
                //那么栈顶的下一个元素j比栈顶元素k小，那么说明在j~k~i之间的所有元素
                //都比nums[i]大，那么这些较大的元素和nums[i]构成的子数组
                //中的最小值都是nums[i]一共的数目是 m*n + m+ n+ 1 =(m+1)+(n+1)
                //其中1是单个元素m和b分别是单边的数组，m*n是双边都包含在内的子数组数目
                //由于计算可能会超出边界，所以需要用long
                int index = stack.pop();
                int prev = -1;
                if(!stack.isEmpty()){
                    prev = stack.peek();
                }
                int prevCount = index - prev - 1;
                int postCount = i - index - 1;
                res += (long)(nums[index]) * (prevCount + 1) * (postCount + 1) % mod;
                res %= mod;
            }
            stack.push(i);
        }
        return (int) res;
    }
}
