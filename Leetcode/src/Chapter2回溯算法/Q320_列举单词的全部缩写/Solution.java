package Chapter2回溯算法.Q320_列举单词的全部缩写;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/02/2021 23:18
 **/

public class Solution {
    public List <String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList <>();
        //回溯遍历所有的可行性
        backTrack(word,ans,new StringBuilder(),0,0);
        return ans;
    }
    public void backTrack(String word,List<String> ans, StringBuilder builder, int i, int k){
        //记录初始的builder状态,因为遍历后需要恢复原始状态才能返回上一层
        int len = builder.length();

        if(i == word.length()){
            //到达终点如果k !=0 说明前面存在缩写
            if(k != 0){
                builder.append(k);
            }
            //加入答案
            ans.add(builder.toString());
        }else{
            //两个选择，要么当前位置计入缩写中
            backTrack(word,ans,builder,i+1,k+1);
            //当前字符不计入缩写，所以考察前面是否有缩写
            if(k != 0){
                builder.append(k);
            }
            //把当前字符放入builder，清空k
            builder.append(word.charAt(i));
            backTrack(word,ans,builder,i+1,0);
        }
        //恢复初始状态，返回上一层
        builder.setLength(len);
    }
}
