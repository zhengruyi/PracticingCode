package Chapter0_功能验证性代码.Q6_可能的二分法;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/07/2020 19:35
 **/

public class Solution {

    ArrayList <Integer>[] graph;// 使用邻接表存储图
    Map <Integer, Integer> color;//记录上色结果

    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList[N + 1];// 0位其实不用,使用的使1~N位
        //ArrayList实例化
        for (int i = 0; i != N + 1; i++) {
            graph[i] = new ArrayList <Integer>();
        }
        //图初始化
        for (int[] cp : dislikes) {
            graph[cp[0]].add(cp[1]);
            graph[cp[1]].add(cp[0]);
        }
        color = new HashMap();
        for (int node = 1; node != N + 1; node++) {// 对该组N人遍历
            if (!color.containsKey(node)) {// 还未上色
                boolean OK = dfs(node, 0);//从node开始深度遍历
                if (!OK) {
                    return false;
                }
            } else {
                continue;//已经上色
            }
        }
        return true;
    }

    private boolean dfs(int node, int c) {
        //从possibleBipartition调用时node是未上色的
        if (color.containsKey(node)) {// 若已经上色则看是否上色正确
            boolean OK = color.get(node) == c;
            return OK;
        }
        color.put(node, c);// 上色
        // 深度遍历
        for (int noFriend : graph[node]) {
            // c = 0 或者 1用来表示两种不同的颜色
            boolean OK = dfs(noFriend, c ^ 1);
            if (!OK) {
                return false;
            }
        }
        return true;
    }

    @Test
    void test() {
        int[][] dislikes = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        Assertions.assertFalse(possibleBipartition(5, dislikes));
    }

}
