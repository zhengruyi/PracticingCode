package Chapter5_滑动窗口算法.Q1052_爱生气的书店老板;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/01/2021 23:41
 **/

public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int ans = 0;
        int value = 0;
        int m = customers.length;
        //这里计算了不使用技能时，满意的顾客数目
        for(int i = 0; i < m; i++){
            //这里计算初始区间使用技能时额外的满意的顾客数目
            if(i < X && grumpy[i] == 1){
                value += customers[i];
            }
            if(grumpy[i] == 0){
                ans += customers[i];
            }
        }
        int additionalValue = value;
        int max = value;
        for(int i = X; i < m; i++){
            //滑动串口的窗口长度定长，所以移动时必然左边冒出，右边进入
            //这里的additionalValue是指代使用技能所能导致的额外顾客满意数目
            //所以进行动态更新，即减去左边出去的而加上右边进入的
            if(grumpy[i - X] == 1){
                additionalValue -= customers[i - X];
            }
            if(grumpy[i] == 1){
                additionalValue += customers[i];
            }
            max = Math.max(max,additionalValue);
        }
        //总数目等于固定的顾客满意数目加上使用技能额外能得到的顾客数目
        return ans + max;
    }
}
