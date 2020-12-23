package Chapter0_其他.Q470_用rand7来实现rand10;

import java.util.Random;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/12/2020 20:41
 **/

public class Solution {
    public int rand10() {
        int idx = 0;
        do{
            //连续调用两次随机函数，两次生成的结果总共可能有49种
            //取其中40中转换成1到10的随机数
            int row = rand7();
            int col = rand7();
            idx = (row-1) * 7 + col;
        }while(idx > 40);
        //防止将40对10取余后变成0,这里用采用先减去1再加上的技巧
        return 1 + (idx-1)%10;
    }
    public int rand7(){
        return new Random().nextInt(7);
    }
}
