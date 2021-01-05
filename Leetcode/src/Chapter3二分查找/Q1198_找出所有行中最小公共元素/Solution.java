package Chapter3二分查找.Q1198_找出所有行中最小公共元素;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/01/2021 20:14
 **/

public class Solution {
    /**
     * 因为每行元素都是按照从小到大排列的
     * 所以用二分搜索速度比较快
     * @param mat
     * @return
     */
    public int smallestCommonElement(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for(int j = 0; j < n; j++){
            boolean found = true;
            for(int i = 1; i < m; i++){
                found = Arrays.binarySearch(mat[i],mat[0][j]) >=0;
                //一旦某一行并不存在这个元素，那么就会返回false,跳出这个循环
                if(!found){
                    break;
                }
            }
            //说明每一行都有这个元素,那么作为答案返回
            if(found){
                return mat[0][j];
            }
        }
        return -1;
    }
}
