package Chapter0_其他.Q67_二进制求和;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/12/2020 23:43
 **/

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int len1 = a.length();
        int len2 = b.length();
        int len = Math.max(len1,len2);
        int carry = 0;
        for(int i = 1; i <= len; i++){
            int x1 = 0, x2=0;
            //分别取出两个字符串对应位置的字符
            if(len1-i >= 0){
                x1 = a.charAt(len1-i) - '0';
            }
            if(len2 - i >= 0){
                x2 = b.charAt(len2-i) - '0';
            }
            //更新结果和进位
            builder.append((x1+x2+carry)%2);
            carry = (x1 + x2 + carry)/2;
        }
        if(carry != 0){
            builder.append(carry);
        }
        //从低位开始加起,最终结果为反向输出
        return builder.reverse().toString();
    }
}
