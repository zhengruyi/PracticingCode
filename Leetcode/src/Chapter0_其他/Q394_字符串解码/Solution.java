package Chapter0_其他.Q394_字符串解码;

import java.util.LinkedList;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/12/2020 18:01
 **/

public class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        LinkedList <Integer> stackMulti = new LinkedList<Integer>();
        LinkedList<String> stackRes = new LinkedList<String>();
        int multi = 0;
        for(char c : s.toCharArray()){
            if(c == '['){
                //进行压栈操作，如果结构向3[2[a]]，那么res = ""
                stackMulti.addLast(multi);
                stackRes.addLast(res.toString());
                multi = 0;
                //清空res
                res = new StringBuilder();
            }else if(c == ']'){
                StringBuilder tmp = new StringBuilder();
                //获取已经压栈的重复次数
                int currMulti = stackMulti.removeLast();
                //计算最后组成的字符串
                for(int i =0; i < currMulti; i++){
                    tmp.append(res);
                }
                //合并生成当前的结果
                res = new StringBuilder(stackRes.removeLast()+tmp);
            }else if(c >= '0' && c <= '9'){
                multi = multi * 10 + c - '0';
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
