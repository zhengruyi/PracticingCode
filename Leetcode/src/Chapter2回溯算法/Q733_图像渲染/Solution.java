package Chapter2回溯算法.Q733_图像渲染;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/10/2020 13:29
 **/

public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        backTrack(image,sr,sc,newColor, image[sr][sc]);
        Arrays.sort(image, new Comparator <int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return 0;
            }
        });
        return image;
    }


    public void backTrack(int[][] image, int sr, int sc, int newColor, int oldColor){
        if(sr == image.length || sc == image[0].length || sr <0 || sc < 0
                || image[sr][sc] == -1 || image[sr][sc] != oldColor){
            return;
        }
        //这个将原位置设为-1，防止出现循环递归导入的栈溢出
        image[sr][sc] = -1;
        //对上下左右四个邻居进行递归计算
        backTrack(image, sr+1, sc, newColor,oldColor);
        backTrack(image, sr-1, sc, newColor,oldColor);
        backTrack(image, sr,   sc + 1, newColor,oldColor);
        backTrack(image, sr, sc -1, newColor,oldColor);
        //邻居都处理好后，将自己写成新颜色
        image[sr][sc] = newColor;
    }
}
