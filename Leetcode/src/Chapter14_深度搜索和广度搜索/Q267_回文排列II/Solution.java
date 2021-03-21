package Chapter14_深度搜索和广度搜索.Q267_回文排列II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/03/2021 23:39
 **/

public class Solution {
    public List <String> generatePalindromes(String s) {
        HashMap <Character,Integer> map = new HashMap();
        //统计字符的出现频率
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
        }
        //统计出现次数为奇数的字符个数
        int count = 0;
        //保存出现次数为奇数次的字符，它必须被放在中间
        Character mid = null;
        int size = 0;
        for(char key : map.keySet()){
            //统计奇数次出现的字符的个数,以及整个回文字符串出去中间字符
            //所剩下的字符串长度
            if(map.get(key) % 2 != 0){
                count++;
                mid = key;
                map.put(key, map.get(key) - 1);
            }
            size += map.get(key) / 2;
        }
        char[] chars = new char[size];
        if(count > 1){
            return new ArrayList();
        }
        int index = 0;
        //将总共出现的次数种类按照数目放入chars中，后续回溯挨个遍历，尝试可能性
        for(char key : map.keySet()){
            for(int j = 0; j < map.get(key) /2; j++){
                chars[index++] = key;
            }
        }
        //存放结果的列表
        List<String> res = new ArrayList();
        //表示这个位置是否被访问过
        boolean[] visited = new boolean[size];
        //回溯来访问所有的可能性
        dfs(chars,res,new StringBuilder(),mid,visited);
        return res;

    }
    public void dfs(char[] chars,List<String> res, StringBuilder sb, Character mid, boolean[] visited){
        //字符串一般已经组装完
        if(sb.length() == chars.length){
            StringBuilder tmp = new StringBuilder(sb.toString());
            //获得另外一半
            String reverse = new StringBuilder(sb.toString()).reverse().toString();
            //组装完整的回文串,如果中间字符不是null，就放入中间
            res.add(mid == null ? tmp.append(reverse).toString() : tmp.append(mid).append(reverse).toString());
            return;
        }
        //寻找下一个未被遍历的字符放入StringBuilder中
        for(int i = 0;i < chars.length; i++){
            if(visited[i]){
                continue;
            }else if(i > 0 && chars[i] == chars[i-1] && ! visited[i-1]){
                continue;
            }else{
                //作出决定
                sb.append(chars[i]);
                visited[i] = true;
                dfs(chars,res,sb,mid,visited);
                //撤销决定
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
