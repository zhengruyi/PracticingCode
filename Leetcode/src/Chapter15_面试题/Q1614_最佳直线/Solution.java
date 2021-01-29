package Chapter15_面试题.Q1614_最佳直线;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/01/2021 22:25
 **/

public class Solution {
    public int[] bestLine(int[][] points) {
        int max = 0;
        int[] res = new int[2];
        int len = points.length;
        //简单的暴力遍历，找出在一条直线上的点数最多的直线
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                int num = 2;
                long x1 = points[i][0] - points[j][0];
                long y1 = points[i][1] - points[j][1];
                for(int k = j + 1; k < len; k++){
                    long x2 = points[i][0] - points[k][0];
                    long y2 = points[i][1] - points[k][1];
                    //在一条直线的条件时 y1/x1 == y2/x2
                    //那么为了处理x2等于0的情况,那么变换成 y1 * x2 == x1 * y2
                    if(x1 * y2 == x2 * y1){
                        num++;
                    }
                }
                //更新最大长度
                if(num > max){
                    res[0] = i;
                    res[1] = j;
                    max = num;
                }
            }
        }
        return res;
    }
}
