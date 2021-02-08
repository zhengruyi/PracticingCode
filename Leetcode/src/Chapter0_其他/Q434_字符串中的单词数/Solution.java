package Chapter0_其他.Q434_字符串中的单词数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/02/2021 18:19
 **/

public class Solution {
    public int countSegments(String s) {
        int res = 0;
        String[] strs = s.split("\\s+");
        //按照空格切分好,检查防止数组子元素里有空字符串
        for(String str : strs){
            if(str.length() > 0){
                res++;
            }
        }
        return  res;
    }
}
