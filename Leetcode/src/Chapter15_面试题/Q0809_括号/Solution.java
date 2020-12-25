package Chapter15_面试题.Q0809_括号;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/12/2020 22:58
 **/

public class Solution {
    List <String> res = new ArrayList <>();
    public List<String> generateParenthesis(int n) {
        StringBuilder builder = new StringBuilder();
        dfs(n,builder,0,0);
        return res;
    }
    public void dfs(int n, StringBuilder builder, int left, int right){
        //终止条件，所有左括号和右括号都用完啦
        if(right == n && left == n){
            res.add(builder.toString());
            return;
        }
        //确定生成的左括号数量
        if(left < n){
            builder.append('(');
            dfs(n,builder,left + 1,right);
            builder.deleteCharAt(builder.length()-1);
        }
        //这里尤其要注意不能right <= left,right == left时继续运行可能会出现)(这样的情况
        if(left > 0 && right < left) {
            builder.append(')');
            dfs(n,builder,left,right +1);
            builder.deleteCharAt(builder.length()-1);
        }
    }
}
