package Chapter11_单调栈.Q402_移掉K位数字;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/12/2020 23:09
 **/

public class Solution {
    public String removeKdigits(String num, int k) {
        Deque <Character> queue = new LinkedList <Character>();
        int len = num.length();
        for(int i = 0; i < len; i++){
            char digit = num.charAt(i);
            //当前栈不为空，移除的元素未达到要求或者栈顶元素大于当前元素，则不停弹栈
            //直到其中一个条件不满足
            while(!queue.isEmpty() && k > 0 && queue.peekLast() > digit){
                queue.pollLast();
                k--;
            }
            queue.offerLast(digit);
        }
        //防止在压入单调栈的过程中弹出的元素数目不足，说明当前是从高位到低位递增的数组
        //那么我们可以直接删除末尾的元素，这样得到的数字最小

        for(int i =0; i < k; i++){
            queue.pollLast();
        }
        boolean isFirstZero = true;
        StringBuilder builder = new StringBuilder();
        while(!queue.isEmpty()){
            char c = queue.pollFirst();
            //去除前缀0
            if(isFirstZero && c == '0'){
                continue;
            }
            isFirstZero = false;
            builder.append(c);
        }
        //可以将元素全部删除光，那么当前元素就变成0
        return builder.length() == 0 ? "0" : builder.toString();
    }
}
