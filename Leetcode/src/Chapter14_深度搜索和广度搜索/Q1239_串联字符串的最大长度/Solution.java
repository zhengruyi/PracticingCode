package Chapter14_深度搜索和广度搜索.Q1239_串联字符串的最大长度;

import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/12/2020 23:39
 **/

public class Solution {
    public int maxLength(List <String> arr) {
        return maxLengthDFS(arr,0,0);
    }
    public int maxLengthDFS(List<String> arr, int start, int bitMask){
        //到达字符串末尾
        if(start == arr.size()){
            return 0;
        }
        int ans = 0;
        for(int i = start; i < arr.size(); i++){
            int bit = getBit(arr.get(i));
            //如果字符串中有重复字符或者和以前纳入的字符串有相同字符，则跳过
            if(bit == 0 || (bitMask & bit) != 0){
                continue;
            }
            //这里采用bitMask|bit的方式来进行做出选择和撤销选择的行为
            //从后续选择的字符串中选择一个最大值作为答案返回
            ans = Math.max(ans, maxLengthDFS(arr,i+1,bitMask | bit) + arr.get(i).length());
        }
        return ans;
    }

    /**
     * 布局不同的字符将1左移不同的位数，构成一个整体的数字，如果字符串中存在重复字符就返回0
     * @param s
     * @return
     */
    public int getBit(String s){
        int bitMask = 0;
        for(char c : s.toCharArray()){
            int bit = 1 << (c - 'a');
            if((bitMask & bit) != 0){
                return 0;
            }
            bitMask |= bit;
        }
        return bitMask;
    }
}
