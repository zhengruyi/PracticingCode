package Chapter0_其他.Q835_图像重叠;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/01/2021 21:25
 **/

public class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int N = img1.length;
        //同来统计两个图像中的1的位置相对偏移量的出现次数
        int[][] count = new int[2 * N + 1][2 * N + 1];
        //填补数组，然后更新对应偏移量的出现次数
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(img1[i][j] == 1){
                    for(int k = 0; k < N; k++){
                        for(int l = 0; l < N; l++){
                            if(img2[k][l] == 1){
                                count[i - k + N][j - l + N] ++;
                            }
                        }
                    }
                }
            }
        }
        //偏移量出现次数最多的就是，两个图像偏移后数字1重合个数最多的
        int ans = 0;
        for(int[] row : count){
            for(int v : row){
                ans = Math.max(ans,v);
            }
        }
        return ans;
    }
}
