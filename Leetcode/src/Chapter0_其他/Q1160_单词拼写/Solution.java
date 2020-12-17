package Chapter0_其他.Q1160_单词拼写;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/12/2020 22:51
 **/

public class Solution {
    public int countCharacters(String[] words, String chars) {
        int count = 0;
        //统计目标字符串中所有字符出现的次数
        int[] times = getTimes(chars);
        for(int i = 0; i < words.length; i++){
            //统一每个单词中的字符出现次数
            int[] tmp = getTimes(words[i]);
            //统计总长度
            if(contains(tmp,times)){
                count+= words[i].length();
            }
        }
        return count;
    }

    /**
     * 统计单词中各个字符出现的次数
     * @param s
     * @return
     */
    public int[] getTimes(String s){
        int[] times = new int[26];
        for(char c : s.toCharArray()){
            times[c-'a']++;
        }
        return times;
    }

    /**
     * 表示字符串a是否包含在b里面
     * @param a
     * @param b
     * @return
     */
    public boolean contains(int[] a, int[] b){
        for(int i =0; i < a.length; i++){
            if(a[i] > b[i]){
                return false;
            }
        }
        return true;
    }
}
