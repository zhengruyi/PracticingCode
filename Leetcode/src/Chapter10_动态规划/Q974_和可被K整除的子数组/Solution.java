package Chapter10_动态规划.Q974_和可被K整除的子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/11/2020 23:45
 **/

public class Solution {
    public int subarraysDivByK(int[] A, int K) {
        Map <Integer,Integer> map = new HashMap <Integer,Integer>();
        //这里初始化城(0,1)来保证第一次满足条件时程序可以正确运行
        map.put(0,1);
        int sum = 0;
        int res = 0;
        for(int i = 0; i < A.length; i++){
            sum+=A[i];
            if(K != 0){
                //由于前缀和的余数可能是负数，所以通过这样的处理来全部转成正数
                sum = (sum % K + K)%K;
            }
            //如果余数重复，则代表区间和刚好可以被k整除，所以将结果累加上去
            if(map.containsKey(sum)){
                res+=map.get(sum);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
