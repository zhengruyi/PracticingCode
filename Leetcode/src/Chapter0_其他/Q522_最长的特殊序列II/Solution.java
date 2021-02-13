package Chapter0_其他.Q522_最长的特殊序列II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/02/2021 17:17
 **/

public class Solution {
    /**
     * 假设一个子序列只存在一个特定的字符串中,那么可以继续添加字符直到下次变成一个完整的字符串
     * 所以题目变成找出最长的字符串,这个字符串不是其他字符串的子序列
     * @param strs
     * @return
     */
    public int findLUSlength(String[] strs) {
        int res = -1;
        int index = 0;
        for(int i = 0; i < strs.length; i++){
            //检查字符串strs[i]之间是否是其他字符串的子序列
            for(index = 0; index < strs.length; index++){
                if(index == i){
                    continue;
                }
                if(isSubSequence(strs[i],strs[index])){
                    break;
                }
            }
            //更新最长的答案
            if(index == strs.length){
                res = Math.max(res,strs[i].length());
            }

        }
        return res;
    }

    /**
     * 检查字符串x是不是字符串y的子序列
     * @param x
     * @param y
     * @return
     */
    public boolean isSubSequence(String x, String y){
        int i = 0;
        int j = 0;
        while(i < x.length() && j < y.length()){
            if(x.charAt(i) == y.charAt(j)){
                i++;
            }
            j++;
        }
        return i == x.length();
    }
}
