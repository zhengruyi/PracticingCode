package Chapter0_其他.Q89_格雷码;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/01/2021 21:23
 **/

public class Solution {
    /**
     * 具体解释: https://leetcode-cn.com/problems/gray-code/solution/gray-code-jing-xiang-fan-she-fa-by-jyd/
     * 总的来说需要下一层的格雷码是倒序遍历这层格雷码，然后在每个数字顶头加上1
     * @param n
     * @return
     */
    public List <Integer> grayCode(int n) {
        int head = 1;
        List<Integer> res = new ArrayList(){{add(0);}};
        for(int i = 0; i < n; i++){
            //倒序遍历，格雷码就是相邻编码方式只差一位不同
            for(int j = res.size() - 1; j >= 0; j--){
                res.add(head + res.get(j));
            }
            //进位头部
            head <<= 1;
        }
        return res;
    }
}
