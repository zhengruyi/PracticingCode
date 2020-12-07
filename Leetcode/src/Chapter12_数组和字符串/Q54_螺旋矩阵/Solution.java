package Chapter12_数组和字符串.Q54_螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/12/2020 18:41
 **/

public class Solution {
    public List <Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return new ArrayList <Integer>();
        }
        //从四个方向向中间靠拢
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<Integer>(m*n);
        int u = 0,l=0,r=n-1,b=m-1;
        while(true){
            //从左上往右上遍历，并把结果放入链表中
            for(int j = l; j <= r; j++){
                res.add(matrix[u][j]);
            }
            //更新起始行的位置
            if(++u > b){
                break;
            }
            //从右上往右下遍历
            for(int i = u; i <= b; i++){
                res.add(matrix[i][r]);
            }
            //更新最右边的位置
            if(--r < l){
                break;
            }
            //从右下遍历到左下
            for(int j = r; j >= l; j--){
                res.add(matrix[b][j]);
            }
            //更新末行的位置
            if(--b < u){
                break;
            }
            //从左下到左上
            for(int i = b; i >=u; --i){
                res.add(matrix[i][l]);
            }
            //更新左边一列的位置
            if( ++l > r){
                break;
            }
        }
        return res;
    }
}
