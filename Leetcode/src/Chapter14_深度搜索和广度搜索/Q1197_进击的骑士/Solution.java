package Chapter14_深度搜索和广度搜索.Q1197_进击的骑士;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/02/2021 23:21
 **/

public class Solution {
    int[][] dirs = new int[][]{
            {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}
    };

    public int minKnightMoves(int x, int y) {
        int dist = 0;
        int abs = getMhdDist(0, 0, x, y);   // (0,0)到(x,y)的距离（横坐标之差加纵坐标之差）
        // 目标最远不超过 |x| + |y| <= 300
        // 666 表示把 [-333, 333] 映射为 [0, 666]
        boolean[][] mark = new boolean[666][666];   // 用于标记已走过的位置
        Queue <Node> queue = new LinkedList <>();
        Node curNode = new Node(0, 0, 0);   // 起点，已走步数为 0
        Node newNode = null;
        mark[333][333] = true;  // 映射后的 (0,0)坐标
        queue.add(curNode);
        while (!queue.isEmpty()) {
            curNode = queue.remove();
            int curX = curNode.x;
            int curY = curNode.y;
            int curDist = curNode.dist; // 从 (0,0) 到 (curX,curY) 的已走步数
            if (curX == x && curY == y) {
                // 当前点已在终点，返回已走步数
                return curDist;
            }
            int mhdist = getMhdDist(curX, curY, x, y);  // 剩余距离
            for (int[] dir : dirs) {    // 往八个方向走
                int newX = curX + dir[0];
                int newY = curY + dir[1];
                int nextDist = curDist + 1; // 新的步数等于已走步数加一
                if (mark[newX + 333][newY + 333]) {
                    continue;
                }
                // 下一步走的方向一定是往目的地靠近
                // 即 getMhdDist(newX, newY, x, y) < (curX, curY, x, y)
                // 而不是八个方向都走一遍
                //这里如果八个方向都试一次会超时，所以只选择更接近目标的方向前进
                //abs小于4是因为马每走一个的最小的坐标绝对值差是3，但如果坐标值是
                //(0,1)那么会直接跳出，所以增加了这么一个条件
                if (mhdist > getMhdDist(newX, newY, x, y)|| abs < 4) {
                    newNode = new Node(newX, newY, nextDist);
                    queue.add(newNode);
                    mark[newX + 333][newY + 333] = true;
                }
            }
        }
        return -1;
    }

    private int getMhdDist(int i, int j, int x, int y) {
        return Math.abs(i - x) + Math.abs(j - y);
    }

    class Node {
        int x;
        int y;
        public int dist;    // (0,0)走到(x,y)的最少移动次数

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
