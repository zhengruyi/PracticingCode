package Chapter0_其他.Q670_最大交换;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/01/2021 21:53
 **/

public class Solution {
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int[] last = new int[10];
        //统计数字最后一次出现的索引位置
        for(int i = 0; i < chars.length; i++){
            last[chars[i] - '0'] = i;
        }
        //为了凑出最大的数字，那么就需要首先从高位开始替换
        //并且尽可能替换较大的数字
        for(int i = 0; i < chars.length; i++){
            //将数字从大往小搜索
            for(int j = 9; j > chars[i] - '0'; j--){
                //将低位的较大的数字和高位较小的数字交换，得出的结果就是最大的数字
                if(last[j] > i){
                    char tmp = chars[last[j]];
                    chars[last[j]] = chars[i];
                    chars[i] = tmp;
                    return Integer.parseInt(new String(chars));
                }
            }
        }
        return num;
    }
}
