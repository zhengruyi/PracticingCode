package Chapter11_单调栈.Q735_行星碰撞;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/12/2020 00:58
 **/

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack <>();
        for(int i = 0; i <  asteroids.length; i++){
            //当栈部位空，两颗行星运动方向相反，且是左边朝右，右边朝左时才可能发生碰撞
            if(!stack.isEmpty() && stack.peek() * asteroids[i] < 0){
                while(!stack.isEmpty() && stack.peek() * asteroids[i] < 0 && stack.peek() > 0
                        //这里表示未入栈的行星质量较大，则依据规则，栈顶行星会被撞碎
                        && Math.abs(stack.peek()) < Math.abs(asteroids[i])){
                    stack.pop();
                }

            }
            //在栈为空，或者两颗行星运动方向相同或者运动方向相反但是是相反方向运动时才可以入栈
            if(stack.isEmpty() || stack.peek() * asteroids[i] > 0 || stack.peek() < 0){
                stack.push(asteroids[i]);
                //特殊考虑，相向运动且质量相等时，这时两颗行星会同时破碎
            }else if(Math.abs(stack.peek()) == Math.abs(asteroids[i])){
                stack.pop();
            }
        }
        int[] res = new int[stack.size()];
        int len = stack.size();
        for(int i = 1; i <= len; i++){
            res[len-i] = stack.pop();
        }
        return res;
    }
}
