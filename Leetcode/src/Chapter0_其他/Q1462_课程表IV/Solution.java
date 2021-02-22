package Chapter0_其他.Q1462_课程表IV;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/02/2021 23:34
 **/

public class Solution {
    public List <Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] map = new boolean[n][n];
        //按照前序要求把所有前后关系都记录下来
        for(int[] prerequery : prerequisites){
            map[prerequery[0]][prerequery[1]] = true;
        }
        //自己是自己的前序
        for(int i = 0; i < n; i++){
            map[i][i] = true;
        }
        //这里很重要,按照 a->b, b -> c => a -> c
        //所以这里按照列的方式遍历,k在这里表示是每一列
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(map[i][k] && map[k][j]){
                        map[i][j] = true;
                    }
                }
            }
        }
        //侯建答案
        List<Boolean> res = new ArrayList();
        for(int[] query : queries){
            if(map[query[0]][query[1]]){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
}
