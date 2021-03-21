package Chapter0_其他.Q66_加一;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/03/2021 23:56
 **/

public class Solution {
    /**
     * 注意反向和结束时如果还有进位，那么就需要创建一个更大的数组来容纳原来的元素
     * 比如[9,9,9]加1后，那么新的数组是[1,0,0,0]
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int sum = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            sum += digits[i];
            digits[i] = sum % 10;
            carry = sum / 10;
            if(carry == 0){
                break;
            }else{
                sum = carry;
            }
        }
        if(carry != 0){
            int[] res = new int[digits.length+1];
            //五个参数是旧数组，旧数组的起始复制位置,新数组，新数组开始容纳元素的位置,已经总共的长度
            System.arraycopy(digits,0,res,1,digits.length);
            res[0] = carry;
            digits = res;
        }
        return digits;
    }
}
