package Chapter0_其他.Q717_1比特与2比特字符;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/02/2021 22:16
 **/

public class Solution {
    /**
     * 因为末尾一定是0,而且数字0可以单独组成一bit字符,但是数字1必须要和后面的字符一起组成两bit字符
     * 所以可以遇到0跳1位，遇到1跳两位,最后判断是否能到倒数第一位
     * @param bits
     * @return
     */
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while(i < bits.length - 1){
            i += bits[i] + 1;
        }
        return i == bits.length -1;
    }
}
