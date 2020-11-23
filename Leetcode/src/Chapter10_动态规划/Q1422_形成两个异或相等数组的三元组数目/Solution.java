package Chapter10_动态规划.Q1422_形成两个异或相等数组的三元组数目;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/11/2020 11:03
 **/

public class Solution {
    public int countTriplets(int[] arr) {
        if(arr.length < 2){
            return 0;
        }
        int[] xor = new int[arr.length +1];
        xor[0] = 1;
        for(int i =1; i <= arr.length; i++){
            xor[i] = xor[i-1] ^ arr[i-1];
        }
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1;j < arr.length; j++){
                //如果区间i..j的异或和为0，那么在中间任意取一个位置k,都可以i...k-1 和k..j的异或和相等
                //这样的位置总共有j-i个,因为k可以等于j，但不能等于i,所以总共有区间长度j-i+1在减去1
                if((xor[j+1] ^ xor[i]) == 0){
                    res+= j-i;
                }
            }
        }
        return res;
    }
}
