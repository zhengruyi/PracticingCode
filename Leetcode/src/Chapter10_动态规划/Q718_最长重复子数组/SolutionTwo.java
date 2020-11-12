package Chapter10_动态规划.Q718_最长重复子数组;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/11/2020 22:34
 **/

public class SolutionTwo {
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int res = 0;
        //通过不同的数组对其方式来求得最大子数组长度
        //第一种对其方式，B数组不动，A数组不断向后移动
        for(int i =0; i < m; i++){
            int len = Math.min(m - i,n);
            res = Math.max(maxLength(A,B,i,0,len),res);
        }
        //第二种对齐方式，A数组不动，B数组不断向后退
        for(int j =0; j < n; j++){
            int len = Math.min(m,n - j);
            res = Math.max(maxLength(A,B,0,j,len),res);
        }
        //全局最大公共子数组长度就是最优解
        return res;
    }
    //求两个数组的最大公共子数组长度
    public int maxLength(int[] A, int[] B, int offsetA, int offsetB, int len){
        int res = 0;
        int tmp = 0;
        for(int i =0; i< len; i++){
            if(A[offsetA+i] == B[offsetB+i]){
                tmp++;
                res = Math.max(tmp,res);
            }else{
                tmp = 0;
            }
        }
        return res;
    }
}
