package Chapter4_双指针技巧.Q826_安排工作以达到最大收益;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/02/2021 23:43
 **/

public class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        //根据难度和收益构成数组
        Point[] points = new Point[difficulty.length];
        for(int i = 0; i < difficulty.length; i++){
            points[i] = new Point(difficulty[i],profit[i]);
        }
        //根据难度排序
        Arrays.sort(points,(o1,o2) -> o1.x - o2.x);
        //根据工作能力排序
        Arrays.sort(worker);
        //i表示搜索到的难度数组的索引，以及best表示在能力范围内获得的最大利益
        int i = 0, best = 0, max = 0;
        for(int w : worker){
            while(i < difficulty.length && w >= points[i].x){
                best = Math.max(best,points[i++].y);
            }
            max += best;
        }
        return max;
    }
}
class Point{
    public int x;
    public int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}