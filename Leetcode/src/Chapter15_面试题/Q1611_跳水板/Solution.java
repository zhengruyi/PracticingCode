package Chapter15_面试题.Q1611_跳水板;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/02/2021 23:25
 **/

public class Solution {
    /**
     * 总共有三种情况, k== 0返回空字符
     * longer == shorter，那么总控只有一种可能
     * 不然总长度等于 k* shorter  + (k - i ) * longer i = 0..k
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k == 0){
            return new int[]{};
        }
        if(shorter == longer){
            return new int[]{k * shorter};
        }
        List <Integer> tmp = new ArrayList();
        for(int i = 0; i <= k; i++){
            tmp.add(i * longer + (k-i) * shorter);
        }
        int[] res = new int[tmp.size()];
        for(int i = 0; i < tmp.size(); i++){
            res[i] = tmp.get(i);
        }
        return res;
    }
}
