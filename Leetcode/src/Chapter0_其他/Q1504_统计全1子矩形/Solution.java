package Chapter0_其他.Q1504_统计全1子矩形;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/03/2021 23:42
 **/

public class Solution {
    public int numSubmat(int[][] mat) {
        int res = 0;
        int m = mat.length;
        int n = mat[0].length;
        //逐行遍历
        for(int i = 0; i < m; i++){
            for(int j = i; j < m; j++){
                int now = 0;
                //计算一横行的矩阵数目
                for(int k = 0; k < n; k++){
                    if(mat[j][k] == 0){
                        now = 0;
                    }else{
                        now = now + 1;
                        res += now;
                    }
                }

            }
            //矩阵压缩,剩下的横行矩阵纵向上都是n= 2,3,4....n-1
            for(int j = m - 1; j > i; j--){
                for(int k = 0; k < n; k++){
                    mat[j][k] = mat[j][k] & mat[j-1][k];
                }
            }
        }
        return res;
    }
}
