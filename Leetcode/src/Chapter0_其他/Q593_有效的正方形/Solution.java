package Chapter0_其他.Q593_有效的正方形;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/12/2020 23:47
 **/

public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = {p1,p2,p3,p4};
        //按照x和y坐标从低到高排序
        Arrays.sort(p,(o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        //首先要求边的距离不能为0，其次要求四边距离相等且对角线距离相等，那么这就是正方形
        return distance(p[0],p[1]) != 0 && distance(p[0],p[1]) == distance(p[1],p[3]) &&
                distance(p[1],p[3]) == distance(p[2],p[3]) && distance(p[2],p[3]) == distance(p[0],p[2])
                && distance(p[0],p[3]) == distance(p[1],p[2]);
    }
    /**
     * 计算距离的函数
     */
    public int distance(int[] p1, int[] p2){
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
