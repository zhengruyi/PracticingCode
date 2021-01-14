package Chapter0_其他.Q1209_删除字符串中的所有相邻重复项II;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/01/2021 20:47
 **/

public class Solution {
    public String removeDuplicates(String s, int k) {
        //保存字符串
        StringBuilder builder = new StringBuilder(s);
        //统计连续字符的出现次数
        Stack<Integer> stack = new Stack <>();
        for(int i = 0; i < builder.length();i++){
            //如果栈为空或者当前元素不等于前一个元素，那么久往栈里面添加一个1
            if(i == 0 || builder.charAt(i) != builder.charAt(i-1)){
                stack.push(1);
            }else{
                //说明当前元素和前一个元素相等，所以给栈顶元素加1
                int times = stack.pop() + 1;
                //表示有连续k的字符存在满足删除条件
                if(times == k){
                    //删除固定数量的字符
                    builder.delete(i - k + 1, i+1);
                    //由于删除后字符串长度变短k了，所以更新一下索引的位置,i也减去k
                    i = i - k;
                }else{
                    //将字符出现频率压入栈中
                    stack.push(times);
                }
            }
        }
        return builder.toString();
    }
}
