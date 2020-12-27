package Chapter0_其他.Q223_矩形面积;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/12/2020 22:14
 **/

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //交换两个矩阵保证ABCD描述的矩阵在左边
        if(A > E){
            return computeArea(E,F,G,H, A,B,C,D);
        }
        //两个矩阵没有相交，则面积之和是两个独立矩阵的面积之和
        if(C <= E || F >= D || H <= B){
            return (D - B) * (C - A) + (G - E) * (H - F);
        }
        //计算出重叠部分的坐标
        int up = Math.min(C,G);
        int right = Math.min(D,H);
        int down = Math.max(A,E);
        int left = Math.max(B,F);
        //两个矩阵的总面积等于两个矩阵独立面积之和减去重叠部分
        return (D - B) * (C - A) + (G - E) * (H - F) - (up - down) * (right - left);
    }
}
