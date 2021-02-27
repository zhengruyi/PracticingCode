package Chapter8_贪心算法.Q659_分割数组为连续子序列;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/02/2021 22:29
 **/

public class Solution {
    public boolean isPossible(int[] nums) {
        //统计数字的出现次数
        HashMap <Integer,Integer> times = new HashMap();
        //以数字nums[i]结尾的序列的个数
        HashMap<Integer,Integer> tail = new HashMap();
        //统计数字出现频率
        for(int num : nums){
            times.put(num, times.getOrDefault(num,0)+1);
        }
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            //如果数字用完了,直接跳过
            if(times.get(num) == 0){
                continue;
                //检查是否有一个序列以num-1结尾,那样就把这个数字加入到上一个序列中
            }else if(tail.containsKey(num - 1) && tail.get(num - 1) > 0){
                times.put(num,times.get(num) - 1);
                tail.put(num - 1, tail.get(num - 1) - 1);
                tail.put(num, tail.getOrDefault(num,0) + 1);
                //那么稚嫩恶搞先创建一个序列是num, num + 1, num + 2
            }else if(times.getOrDefault(num,0) > 0 && times.getOrDefault(num+1,0) > 0 && times.getOrDefault(num + 2,0) > 0){
                times.put(num,times.get(num) - 1);
                times.put(num+1,times.get(num+1) - 1);
                times.put(num+2,times.get(num + 2) - 1);
                tail.put(num+ 2, tail.getOrDefault(num+2, 0) + 1);
            }else{
                //无法构成合法的序列
                return false;
            }
        }
        //所有数字都用完了
        return true;
    }
}
