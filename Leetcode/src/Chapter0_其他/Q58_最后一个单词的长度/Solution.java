package Chapter0_其他.Q58_最后一个单词的长度;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/12/2020 23:32
 **/

public class Solution {
    /**
     * 这里就是要考虑一下单词以空格结尾这种特殊情况,所以要先把前后空格去掉,在从后往前统计
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s.length() == 0){
            return 0;
        }
        int count = 0;
        for(int i = s.length()-1; i>= 0; i--){
            if(s.charAt(i) == ' '){
                return count;
            }
            count++;
        }
        return count;
    }
}
