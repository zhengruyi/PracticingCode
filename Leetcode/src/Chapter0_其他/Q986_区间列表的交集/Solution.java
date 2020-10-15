package Chapter0_其他.Q986_区间列表的交集;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/10/2020 15:56
 **/

public class Solution {
    /**
     * 画出所有可能的情况，总结规律
     * @param A
     * @param B
     * @return
     */
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List <int[]> list = new ArrayList <int[]>();
        int i =0;
        int j = 0;
        int len1 = A.length;
        int len2 = B.length;
        while( i < len1 && j < len2){
            int a1 = A[i][0];
            int a2 = A[i][1];
            int b1 = B[j][0];
            int b2 = B[j][1];
            //有交集的判断条件
            if(a2 >= b1 && b2 >= a1){
                //交集的区间范围
                list.add(new int[]{Math.max(a1,b1),Math.min(b2,a2)});
            }
            //递增条件范围
            if(b2 > a2){
                i++;
            }else{
                j++;
            }
        }
        int[][] res = new int[list.size()][2];
        for(int n = 0; n< list.size();n++){
            res[n] = list.get(n);
        }
        return res;
    }
}
