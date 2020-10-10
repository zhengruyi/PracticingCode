package Chapter0_功能验证性代码.Q7_每日温度;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/07/2020 20:44
 **/

public class Solution {
    public static int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return new int[]{};
        }
        Stack <Integer> stack = new Stack<Integer>();
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            if(stack.isEmpty() || T[stack.peek()] >= T[i]){
                stack.push(i);
            }else{
                while (!stack.isEmpty() && T[stack.peek()] < T[i]){
                    int temp = stack.pop();
                    result[temp] = i - temp;
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()){
            result[stack.pop()] = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] response = dailyTemperatures(temperatures);
        for (int i = 0; i < response.length; i++) {
            System.out.print(response[i]+" ");
        }
    }
}
