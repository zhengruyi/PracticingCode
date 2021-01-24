package Chapter0_其他.Q754_到达终点数字;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/01/2021 19:28
 **/

public class Solution {
    /**
     * 这题等价于给1..i的数组中选取一些元素加上负号，然后要求整个数组的元素和等于target
     * 假设数组的正数和p，数组中选出的要添加负号的那部分数字和为n
     * 那么:
     * p+ n = s;
     * p - n = target;
     * s - target = 2 * n >= 0
     * 而且s = 1 + 2 + 3..+i = (i+1) * i /2;
     * 所以题目的意思转化成 找到最小的数字i 使得 i * (i+1) /2 - target >= 0 并且是偶数
     * @param target
     * @return
     */
    public int reachNumber(int target) {
        target = Math.abs(target);
        int num = 1;
        while(true){
            int value = (num + 1) * num /2 - target;
            if( value >= 0 && value % 2 == 0){
                break;
            }
            num++;
        }
        return num;
    }
}
