package Chapter4_递归和动态规划.Q17_N皇后问题;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/06/2020 10:51
 **/

public class NQueenProblem {
    public int getNumbers(int n){
        int[] record = new int[n];
        return process(record,n,0);
    }
    public int process(int[]record, int n, int i){
        //全部排列好了，说明这只是一种解法，返回1
        if(i == n){
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {

            if(isValid(record,i,j)){
                record[i] = j;
                res += process(record,n,i+1);
            }
        }
        return res;
    }
    public boolean isValid(int[] record, int i, int j){
        for (int k = 0; k < i; k++) {
            if(j == record[k] || Math.abs(i-k) == Math.abs(j-record[k])){
                return false;
            }
        }
        return true;
    }
    @Test
    void test(){
        Assertions.assertEquals(1,getNumbers(1));
        Assertions.assertEquals(0,getNumbers(2));
        Assertions.assertEquals(92,getNumbers(8));
    }
}
