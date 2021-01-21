package Q17_打印从1到最大的n位数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/01/2021 21:58
 **/

public class Solution {
    public int[] printNumbers(int n) {
        int end = 1;
        //由于做大的多位数一定是9...9
        //所以这里求出上界，然后求出所有的值
        while(n > 0){
            end *= 10;
            n--;
        }
        //赋值答案
        int[] res = new int[end-1];
        for(int i =1; i < end; i++){
            res[i-1] = i;
        }
        return res;
    }
}
