package Chapter8_贪心算法.Q984_不含AAA或BBB的字符串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/02/2021 23:07
 **/

public class Solution {
    /**
     * 总体思想就是用贪心算法,只有在前面已经有连续的两个字符了时在填入另外一个字符
     * 否则就是那个字符多就填入哪个字符
     * @param a
     * @param b
     * @return
     */
    public String strWithout3a3b(int a, int b) {
        //默认先填入b字符
        boolean writeA = false;
        StringBuilder builder = new StringBuilder();
        while(a > 0 || b > 0){
            int len = builder.length();
            writeA = false;
            //如果前面已经有两个相同字符,那就必须选取另外的一个字符
            if(len >= 2 && builder.charAt(len-1) == builder.charAt(len - 2)){
                if(builder.charAt(len - 1) == 'b'){
                    writeA = true;
                }
            }else{
                //字符中剩下的最多的就是下一步要填入的字符
                if(a >= b){
                    writeA = true;
                }
            }
            //根据判断的逻辑选择要填入的字符
            if(writeA){
                a--;
                builder.append('a');
            }else{
                b--;
                builder.append('b');
            }
        }
        return builder.toString();
    }
}
