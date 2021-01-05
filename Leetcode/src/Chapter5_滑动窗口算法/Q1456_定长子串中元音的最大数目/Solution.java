package Chapter5_滑动窗口算法.Q1456_定长子串中元音的最大数目;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/01/2021 20:22
 **/

public class Solution {
    /**
     * 根据k值生成固定长度的滑动窗口
     * @param s
     * @param k
     * @return
     */
    public int maxVowels(String s, int k) {
        int res = 0;
        int num = 0;
        //统计初始窗口内的元音字母数
        for(int i = 0; i < Math.min(k,s.length()); i++){
            if(checkVowel(s.charAt(i))){
                num++;
            }
        }
        res = num;
        //统计移动过程中,窗口内的元音字母最多是什么时候
        for(int i = k; i < s.length(); i++){
            if(checkVowel(s.charAt(i))){
                num++;
            }
            if(checkVowel(s.charAt(i-k))){
                num--;
            }
            res = Math.max(res,num);
        }
        return res;
    }
    public boolean checkVowel(char c){
        return c == 'a' || c =='e'||c=='i'||c=='o'||c=='u';
    }
}
