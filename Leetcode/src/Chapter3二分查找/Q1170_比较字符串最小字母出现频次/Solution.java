package Chapter3二分查找.Q1170_比较字符串最小字母出现频次;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/03/2021 22:57
 **/

public class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] qNum = new int[queries.length];
        int[] wNum = new int[words.length];
        //分别求两个字符数组中的每个字符串的最小字符的出现频率
        for(int i = 0; i < queries.length; i++){
            qNum[i] = getN(queries[i]);
        }
        for(int i = 0; i < words.length; i++){
            wNum[i] = getN(words[i]);
        }
        //对wNum进行排序，为后面的二分搜索做准备
        Arrays.sort(wNum);
        int[] res = new int[qNum.length];
        //二分搜索,找到小于wNum的最右边界
        for(int i = 0; i < qNum.length; i++){
            int l = 0;
            int r = wNum.length - 1;
            while(l <= r){
                int mid = l + (r - l) /2;
                if(qNum[i] < wNum[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            //那么大于qNum的数字数目是wNum.length - l
            res[i] = wNum.length - l;
        }
        return res;
    }

    /**
     * 统计字符串的最小字母的出现频次,方法就是用数组来保存对应字符的出现频率
     * @param s
     * @return
     */
    public int getN(String s){
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        for(int num : count){
            if(num > 0){
                return num;
            }
        }
        return 0;
    }
}
