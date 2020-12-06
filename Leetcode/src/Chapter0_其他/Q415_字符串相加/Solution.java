package Chapter0_其他.Q415_字符串相加;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/12/2020 21:37
 **/

public class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        int len = Math.max(len1,len2);
        for(int i = 0; i < len; i++){
            int n1 = 0;
            if(i < len1){
                n1 = num1.charAt(len1-1-i) - '0';
            }
            int n2 = 0;
            if(i < len2){
                n2 = num2.charAt(len2-1-i) - '0';
            }
            int sum = n1 + n2 + carry;
            carry = sum/10;
            builder.append(sum % 10);
        }
        //防止出现89+11 = 100 中最后忘记最高位1的情况，所以这里要在此做验证
        if(carry > 0){
            builder.append(carry);
        }
        return builder.reverse().toString();
    }
}
