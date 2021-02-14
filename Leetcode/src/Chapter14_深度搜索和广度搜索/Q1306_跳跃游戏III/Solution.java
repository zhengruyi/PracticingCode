package Chapter14_深度搜索和广度搜索.Q1306_跳跃游戏III;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/02/2021 23:25
 **/

public class Solution {
    /**
     * 一种深度搜索的变体,因为知道起始位置,那么下一个搜索位置就是确定的，搜索直到
     * 找到0元素，或者整个数组都已经搜索过了。
     * @param arr
     * @param start
     * @return
     */
    public boolean canReach(int[] arr, int start) {
        int len = arr.length;
        boolean[] visited = new boolean[len];
        return dfs(arr,visited,start);
    }
    public boolean dfs(int[] arr, boolean[] visited,int start){
        visited[start] = true;
        if(arr[start] == 0){
            return true;
        }
        boolean left = false;
        //检查左边的点是否有效，是否搜索过了
        if(start - arr[start] >= 0 && !visited[start - arr[start]]){
            left = dfs(arr,visited,start - arr[start]);
        }
        boolean right = false;
        //检查右边的点是否有效，是否搜索过了
        if(start + arr[start] < arr.length && !visited[start + arr[start]]){
            right = dfs(arr,visited,start + arr[start]);
        }
        //左右点中只要有一个满足条件就可以了
        return left || right;
    }
}
