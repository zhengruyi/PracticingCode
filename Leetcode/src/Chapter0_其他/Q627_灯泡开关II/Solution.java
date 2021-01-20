package Chapter0_其他.Q627_灯泡开关II;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/01/2021 22:18
 **/

public class Solution {
    /**
     * 由于奇数，偶数，和3k+1的递推关系可以知道存在x = x+6也就是说
     * 1和7的状态保持一致，2和8的状态保持一致
     * 也就是说超出六个灯的状态和六个灯的状态一模一样
     * @param n
     * @param m
     * @return
     */
    public int flipLights(int n, int m) {
        //当灯数小于6时，只截取部分状态
        int shift = Math.max(0, 6 - n);
        Set <Integer> set = new HashSet <>();
        //四中操作，分作做和不做总共有16种序列
        for(int cand = 0; cand < 16; cand++){
            //统计二进制表示中1的个数
            int bitCount = Integer.bitCount(cand);
            //因为一种操作做两次和一次不做的状态一样
            //比如说4个1的15，而m = 12,那么可以8次做无用功
            //然后四次有效操作就可以达成目标
            if(bitCount % 2 == m % 2 && bitCount <= m){
                int light = 0;
                //分别表示将四种可能的操作安排上
                if(((cand >> 0) & 1) > 0){
                    //当 n < 6 时,右移固定位数来缩小有限的状态
                    light ^= 0b111111 >> shift;
                }
                if(((cand >> 1) & 1) > 0){
                    light ^= 0b010101 >> shift;
                }
                if(((cand >> 2) & 1) > 0){
                    light ^= 0b101010 >> shift;
                }
                if(((cand >> 3) & 1) > 0){
                    light ^= 0b100100 >> shift;
                }
                set.add(light);
            }
        }
        //最后集合中的数字数目就是可能的灯状态的种类数
        return set.size();
    }
}
