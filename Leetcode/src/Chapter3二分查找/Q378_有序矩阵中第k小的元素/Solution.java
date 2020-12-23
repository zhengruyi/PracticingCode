package Chapter3二分查找.Q378_有序矩阵中第k小的元素;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/12/2020 20:30
 **/

public class Solution {
    int[][] matrix;
    public int kthSmallest(int[][] matrix, int k) {
        this.matrix = matrix;
        int n = matrix.length;
        //二分搜索查找
        int left = matrix[0][0];
        //这里故意把右界设置成这样,因为这样就可以当左边界超出时正好指向最后一个元素
        int right = matrix[n-1][n-1];
        while(left < right){
            int mid = left +((right -left) >> 1);
            if(check(n,k,mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 从左下角开始计算小于等于当前mid值的元素个数，由于元素从左到右从上到下都是递增的
     * 所以统计时直接用行号来计算总元素
     * @param n
     * @param k
     * @param mid
     * @return
     */
    public boolean check(int n, int k, int mid){
        int i = n-1;
        int j = 0;
        int num = 0;
        while(i >= 0 && j < n){
            if(matrix[i][j] <= mid){
                num += i+1;
                j++;
            }else{
                i--;
            }
        }
        return num >= k;
    }
}
