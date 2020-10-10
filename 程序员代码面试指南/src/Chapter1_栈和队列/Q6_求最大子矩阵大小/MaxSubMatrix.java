package Chapter1_栈和队列.Q6_求最大子矩阵大小;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/05/2020 13:52
 **/
/*
   相当复杂
 */
public class MaxSubMatrix {
    public int getSubMatrix(int[][] matrix){
        if(matrix == null || matrix.length == 0){
            return -1;
        }
        int[] height = new int[matrix[0].length];
        int area = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    height[j] = 0;
                }else{
                    height[j] += 1;
                }
            }
            area = Math.max(area, getArea(height));
        }
        return area;
    }
    public int getArea(int[] height){
        int area = -1;
        Stack<Integer> stack = new Stack <>();
        for (int i = 0; i < height.length; i++) {
            boolean flag = true;
            while (flag){
                if(stack.isEmpty()){
                    flag = false;
                    stack.push(i);
                }else if(height[i] > height[stack.peek()]){
                    flag = false;
                    stack.push(i);
                }else{
                    int j = stack.pop();
                    int k;
                    if(stack.isEmpty()){
                        k = -1;
                    }else{
                        k= stack.peek();
                    }
                    area = Math.max((i - k -1)* height[j],area);
                }
            }
        }
        while (!stack.isEmpty()){
            int j = stack.pop();
            int k;
            if(stack.isEmpty()){
                k = -1;
            }else{
                k= stack.peek();
            }
            area = Math.max(area, (height.length - k -1)* height[j]);
        }
        return area;
    }

    @Test
    void test(){
        int[][] matrix1 = new int[][]{{1,1,1,0}};
        Assertions.assertEquals(3,getSubMatrix(matrix1));
        int[][] matrix = new int[][]{
                {1,0,1,1},
                {1,1,1,1},
                {1,1,1,0}
        };
        Assertions.assertEquals(6,getSubMatrix(matrix));
    }
}
