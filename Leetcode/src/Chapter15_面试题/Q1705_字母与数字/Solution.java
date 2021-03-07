package Chapter15_面试题.Q1705_字母与数字;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/03/2021 22:38
 **/

public class Solution {
    public String[] findLongestSubarray(String[] array) {
        HashMap <Integer,Integer> map = new HashMap();
        int count = 0;
        int start = 0;
        int max = 0;
        map.put(0,-1);
        for(int i = 0; i < array.length; i++){
            //数字则统计上加1，字母则就加上-1，两个相同数字之间的数字和字母个数就相等
            count += Character.isDigit(array[i].charAt(0)) ? 1 : -1;
            if(map.containsKey(count)){
                //有相同的数字出现，说明中间的这一段的数字和字母的个数相等
                int index = map.get(count);
                //由于 i 和index不同同时包含,所以具体的子数组的长度就是 i - index
                if(i - index > max){
                    max = i - index;
                    start = index;
                }
            }else{
                map.put(count,i);
            }
        }
        //将数组的一部分拷贝成另外一份数组
        return Arrays.copyOfRange(array,start + 1, start + max + 1);
    }
}
