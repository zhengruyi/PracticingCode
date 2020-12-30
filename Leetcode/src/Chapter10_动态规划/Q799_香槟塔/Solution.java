package Chapter10_动态规划.Q799_香槟塔;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/12/2020 21:09
 **/

public class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] volume = new double[102][102];
        //(0,0)出记录所有流入的香槟量，只能有一份流入其余都会流出
        volume[0][0] = poured;
        for(int i = 0; i <= query_row; i++){
            for(int j = 0; j <= query_glass; j++){
                // volume[i][j] = (volume[i-1][j]-1)/2 + (volume[i-1][j-1] - 1)/2
                double q =  (volume[i][j] - 1.0)/2;
                if(q > 0){
                    volume[i+1][j] += q;
                    volume[i+1][j+1] += q;
                }
            }
        }
        //最终计算结果和1取最小值，因为杯子的最大容量为1
        return Math.min(1,volume[query_row][query_glass]);
    }
}
