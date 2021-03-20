package Chapter11_单调栈.Q1673_找出最具竞争力的子序列;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/03/2021 21:44
 **/

public class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        //单调递增栈,从开头到末尾进行逐渐增大
        Stack <Integer> stack = new Stack();
        //哨兵,这样就不用考虑栈为空的情况,因为哨兵是-1,而数组里面的所有元素都大于0
        //就能保证栈里面的时刻都有元素
        stack.add(-1);
        int n = nums.length;
        for(int i = 0; i < n; i++){
            //当当前元素小于栈顶元素时且后续任然有足够的元素时，可以进行弹栈
            //否则就不能弹出,因为要保证序列长度至少为k
            while(nums[i] < stack.peek() && k - (stack.size() - 1) < n - i){
                stack.pop();
            }
            //如果有多个满足需求，就去前k+1个因为-1是无效的数字
            if(stack.size() < k + 1){
                stack.push(nums[i]);
            }
        }
        int[] res = new int[k];
        while(k > 0){
            res[--k] = stack.pop();
        }
        return res;
    }
}
