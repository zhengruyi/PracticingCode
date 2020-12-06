package Chapter2回溯算法.Q93_复原IP地址;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/12/2020 15:38
 **/

public class Solution {
    public List <String> restoreIpAddresses(String s) {
        LinkedList <String> path = new LinkedList<String>();
        LinkedList<String> res = new LinkedList<String>();
        dfs(s,s.length(),0,0,path,res);
        return res;
    }
    public void dfs(String s, int len, int splitTimes, int begin, LinkedList<String> path, LinkedList<String> res){
        if(begin == len){
            if(splitTimes == 4){
                //拼装处字符串返回回去
                res.add(String.join(".",path));
            }
        }
        //剩余字符串不足以拼出ip地址或者剩余地址太长
        if((len - begin) < 4 - splitTimes || (len - begin) > 3 * (4 - splitTimes)){
            return;
        }
        for(int i = 0; i < 3; i++){
            //越界直接返回
            if(begin + i >= len){
                break;
            }
            //检查地址是否符合规格
            int ipSegment = judgeIfSegment(s,begin,begin+i);
            if(ipSegment != -1){
                //做出决定
                path.addLast(ipSegment+"");
                //递归计算
                dfs(s,len,splitTimes+1,begin+i+1,path,res);
                //撤销决定
                path.removeLast();
            }
        }
    }
    public int  judgeIfSegment(String s, int left, int right){
        int len = right - left + 1;
        //如归字符串长度大于1且开头是以0开头的，那么直接返回
        if( len > 1 && s.charAt(left) == '0'){
            return -1;
        }
        int res = 0;
        //把字符串转化成数字
        for(int i = left; i <= right; i++){
            res = res * 10 + s.charAt(i) - '0';
        }
        //如果数字大于255，则格式不符合要求
        if(res > 255){
            return -1;
        }
        return res;
    }
}
