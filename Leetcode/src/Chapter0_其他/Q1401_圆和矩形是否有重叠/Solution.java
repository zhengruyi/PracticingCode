package Chapter0_其他.Q1401_圆和矩形是否有重叠;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/04/2021 20:31
 **/

public class Solution {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        //计算矩形的中心的坐标
        double x0 = (x1 + x2)/ 2.0;
        double y0 = (y1 + y2)/ 2.0;
        //计算从矩形中心指向圆心的向量p的坐标
        double[] p = {Math.abs(x_center - x0), Math.abs(y_center - y0)};
        //计算从矩形中心指向矩形右上角的向量的坐标
        double[] q = {x2 - x0,y2 - y0};
        //计算从矩形右上角指向圆心的向量,负数因为只考虑距离,如果x < 0
        //表示圆心的坐标的x值小于右上角的坐标的x值,那么这时中需要考虑垂直距离
        // y < 0也是同理
        double deltaX = Math.max(p[0] - q[0], 0);
        double deltaY = Math.max(p[1] - q[1], 0);
        //最后检查向量的长度和半径的大小
        return deltaX * deltaX + deltaY * deltaY <= radius * radius;
    }
}
