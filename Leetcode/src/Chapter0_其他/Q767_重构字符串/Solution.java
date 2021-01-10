package Chapter0_其他.Q767_重构字符串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/01/2021 21:18
 **/

public class Solution {
    public String reorganizeString(String s) {
        int[] times = new int[26];
        for(int i = 0; i < s.length(); i++){
            times[s.charAt(i) - 'a'] ++;
        }
        int max = 0;
        int offset = -1;
        //统计字符的最大出现次数
        int threshold = (s.length() + 1) >> 1;
        for(int i = 0; i < times.length; i++){
            if(max < times[i]){
                max = times[i];
                offset = i;
            }
            //如果最大出现次数超过阈值，那么直接返回,不可能有字符串符合
            if(max > threshold){
                return "";
            }
        }
        //重新排列字符串
        char[] chas = new char[s.length()];
        int j = 0;
        int index = 0;
        //先将出现频率最大字符填满偶数位索引
        while(times[offset]-- > 0){
            chas[index] = (char)(offset + 'a');
            index+=2;
        }
        //为防止有字符靠在一起，插入时都是各一个插入，注意
        //这里的要点是接着把偶数为插完，在返回去把奇数位插完
        for(int i = 0 ;i < times.length; i++){
            while(times[i]-- > 0){
                if(index >= chas.length){
                    index = 1;
                }
                chas[index] = (char)(i + 'a');
                index+=2;
            }
        }
        return new String(chas);
    }
}
