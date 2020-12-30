package Chapter5_滑动窗口算法.Q1151_最少交换次数来组合所有的1;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/12/2020 20:58
 **/

public class Solution {
    public int minSwaps(int[] data) {
        int countOne = 0;
        //统计所有的1个数
        for(int num : data){
            if(num == 1){
                countOne ++;
            }
        }
        //以1的总个数来作为滑动窗口的宽度
        int one = 0;
        //记录窗口中的1的个数
        for(int i = 0; i < countOne; i++){
            if(data[i] == 1){
                one++;
            }
        }
        //1的总数减去某一时刻滑动窗口中包含的最大的1的个数
        //得出的结果就是最少需要交换的次数
        int max = one;
        for(int i = countOne; i < data.length; i++){
            one += data[i] - data[i-countOne];
            max = Math.max(max,one);
        }
        return countOne - max;
    }
}
