package Chapter10_动态规划.Q1524_和为奇数的子数组数目;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/03/2021 22:54
 **/

public class Solution {
    public int numOfSubarrays(int[] arr) {
        //根据初始值计算长度为1 的奇数和偶数子数组
        int even = 1 - arr[0] % 2;
        int odd = arr[0] % 2;
        //以arr[i]为结尾的奇偶子数组数目
        int next_odd = 0;
        int next_even = 0;
        int res = 0;
        int mod = (int)1e9+7;
        res += odd;
        for(int i = 1; i < arr.length; i++){
            //当前数字为奇数,那么以当前数字为结尾的奇数和子数组等于前面偶数和的子数组上模加1
            if(arr[i] % 2 == 1){
                //奇数加奇数等于偶数
                next_even = odd;
                next_odd = even + 1;
            }else{
                //同理当前为偶数,那么以当前数字为结尾的子数组和前面的一样
                next_even = even + 1;
                next_odd = odd;
            }
            //更新状态
            res += next_odd;
            res %= mod;
            even = next_even;
            odd = next_odd;
        }
        return res;
    }
}
