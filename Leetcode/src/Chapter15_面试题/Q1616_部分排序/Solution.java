package Chapter15_面试题.Q1616_部分排序;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/02/2021 23:35
 **/

public class Solution {
    /**
     * 左边的最大值大于中间数组的最小值，那么代表i一定在需要排序的序列里
     * 如果右边的最小值小于中间数组的最大值，那么这个最大值所在的序列也需要重新排序
     * 综上，两个索引之间的序列都需要重排序
     * @param array
     * @return
     */
    public int[] subSort(int[] array) {
        int left = -1;
        int right = -1;
        if(array == null || array.length == 0){
            return new int[]{left,right};
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = array.length;
        for(int i = 0; i < len; i++){
            if(array[i] < max){
                right = i;
            }else{
                max = array[i];
            }

            if(array[len - i - 1] > min){
                left = len - i - 1;
            }else{
                min = array[len - i -1];
            }
        }
        return new int[]{left,right};
    }
}
