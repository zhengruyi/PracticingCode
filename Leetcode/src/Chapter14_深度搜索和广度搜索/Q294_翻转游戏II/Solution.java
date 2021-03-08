package Chapter14_深度搜索和广度搜索.Q294_翻转游戏II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/03/2021 22:55
 **/

public class Solution {
    public boolean canWin(String s) {
        if(s.length() < 2){
            return false;
        }
        return Win(s);
    }
    public boolean Win(String s){
        char[] chas = s.toCharArray();
        for(int i = 1; i < chas.length; i++){
            if(chas[i-1] == '+' && chas[i] == '+'){
                chas[i] = '-';
                chas[i-1] = '-';
                //如果后续情况下对手所偶遇情况都必输，那么就返回true表示必胜
                //这里用String来避免后续数组对当前结果产生影响
                if(!Win(new String(chas))){
                    return true;
                }
                chas[i] = '+';
                chas[i-1] = '+';
            }
        }
        return false;
    }
}
