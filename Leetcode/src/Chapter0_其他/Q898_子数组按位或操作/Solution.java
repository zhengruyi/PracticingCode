package Chapter0_其他.Q898_子数组按位或操作;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/03/2021 23:38
 **/

public class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set <Integer> set = new HashSet();
        for(int i = 0; i < arr.length; i++){
            //先将当前位置压入集合
            set.add(arr[i]);
            for(int j = i - 1; j >= 0; j--){
                //不用继续往前遍历了，因为前面的数字在 i = j时，前面的
                //所有数字都已经和这个数字或过了,再执行一遍也没有意义,直接跳出
                if( (arr[j] & arr[i]) == arr[i]){
                    break;
                }
                //更新前面的结果
                arr[j] |= arr[i];
                set.add(arr[j]);
            }
        }
        return set.size();
    }
}
