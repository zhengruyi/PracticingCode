package Chapter10_动态规划.Q1055_形成字符串的最短路劲;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/11/2020 21:33
 **/

public class Solution {
    public int shortestWay(String source, String target) {
        int res = 0;
        int i =0;
        //res表示最少需要的source子序列数目
        while(i < target.length()){
            ++res;
            //每次都需要更新目前匹配到的target字符串的哪个字符
            int t = update(source,target,i);
            //如果一次更新后i没变，表示target中包含source中没有的字符，所以直接返回-1表示不可能
            if(t == i){
                return -1;
            }
            //更新已匹配成功的索引
            i = t;
        }
        return res;
    }
    public int update(String source, String target, int i){
        int j = 0;
        while(i < target.length() && j < source.length()){
            //如果匹配成功，则更新target字符串的索引位置，不然的话增加j来指向source的下一个字符
            if(source.charAt(j) == target.charAt(i)){
                ++i;
            }
            ++j;
        }
        return i;
    }
}
