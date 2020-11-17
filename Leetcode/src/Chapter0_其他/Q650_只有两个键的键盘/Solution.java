package Chapter0_其他.Q650_只有两个键的键盘;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/11/2020 22:36
 **/

public class Solution {
    public int minSteps(int n) {
        //这个题目可以把所有举动分成copy和past, 而最终结果等于每组行为的数目乘积
        // num = len(c..p) * len(c..pp)....
        //又由于p+q <= p*q 对于所有p,q大于等于二都成立
        //所以最终题目分成介意把n分成多少个素数的和，素数的和就是最终结果
        int res = 0;
        int d = 2;
        while(n > 1){
            while(n % d == 0){
                //所有的素数的和就是最终的结果
                res+=d;
                n/=d;
            }
            //求下一个素数
            d++;
        }
        return res;
    }
}
