package Chapter0_其他.Q03_机器人大冒险;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/03/2021 23:24
 **/

public class Solution {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        Set <Long> set = new HashSet();
        int offsetX = 0;
        int offsetY = 0;
        //将起点放入集合
        set.add(((long) offsetX << 30) | offsetY);
        for(int i = 0 ; i < command.length(); i++){
            if(command.charAt(i) == 'U'){
                offsetY++;
            }else if(command.charAt(i) == 'R'){
                offsetX++;
            }
            //计算单次移动所经过的坐标
            set.add(((long) offsetX << 30) | offsetY);
        }
        //单次移动后就知道每一轮的在横纵坐标上的偏移量
        //所以我们减去这些轮数，查看终点是否在路径上
        int min = Math.min(x/ offsetX, y / offsetY);
        //无法到达终点
        if(!set.contains(((long)(x- min * offsetX) << 30) | (y- min * offsetY))){
            return false;
        }
        //计算路径上是否存在障碍物
        for(int[] ob : obstacles){
            if(ob.length != 2){
                continue;
            }
            if(ob[0] > x || ob[1] > y){
                continue;
            }
            //去除障碍物坐标的轮数
            min  = Math.min(ob[0]/offsetX, ob[1] / offsetY);
            //路径上有障碍物
            if(set.contains(((long)(ob[0] - min * offsetX) << 30) | (ob[1]- min * offsetY))){
                return false;
            }
        }
        return true;
    }
}
