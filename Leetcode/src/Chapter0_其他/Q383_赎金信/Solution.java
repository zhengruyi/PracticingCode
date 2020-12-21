package Chapter0_其他.Q383_赎金信;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/12/2020 23:15
 **/

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] record = new int[26];
        //对所有的源字符串进行分类统计
        for(int i = 0; i < magazine.length();i++){
            record[magazine.charAt(i) - 'a']++;
        }
        //判断目标字符串的字符种类个数不超过原目标字符串
        for(int i = 0; i < ransomNote.length(); i++){
            if(--record[ransomNote.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
