package Chapter0_其他.Q1545_找出第N个二进制字符串中的第K位;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/12/2020 23:20
 **/

public class Solution {
    public char findKthBit(int n, int k) {
        int invertNum = 0;
        while(n > 1){
            //由于每次序列长度必定是奇数，那么中间位置一定是偶数
            int mid = (int)Math.pow(2,n-1);
            //中间位置一定是1，那么计算这个1将要变换的次数，偶数则认为1，奇数则为0
            if(k == mid){
                return invertNum % 2 == 0 ? '1' : '0';
            }
            //低于mid，那么本轮循环不变，高于mid,那么就需要急需要计算上一轮的位置
            if( k > mid){
                //相当于右部分 k - mid,由于有翻转流程那么在上一轮的位置为mid - (k - mid) = mid * 2 - k
                k = 2 * mid - k;
                //计算变换的次数
                invertNum++;
            }
            n--;
        }
        return invertNum % 2 == 0 ? '0' : '1';
    }
}
