package Chapter0_其他.Q1134_阿姆斯特朗数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/03/2021 23:08
 **/

public class Solution {
    /**
     * 按个数字计算就可以
     * @param N
     * @return
     */
    public boolean isArmstrong(int N) {
        long res = 0;
        int origin = N;
        int len = String.valueOf(N).length();
        while(N > 0){
            int num = N % 10;
            N /= 10;
            res = res + (long)Math.pow(num,len);
            if(res > origin){
                return false;
            }
        }
        return (int)res == origin;
    }
}
