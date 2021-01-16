package Chapter0_其他.Q318_最大单词长度乘积;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/01/2021 20:39
 **/

public class Solution {
    /**
     * 这题难点在于怎么判断两个单词是否单个字符重复，解决办法就是按a-1..z-26这样移位
     * 这样把字符串转化成数字，如果两个字符串没有字符相同，那么转换而来的数字相与结果就是0
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        if(words.length == 0){
            return 0;
        }
        int[] array = new int[words.length];
        //把字符串转化成数字
        for(int i = 0; i < words.length; i++){
            int length = words[i].length();
            for(int j = 0; j < length; j++){
                array[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int ans = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i+1; j < words.length; j++){
                //检测两个字符串是否相同的字符
                if((array[i] & array[j]) == 0){
                    ans = Math.max(ans,words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}
