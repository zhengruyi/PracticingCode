package Chapter5_滑动窗口算法.Q187_重复DNA序列;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/12/2020 23:53
 **/

public class Solution {
    public List <String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList <>();
        if(s.length() < 10){
            return res;
        }
        char[] map = new char[26];
        //将'A','C','G''T'分别对应到0..3
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        //用来保证出现次数超过两次
        Set <Integer> set = new HashSet <>();
        //用来保证字符串序列只在结果中出现一次
        Set<Integer> tmp = new HashSet<>();
        //滑动窗口
        int window = 0;
        //预先填入9个字符，之后每次左边删除一个，右边添加一个
        for(int i = 0; i < 9; i++){
            window <<= 2;
            window |= map[s.charAt(i) - 'A'];
        }
        //从第10个字符开始运行这个函数
        for(int i = 9; i < s.length(); i++){
            //清除掉高位数字
            window <<= 2;
            //将低位数字添加进去
            window |= map[s.charAt(i) - 'A'];
            //只取后20位
            window &= 0xfffff;
            if(set.contains(window)){
                if(!tmp.contains(window)){
                    String ss = s.substring(i-9,i+1);
                    res.add(ss);
                    tmp.add(window);
                }

            }
            set.add(window);
        }
        return res;
    }
}
