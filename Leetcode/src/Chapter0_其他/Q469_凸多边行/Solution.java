package Chapter0_其他.Q469_凸多边行;

import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/01/2021 21:27
 **/

public class Solution {
    /**
     * 这个题目的解法是计算从每个点出发与接下来两个点的向量的叉乘结果符号都是一样的
     * 即不存在正转负，或者负转正,对于两个向量来说(x1,y1) (x2,y2)他们的叉乘结果是
     * x1*y2 - x2 * y1
     * @param points
     * @return
     */
    public boolean isConvex(List<List <Integer>> points) {
        int n = points.size();
        long prev = 0;
        for(int i = 0; i < n; i++){
            //由于叉乘的结果可能很大序偶一采用long
            long x1 = points.get((i+1) % n).get(0) - points.get(i).get(0);
            long y1 = points.get((i+1) % n).get(1) - points.get(i).get(1);
            long x2 = points.get((i+2) % n).get(0) - points.get(i).get(0);
            long y2 = points.get((i+2) % n).get(1) - points.get(i).get(1);
            long cur = x1 * y2 - x2 * y1;
            if(cur != 0){
                //判断向量的卷积结果不会出现正负的跳变
                if(cur * prev < 0){
                    return false;
                }else{
                    prev = cur;
                }
            }
        }
        return true;
    }
}
