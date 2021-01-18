package Chapter14_深度搜索和广度搜索.Q443_最小基因变化;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/01/2021 20:54
 **/

public class Solution {
    /**
     * 广度遍历，以起点开始遍历bank数组，然后调用函数检查，保证两个字符串之间
     * 只有一个字符不同，然后把这个字符串标记访问过了然后将新的字符串入队
     * 开启下一轮宽度遍历
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        Queue <String> queue = new LinkedList <>();
        boolean[] visited = new boolean[bank.length];
        queue.offer(start);
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            //每次先记录队列长度再进行遍历,每次遍历完都将步数加一
            for(int i = 0; i <size; i++){
                String s = queue.poll();
                if(s.equals(end)){
                    return step;
                }
                for(int j = 0; j < bank.length; j++){
                    if(!visited[j] && check(s,bank[j])){
                        visited[j] = true;
                        queue.offer(bank[j]);
                    }
                }
            }
            step++;
        }
        //不可到达目的地,返回负一
        return -1;
    }
    public boolean check(String s1, String s2){
        int diff = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                diff++;
            }
        }
        return diff == 1;
    }
}
