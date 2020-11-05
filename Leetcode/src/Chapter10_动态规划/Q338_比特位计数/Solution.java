package Chapter10_动态规划.Q338_比特位计数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/11/2020 22:56
 **/

public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i =1; i<= num ;i++){
            //偶数的二进制中1的位数和它右移一位的得到的数字相同，因为偶数的末尾肯定为0
            if((i &1) == 0){
                res[i] = res[i/2];
            }else{
                //奇数的二进制中1的位数等于它减去1得到的偶数位数加1
                res[i] = res[i-1] +1;
            }
        }
        return res;
    }
}
