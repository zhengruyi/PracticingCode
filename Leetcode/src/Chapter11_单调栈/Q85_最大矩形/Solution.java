package Chapter11_单调栈.Q85_最大矩形;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/11/2020 22:30
 **/

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[] heights = new int[matrix[0].length+2];
        int area = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                //把矩阵通过一行行的叠加把矩阵转换成一位数组，由于矩阵的中的1的个数
                //转化成一位数组中的矩阵高度从而转化成Q84的问题,可以求出最大子矩阵的面积
                if(matrix[i][j] == '1'){
                    heights[j+1] = heights[j+1] + 1;
                }else{
                    heights[j+1] = 0;
                }
            }
            area = Math.max(area,largestRectangleArea(heights));
        }
        return area;
    }
    //同Q84代码原理一样给定一组矩阵高度去求最大的矩形面积
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 1){
            return heights[0];
        }
        int len = heights.length;
        Stack <Integer> stack = new Stack<>();
        stack.push(0);
        int area = 0;
        for(int i =1; i< len; i++){
            while(heights[i] < heights[stack.peek()]){
                int h = heights[stack.pop()];
                area = Math.max(area, (i-stack.peek() -1) * h);
            }
            stack.push(i);
        }
        return area;
    }
}
