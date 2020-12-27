package Chapter15_面试题.Q0106_字符串压缩;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/12/2020 23:02
 **/

public class Solution {
    public String compressString(String s) {
        if(s.length() == 0){
            return s;
        }
        char left = s.charAt(0);
        int num = 1;
        /**
         * 双指针技巧,left指向重复字符串的起始点,i一定和left不同就需要进行压缩
         */
        StringBuilder builder = new StringBuilder();
        for(int j = 1; j < s.length(); j++){
            if(s.charAt(j) != left){
                builder.append(left);
                builder.append(num);
                left = s.charAt(j);
                num=1;
            }else{
                num++;
            }
        }
        //别忘记处理末尾的情况
        builder.append(left);
        builder.append(num);
        if(builder.length() >= s.length()){
            return s;
        }
        return builder.toString();
    }
}
