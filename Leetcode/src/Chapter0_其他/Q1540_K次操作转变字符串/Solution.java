package Chapter0_其他.Q1540_K次操作转变字符串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/02/2021 21:25
 **/

public class Solution {
    public boolean canConvertString(String s, String t, int k) {
        int[] arr = new int[26];
        //如果两个字符串长度不相等,那么不可能通过转换得到目标字符串
        if(t.length() != s.length()){
            return false;
        }
        //统计字符串需要旋转的次数,并在对应次数上加1
        for(int i = 0; i < s.length(); i++){
            int index = (t.charAt(i) - s.charAt(i) + 26) % 26;
            arr[index] ++;
        }
        //如果一个切换次数大于1，那么相当于要多转一轮,也就是多跑26次,看看总次数是否大于最高需要的次数
        for(int i = 1; i < 26; i++){
            if((arr[i] - 1) * 26 + i > k){
                return false;
            }
        }
        return true;
    }
}
