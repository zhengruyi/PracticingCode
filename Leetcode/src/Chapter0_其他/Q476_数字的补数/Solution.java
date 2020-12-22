package Chapter0_其他.Q476_数字的补数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/12/2020 23:05
 **/

public class Solution {
    public int findComplement(int num) {
        int bitNum = 0;
        int tmp = num;
        //计算出num最左边的1的位置
        while(tmp > 0){
            bitNum++;
            tmp >>= 1;
        }
        // (1 << bitNum) - 1 会生成一个长度为bitNum的有效位全1的的数字
        //在进行异或运算后就会变成原理1变成0，0变成1
        return num ^((1 << bitNum) - 1);
    }
}
