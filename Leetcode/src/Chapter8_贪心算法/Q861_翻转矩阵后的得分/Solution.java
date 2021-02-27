package Chapter8_贪心算法.Q861_翻转矩阵后的得分;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/02/2021 22:38
 **/

public class Solution {
    /**
     * 首先将高位全部变成1，方法是将首位是0的行进行翻转,然后看每列是0多还是1多,0多就在这一列进行翻转
     * 不多就不翻转.这样的得到的值最大
     * @param A
     * @return
     */
    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int res =  m * (1 << n-1 );
        for(int j = 1; j < n; j++){
            int one = 0;
            //统计一列是0多还是1多
            for(int i = 0; i < m; i++){
                if(A[i][0] == 1){
                    one += A[i][j];
                }else{
                    one += (1 - A[i][j]);
                }
            }
            int k = Math.max(one, m - one);
            res +=  k * ( 1 << n - 1 - j);
        }
        return res;
    }
}
