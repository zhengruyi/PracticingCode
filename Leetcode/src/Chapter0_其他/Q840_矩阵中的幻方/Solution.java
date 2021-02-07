package Chapter0_其他.Q840_矩阵中的幻方;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/02/2021 22:13
 **/

public class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int r = 0; r < m - 2; r++) {
            for (int c = 0; c < n - 2; c++) {
                if (grid[r + 1][c + 1] != 5) {
                    continue;
                }
                //检查3*3矩阵是否是幻方
                if (magic(grid[r][c], grid[r][c + 1], grid[r][c + 2],
                        grid[r + 1][c], grid[r + 1][c + 1], grid[r + 1][c + 2],
                        grid[r + 2][c], grid[r + 2][c + 1], grid[r + 2][c + 2])) {

                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 因为要求1..9填入矩阵总和为45,那么每一行总和15,由于上下左右和两个对角线总共经过四次中间点
     * 所以可以证明幻方的中间节点的值必定是5
     * @param vals
     * @return
     */
    public boolean magic(int... vals) {
        int[] count = new int[16];
        for (int v : vals) {
            if (v > 9) {
                return false;
            }
            count[v]++;
        }
        //检查1-9是否都只出现了一次
        for (int i = 1; i <= 9; i++) {
            if (count[i] != 1) {
                return false;
            }
        }
        //三行三列和两条对角线的值总和都是15
        return (vals[0] + vals[1] + vals[2] == 15 &&
                vals[3] + vals[4] + vals[5] == 15 &&
                vals[6] + vals[7] + vals[8] == 15 &&
                vals[0] + vals[3] + vals[6] == 15 &&
                vals[1] + vals[4] + vals[7] == 15 &&
                vals[2] + vals[5] + vals[8] == 15 &&
                vals[0] + vals[4] + vals[8] == 15 &&
                vals[2] + vals[4] + vals[6] == 15);
    }
}

