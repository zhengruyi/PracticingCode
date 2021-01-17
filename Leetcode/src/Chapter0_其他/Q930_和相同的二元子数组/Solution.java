package Chapter0_其他.Q930_和相同的二元子数组;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/01/2021 22:05
 **/

public class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        if(A.length == 0){
            return 0;
        }
        //统计前缀和出现的次数
        HashMap <Integer,Integer> map = new HashMap<>();
        int sum = 0;
        //保证前缀和刚好等于目标值的情况会被考虑在内
        map.put(0,1);
        int res = 0;
        for(int i = 0; i <A.length; i++){
            //前缀和
            sum += A[i];
            //检查存在某个区间的数组和刚好等于S
            if(map.containsKey(sum - S)){
                res += map.get(sum - S);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
