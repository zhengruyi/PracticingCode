package Chapter15_面试题.Q0807_无重复字符串的排列组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/12/2020 23:02
 **/

public class Solution {
    char[] chas;
    List <String> list;
    public String[] permutation(String s) {
        chas = s.toCharArray();
        list = new ArrayList <String>();
        recursive(0);
        return list.toArray(new String[list.size()]);
    }
    public void recursive(int x){
        if(x == chas.length - 1){
            list.add(new String(chas));
            return;
        }
        for(int i = x; i < chas.length; i++){
            swap(i,x);
            recursive(x+1);
            swap(i,x);
        }
    }
    public void swap(int i, int j){
        char tmp = chas[i];
        chas[i] = chas[j];
        chas[j] = tmp;
    }
}
