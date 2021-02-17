package Chapter0_其他.Q1259_灯泡开关IV;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/02/2021 19:23
 **/

public class Solution {
    /**
     * 假设初始状态为0，那么如果当前值和后面一个人值不一样，那么当前一定经过一次灯泡操作
     * 所以操作次数加1,遍历完就是结果
     * @param target
     * @return
     */
    public int minFlips(String target) {
        int res = 0;
        int prev = '0';
        for(int i = 0; i < target.length(); i++){
            if(target.charAt(i) != prev){
                res++;
                prev = target.charAt(i);
            }
        }
        return res;
    }
}
