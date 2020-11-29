package Chapter12_数组和字符串.Q498_对角线遍历;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/11/2020 23:19
 **/

public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return new int[]{};
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m*n];
        int index = 0;
        int i =0;
        //对角线遍历每次循环坐标的和是一个固定的值，这里把这个值设置成i,当矩阵为一行时i最大为m+n-1
        while(i < m+n){
            //奇数次循环，方向从左下到右上，行号逐渐较小，列号逐渐增大，行号起始值最大m-1
            int x1 = i < m ? i : m-1;
            int y1 = i - x1;
            while(x1 >=0 && y1 < n){
                res[index++] = matrix[x1][y1];
                x1--;
                y1++;
            }
            //遍历完成i++
            i++;
            //对于奇数行矩阵，在这里跳出
            if(i>= m+ n){
                break;
            }
            //偶数行遍历，从右上到左下，行号逐渐增大，列号逐渐减小，列号最大为n-1
            int y2 = i < n ? i : n-1;
            int x2 = i - y2;
            while(y2 >= 0 && x2 < m){
                res[index++] = matrix[x2][y2];
                y2--;
                x2++;
            }
            i++;
        }
        return res;
    }
}
