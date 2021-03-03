package Chapter15_面试题.Q1620_T9键盘;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/03/2021 23:04
 **/

public class Solution {
    /**
     * 暴力映射
     * @param num
     * @param words
     * @return
     */
    public List<String> getValidT9Words(String num, String[] words) {
        int[] map = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
        List <String> res = new ArrayList();
        for(String word : words){
            if(num.length() != word.length()){
                continue;
            }
            for(int i = 0; i < num.length(); i++){
                int index = word.charAt(i) - 'a';
                if(map[index] != (num.charAt(i) - '0')){
                    break;
                }
                if(i == word.length() - 1){
                    res.add(word);
                }
            }
        }
        return res;
    }
}
