package Chapter0_其他.Q1497_检查数组对是否可以被k整除;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/03/2021 23:32
 **/

public class Solution {
    /**
     * 对k取余后,然后如果是负数再加上k,如果是正数就在对应的0..k-1的余数位置上加1,
     * 最后考虑是否可以将余数分成多组和为k的两个数,这里特殊考虑当k为偶数时，多以 2* m = 时，对于
     * m的处理,因为这时 arr[m] == arr[k-m]必然成立,所以需要额外考虑一个arr[0] % 2 == 0也必须成立
     * @param arr
     * @param k
     * @return
     */
    public boolean canArrange(int[] arr, int k) {
        int[] count = new int[k];
        for(int num : arr){
            num %= k;
            num = num < 0 ? k + num : num;
            ++count[num];
        }
        for(int i = 1; i <= k / 2; i++){
            if(count[i] != count[k-i]){
                return false;
            }
        }
        return count[0] % 2 == 0;
    }
}
