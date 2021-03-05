package Chapter0_其他.Q1122_数组的相对排序;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/03/2021 23:00
 **/

public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len = arr1.length;
        int[] res = new int[len];
        int[] times = new int[1001];
        //统计数字频率
        for(int num : arr1){
            times[num]++;
        }
        //按照数字在arr2中的顺序进行排序
        int index = 0;
        for(int num : arr2){
            while(times[num] > 0){
                res[index++] = num;
                times[num]--;
            }
        }
        //将未出现的数字添加到末尾
        for(int i = 0; i < times.length;i++){
            while(times[i] > 0){
                res[index++] = i;
                times[i]--;
            }
        }
        return res;
    }
}
