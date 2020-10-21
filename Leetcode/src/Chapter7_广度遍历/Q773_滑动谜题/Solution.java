package Chapter7_广度遍历.Q773_滑动谜题;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/10/2020 17:39
 **/

public class Solution {
    public int slidingPuzzle(int[][] board) {
        if (board == null) {
            return 0;
        }
        //创建每个元素相邻的邻居坐标
        int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        //防止重复用到的集合
        Set <String> set = new HashSet <String>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                builder.append(board[i][j]);
            }
        }
        //广度遍历要用到的队列
        Queue <String> queue = new LinkedList <String>();
        queue.add(builder.toString());
        set.add(builder.toString());
        //记录最小步骤
        int step = 0;
        while (!queue.isEmpty()) {
            //记录这一轮集合要遍历的元素,每轮遍历完就要step++
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //获取队首元素
                String s = queue.poll();
                //如果达到最终目的，则退出返回结果
                if (s.equals("123450")) {
                    return step;
                }
                int index = 0;
                //找到'0'对应的坐标
                for (; s.charAt(index) != '0'; index++) ;
                //找到'0'所有的邻居，挨个进行交换，把结果作为下一次要遍历的元素存入
                for (int j : neighbors[index]) {
                    char[] chas = s.toCharArray();
                    swap(chas, index, j);
                    String res = new String(chas);
                    //排除掉已经遍历过的元素
                    if (!set.contains(res)) {
                        queue.offer(res);
                        set.add(res);
                    }
                }
            }
            //一轮结束,step++
            step++;
        }
        //找不到路劲,退出
        return -1;
    }

    public void swap(char[] chas, int i, int j) {
        char tmp = chas[i];
        chas[i] = chas[j];
        chas[j] = tmp;
    }
}
