package Q28_字符串的全排列;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/12/2020 22:42
 **/

public class Solution {
    List <String> res  = new LinkedList <String>();
    char[] chars;
    public String[] permutation(String s){
        chars = s.toCharArray();
        recursive(0);
        //将list转化成数组
        return res.toArray(new String[res.size()]);
    }
    public void recursive(int x){
        //由于每次采用交换的方法，所以当前为n-1时只能自己和自己交换
        //没有意义，可以直接返回作为最终结果
        if(x == chars.length - 1){
            res.add(String.valueOf(chars));
            return;
        }
        //创建一个集合来过滤可能的重复的元素
        Set <Character> set = new HashSet <Character>();
        for(int i = x; i < chars.length;i++){
            //由于是通过交换，为了防止"aba"这种出现两次"aba"
            //采用集合来过滤相同的结果
            if(set.contains(chars[i])){
                continue;
            }
            //将元素添加到集合中
            set.add(chars[i]);
            //交换元素，前面的未利用的元素交换到后面，方便后续遍历
            swap(i,x);
            recursive(x+1);
            //恢复原位
            swap(i,x);
        }
    }
    public void swap(int i, int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
