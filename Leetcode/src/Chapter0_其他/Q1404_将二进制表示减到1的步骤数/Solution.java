package Chapter0_其他.Q1404_将二进制表示减到1的步骤数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/03/2021 23:25
 **/

public class Solution {
    public int numSteps(String s) {
        int len = s.length();
        int res = 0;
        int carry = 0;
        for(int i = len - 1; i > 0; i--){
            //两者之和为奇数,那么要用两次才能完成移除当前位置
            if((s.charAt(i) == '0' && carry == 1) || (s.charAt(i) == '1' && carry == 0)){
                res += 2;
                carry = 1;
                //偶数只用一次,无进位
            }else if(s.charAt(i) == '0' && carry == 0){
                res += 1;
            }else{
                //偶数有进位
                res += 1;
                carry = 1;
            }
        }
        //最后如果出现carry == 1那么和开头的1相加会触发一次操作
        res += carry;
        return res;
    }
}
