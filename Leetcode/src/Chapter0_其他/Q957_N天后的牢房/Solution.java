package Chapter0_其他.Q957_N天后的牢房;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/12/2020 21:57
 **/

public class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        //最多有2^6 = 64种情况
        int[] memo = new int[100];
        int bin = 0;
        int digit = 1;
        //将二进制合并成整数
        for(int i = cells.length -1; i >= 0; i--){
            bin += digit * cells[i];
            digit *= 2;
        }
        //0x7e = 0111 1110
        //这里必须需要先计算一次，因为原始的情况可能首尾为1
        //那么如果不出里的话永远都找不到循环,因为第一次过后首尾必定是0,且以后必定都是0
        bin = ~(bin << 1 ^ bin >> 1) & 0x7e;
        memo[0] = bin;
        int start = bin;
        for(int i = 1; i < N; i++){
            //考虑左右的情况就等于左移和右移后的结果求同或，即异或结果取反就可以了
            bin = ~(bin << 1 ^ bin >> 1) & 0x7e;
            //检测到循环
            if(bin == start){
                //这里N-1是去除一开始的那一次
                bin = memo[(N-1) % i];
                break;
            }else{
                memo[i] = bin;
            }
        }
        int index = cells.length -1;
        //将整数拆分成二进制
        while(index >= 0){
            cells[index--] = bin % 2;
            bin >>= 1;
        }
        while(index >= 0){
            cells[index--] = 0;
        }
        return cells;
    }
}
