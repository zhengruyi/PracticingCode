package Chapter15_面试题.Q1711_单词距离;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/02/2021 23:35
 **/

public class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        if(words == null || words.length < 2){
            return -1;
        }
        //保存指向两个字符串的指针
        int word1Index = -1;
        int word2Index = -1;
        int min = Integer.MAX_VALUE;
        //保存两个指针位置是否修改过
        boolean hasChanged = false;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                word1Index = i;
                hasChanged = true;
            }
            if(words[i].equals(word2)){
                word2Index = i;
                hasChanged = true;
            }
            if(hasChanged){
                //更新两个指针之间的距离的最小值
                if(word1Index != -1 && word2Index != -1){
                    min = Math.min(min,Math.abs(word1Index - word2Index));
                    hasChanged = false;
                }
            }
        }
        return min;
    }
}
