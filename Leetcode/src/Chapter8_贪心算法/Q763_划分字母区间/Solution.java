package Chapter8_贪心算法.Q763_划分字母区间;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/12/2020 23:21
 **/

public class Solution {
    public List <Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList <Integer>();
        if(s == null || s.length() == 0){
            return list;
        }
        //贪心算法，记录每一个字符出现的最后位置
        int[] last = new int[26];
        for(int i = 0; i < s.length();i++){
            last[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length();i++){
            //在遍历过程中不断更新最远位置
            end = Math.max(end,last[s.charAt(i) - 'a']);
            //如果i==end,就是在过去的区间中包含了所有同的字符，这是区间的最小长度，自然我们通过这个得到的区间数字
            //也是最大的
            if(i == end){
                list.add(end - start + 1);
                start = end + 1;
            }
        }
        return list;
    }
}
