package Chapter0_其他.Q531_孤独像素I;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/02/2021 21:25
 **/

public class Solution {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;
        //统计每行每列出现的B的个数
        int[] row = new int[m];
        int[] col = new int[n];
        int res = 0;
        List <int[]> list = new ArrayList <>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //统计每行每列各有几个B
                if(picture[i][j] == 'B'){
                    row[i]++;
                    col[j]++;
                    //记录所有B的坐标
                    list.add(new int[]{i,j});
                }
            }
        }
        for(int[] location : list){
            //遍历所有的B,如果这行这列都没有B,那么就计数加1
            if(row[location[0]] == col[location[1]] && row[location[0]] == 1){
                res++;
            }
        }
        return res;
    }
}
