package Chapter0_其他.Q8_字符串转换整数atoi;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/12/2020 22:31
 **/

public class Solution {
    public int myAtoi(String str) {
        //去除字符串两端的空格
        str = str.trim();
        //如果字符串的长度为0，则转化成数字也为0
        if(str.length() == 0){
            return 0;
        }
        //如果开始的既不是数字也是+/-这种符号，则直接返回0
        if(!Character.isDigit(str.charAt(0)) && str.charAt(0) != '+' && str.charAt(0) != '-'){
            return 0;
        }
        //判断正负数
        boolean neg = str.charAt(0) == '-';
        //判断开始位置，因为第一个字符可能是+/-号
        int i = Character.isDigit(str.charAt(0)) ? 0 : 1;
        int ans = 0;
        while( i < str.length()){
            //如果后续不再是数字则直接跳出
            if(!Character.isDigit(str.charAt(i))){
                break;
            }
            //由于负数的最大值的绝对值会比整数的最大值大1，所以求和都会转化成负数，最后统一翻转符号，这里计算出的是不溢出的最大值
            int tmp = ((neg ? Integer.MIN_VALUE : Integer.MIN_VALUE +1) + (str.charAt(i) - '0'))/10;
            //如果tmp（负数)大于ans那么代表继续计算会溢出
            if(tmp > ans){
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            //由于统一采用负数计算方式，所以求和采用相减的方式
            ans = ans * 10 - (str.charAt(i++) - '0');
        }
        //统一翻转符号
        return neg ? ans : -ans;
    }

}
