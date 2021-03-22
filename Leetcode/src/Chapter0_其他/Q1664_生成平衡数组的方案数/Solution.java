package Chapter0_其他.Q1664_生成平衡数组的方案数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/03/2021 22:06
 **/

public class Solution {
    public int waysToMakeFair(int[] nums) {
        int sumOdd = 0;
        int sumEven = 0;
        //统计区间的奇数和偶数的位置的元素和
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0){
                sumEven += nums[i];
            }else{
                sumOdd += nums[i];
            }
        }
        //这个方式根据的原理是一个数字的奇数和偶数位置的元素和相等
        int count = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            //当前索引位置为偶数
            if(i % 2 == 0){
                //那么这个元素删除,那么所有偶数索引的元素和就减去这个数字,这样从最后一位往前遍历
                //那么此时sumEven表示的就是0..i中间所有偶数索引处的元素和,因为前面的索引奇偶性不变
                //所以数字也就不变
                sumEven -= nums[i];
                //如果奇数位和偶数位元素和相等,那么这是一个平衡点
                if(sumEven == sumOdd){
                    count++;
                }
                //之后如果前面一个数字被删除,那么索引就会从偶数变成奇数
                //所以这里加到奇数位元素和上面
                sumOdd += nums[i];
            }else{
                //奇数也是一样
                sumOdd -= nums[i];
                if(sumEven == sumOdd){
                    count++;
                }
                sumEven += nums[i];
            }
        }
        return count;
    }
}
