package Chapter0_其他.Q1342_将数字变成0的操作次数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/02/2021 23:25
 **/

public class Solution {
    /**
     * 运用移位和和按位与来加速计算
     * @param num
     * @return
     */
    public int numberOfSteps (int num) {
        int count = 0;
        while(num != 0){
            if((num & 1) == 1){
                num -= 1;
            }else{
                num >>= 1;
            }
            count++;
        }
        return count;
    }
}
