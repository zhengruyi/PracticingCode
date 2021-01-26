package Chapter0_其他.Q454_四数相加II;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/01/2021 23:26
 **/

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map <Integer,Integer> map = new HashMap <>();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                //求出A和B的数组的两两之和，然后放入map进行出现次数统计
                int sum = A[i] + B[j];
                map.put(sum,map.getOrDefault(sum,0) + 1);
            }
        }
        int res = 0;
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                //统计C和D的两两数字之和，然后如果A和B的数字之和符合要求，就加上对应的统计次数
                int key = -(C[i] + D[j]);
                res += map.getOrDefault(key,0);
            }
        }
        return res;
    }
}
