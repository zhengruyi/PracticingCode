package Chapter0_其他.Q997_找到小镇的法官;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/12/2020 23:25
 **/

public class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] inDegree = new int[N+1];
        int[] outDegree = new int[N+1];
        //根据题目意思就是图的入度为N-1,而出度为0
        for(int i = 0; i < trust.length; i++){
            outDegree[trust[i][0]]++;
            inDegree[trust[i][1]]++;
        }
        for(int i = 1; i <= N; i++){
            if(inDegree[i] == N-1 && outDegree[i] == 0){
                return i;
            }
        }
        return -1;
    }
}
