package Chapter10_动态规划.Q1310_子数组异或查询;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/11/2020 10:57
 **/

public class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xor = new int[arr.length +1];
        xor[0] =1;
        for(int i =1; i<= arr.length; i++){
            xor[i] = xor[i-1] ^ arr[i-1];
        }
        int[] res = new int[queries.length];
        //前缀异或和数组，注意前缀异或的索引就可以
        for(int i =0; i< queries.length; i++){
            res[i] = xor[queries[i][1]+1] ^ xor[queries[i][0]];
        }
        return res;
    }
}
