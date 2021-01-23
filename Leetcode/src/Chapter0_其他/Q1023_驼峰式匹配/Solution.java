package Chapter0_其他.Q1023_驼峰式匹配;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/01/2021 20:59
 **/

public class Solution {
    /**
     * 本质想法就是讲query中所偶遇在Pattern中的字符删去，然后剩下的字符中都是小写字母
     * 那么就符合要求
     * @param queries
     * @param pattern
     * @return
     */
    public List <Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList <>();
        for(String query : queries){
            String s = deletePattern(query,pattern);
            if(s.equals("")){
                res.add(false);
            }else{
                //判断所有字符是否是小写字母
                res.add(s.toLowerCase().equals(s));
            }
        }
        return res;
    }

    /**
     * 这里的功能就是将query中的所有在pattern出现的字符删去
     * @param query
     * @param pattern
     * @return
     */
    public String deletePattern(String query, String pattern){
        //这里是为了将query和pattern相等的情况与两者不匹配的情况区分开
        StringBuilder builder = new StringBuilder("a");
        int index = 0;
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            //indexOf()函数第一个参数是要寻找的字符串,第二个是偏移量
            //即从什么地方开始寻找
            int index2 = query.indexOf(c,index);
            //如果不存在就直接返回空字符串
            if(index2 < 0){
                return "";
            }
            //将两者之间的字符压入
            builder.append(query,index,index2);
            //更新index在query中的位置
            index = index2 + 1;
        }
        //将末尾的字符压入
        builder.append(query.substring(index));
        return builder.toString();
    }
}
