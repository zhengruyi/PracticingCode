package Chapter0_其他.Q1071_字符串的最大公因子;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/01/2021 23:10
 **/

public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        //如果翻转位置拼成的字符串不等，那么这两个字符串不可能是由同一个子串拼接而成
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        //采用辗转相除来获取最小公因数常数,这就是子串的长度
        return str1.substring(0,gcd(str1.length(),str2.length()));
    }
    public int gcd(int a, int b){
        return b== 0 ? a : gcd(b, a % b);
    }
}
