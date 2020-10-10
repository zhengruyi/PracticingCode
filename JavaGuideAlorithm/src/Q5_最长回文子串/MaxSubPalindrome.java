package Q5_最长回文子串;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/05/2020 20:09
 **/
/*
时间复杂度是O(n)
空间复杂度也是O(n)用来存储回文半径
 */
public class MaxSubPalindrome {
    //解法一  manache马拉车算法
    public String getMaxSubPalindrome(String s){
        if(s == null || s.length() == 0)
            return null;
        int len = s.length();
        char[] chars = new char[2*len + 1];
        int[] index = new int[2*len + 1];
        chars[0] = '#';
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if(i%2 == 0)
                chars[i] = '#';
            else
                chars[i] = s.charAt((i - 1) / 2);
        }
        int maxRight = 0;
        int pos = 0;
        int maxLen = 0;
        for (int i = 0; i < chars.length; i++) {
            int border = 0;
            if(i >= maxRight){
               border =  getMaxPalindrome(i,chars,0);
            }else{
                border = getMaxPalindrome(i,chars,Math.min(maxRight - i, index[2 * pos - i]));
            }
            index[i] = border;
            if(i + border - 1 > maxRight){
                pos = i;
                maxRight = i + border - 1;
            }
            if(border > maxLen){
                builder.delete(0,builder.length());
                for (int j = i - border + 1; j <= i + border - 1; j++) {
                    if(j % 2 != 0)
                        builder.append(chars[j]);
                }
                maxLen = border;
            }
        }
        return builder.toString();

    }
    public int getMaxPalindrome(int location , char[] chars, int border){
        int len = border;
        while((location - border >= 0) && (location + border <chars.length)
                && (chars[location - border] == chars[location + border])){
            border++;
        }
        return border;
    }

    //解法二 4ms
    public String getMaxSubPalindromeTwo(String s){
        if (s == null || s.length() == 0) {
            return "";
        }
//         保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
//             把回文看成中间的部分全是同一字符，左右部分相对称
//             找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }
    public  int findLongest(char[] str, int low, int[] range) {
//         查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
//         定位中间部分的最后一个字符
        int ans = high;
//         从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
//         记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }

    @Test
    void test(){
        //Assertions.assertEquals("aba",getMaxSubPalindrome("aba"));
        //Assertions.assertEquals("bb",getMaxSubPalindrome("cbbd"));
        Assertions.assertEquals("aba",getMaxSubPalindromeTwo("aba"));
        Assertions.assertEquals("bb",getMaxSubPalindromeTwo("cbbd"));
    }

}
