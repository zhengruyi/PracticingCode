package Chapter0_其他.Q504_七进制数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/12/2020 23:04
 **/

public class Solution {
    public String convertToBase7(int num) {
        //特殊情况
        if(num == 0){
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        int digit = 1;
        boolean isNegative = num < 0;
        num = num < 0 ? -num : num;
        while(num > 0){
            //把整数转化成七进制数的方法
            builder.append(num%7);
            num /= 7;
        }
        //由于要反向，所以最后再添加负号
        if(isNegative){
            builder.append("-");
        }
        return builder.reverse().toString();
    }
}
