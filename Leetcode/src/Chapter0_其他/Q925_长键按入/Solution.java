package Chapter0_其他.Q925_长键按入;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/01/2021 22:22
 **/

public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while(j < typed.length()){
            //typed字符串只有两种用途，如果和name的i位置相等那么i和j都各自加1
            if( i < name.length() && typed.charAt(j) == name.charAt(i)){
                i++;
                j++;
                //不相等的和可能是多按出的所以和j-1位置比较，然后递增
            }else if(j > 0 && typed.charAt(j) == typed.charAt(j-1)){
                j++;
            }else{
                return false;
            }
        }
        //查看name字符串是否已经完全匹配了
        return i == name.length();
    }
}
