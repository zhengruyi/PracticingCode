package Chapter0_其他.Q1366_通过投票对团队排名;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/02/2021 19:01
 **/

public class Solution {
    public String rankTeams(String[] votes) {
        int len = votes[0].length();
        int[][] count = new int[26][len];
        //统计对于每一个投票，每个人对应的投票位置
        for(String vote : votes){
            for(int i = 0; i < vote.length(); i++){
                int c = vote.charAt(i) - 'A';
                count[c][i]++;
            }
        }
        Pair[] pairs = new Pair[26];
        //根据投票结果和位置构建对象
        for(int i = 0; i < count.length; i++){
            pairs[i] = new Pair(count[i],i);
        }
        //构建排序规则
        Arrays.sort(pairs, new Comparator <Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                for(int i = 0; i < p1.count.length; i++){
                    if(p1.count[i] != p2.count[i]){
                        return p2.count[i] - p1.count[i];
                    }
                }
                return p1.index - p2.index;
            }
        });
        //获取排序后的结果，组合出答案
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < len; i++){
            builder.append((char)('A' + pairs[i].index));
        }
        return builder.toString();
    }
}
class Pair{
    //count数组便是在各个位置的投票的次数
    public int[] count;
    //表示是第几个字符
    public int index;
    public Pair(int[] count, int index){
        this.index = index;
        this.count = count;
    }
}