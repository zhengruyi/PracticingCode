package Chapter0_其他.Q71_简化路径;

import java.util.LinkedList;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/12/2020 22:24
 **/

public class Solution {
    public String simplifyPath(String path) {
        //由于既要利用到栈。也要利用到队列特性，所以这里采用LinkedList
        LinkedList <String> stack = new LinkedList<>();
        //切分字符串
        String[] strs = path.split("/");
        for(int i = 0; i < strs.length; i++){
            //空字符和.表示当前队列，所以这届跳过
            if(strs[i].equals("") || strs[i].equals(".")){
                continue;
            }
            //..表示上层队列，所以这里直接弹栈
            if(strs[i].equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                continue;
            }
            //入栈
            stack.push(strs[i]);
        }
        StringBuilder builder = new StringBuilder();
        //如果站里面没有元素，那么结果就是根路径
        builder.append("/");
        int size = stack.size();
        for(int i = 0; i < size; i++){
            builder.append(stack.pollLast());
            //最后一段路径不要加/
            if(i != size -1){
                builder.append("/");
            }
        }
        return builder.toString();
    }
}
