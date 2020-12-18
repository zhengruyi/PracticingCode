package Chapter0_其他.Q1111_有效括号的嵌套深度;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/12/2020 23:50
 **/

public class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        int[] res = new int[len];
        int count = 0;
        //把括号拆分成奇偶数，这样全局的嵌套深度最小
        for(int i = 0; i < len; i++){
            if(seq.charAt(i) == '('){
                count++;
                res[i] = count % 2;
            }else{
                res[i] = count % 2;
                count--;
            }
        }
        return res;
    }
}
