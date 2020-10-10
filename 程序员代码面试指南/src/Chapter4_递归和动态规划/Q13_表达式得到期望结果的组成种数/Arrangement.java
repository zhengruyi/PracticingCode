package Chapter4_递归和动态规划.Q13_表达式得到期望结果的组成种数;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/06/2020 20:19
 **/

public class Arrangement {
    /**
     * 太难了
     * @param express
     * @param desired
     * @return
     */
    public int getNumberOfArrangement(String express, boolean desired) {
        if (express == null || express.equals("")) {
            return 0;
        }
        char[] exp = express.toCharArray();
        if (!isValid(exp)) {
            return 0;
        }
        int[][] t = new int[exp.length][exp.length];
        int[][] f = new int[exp.length][exp.length];
        t[0][0] = exp[0] == '0' ? 0 : 1;
        f[0][0] = exp[0] == '1' ? 0 : 1;
        for (int i = 2; i < exp.length; i += 2) {
            t[i][i] = exp[i] == '0' ? 0 : 1;
            f[i][i] = exp[i] == '1' ? 0 : 1;
            for (int j = i-2; j >= 0 ; j -= 2) {
                for (int k = j; k < i; k+= 2) {
                    if(exp[k+1] == '&'){
                        t[j][i] += t[j][k] * t[k+2][i];
                        f[j][i] += (f[j][k] + t[j][k] * f[k+2][i] + f[j][k] *t[k+2][i]);
                    }else if(exp[k+1] == '|'){
                        t[j][i] += (f[j][k] + t[j][k]) * t[k+2][i] + t[j][k] * f[k+2][i];
                        f[j][i] += f[j][k] * f[k+2][i];
                    }else{
                        t[j][i] += f[j][k] * t[k+2][i] + t[j][k] * f[k+2][i];
                        f[j][i] += f[j][k] * f[k+2][i] + t[j][k] * t[k+2][i];
                    }
                }
            }
        }
        return desired ? t[0][t.length-1] : f[0][f.length-1];
    }
    public boolean isValid(char[] exp){
        if((exp.length &1) == 0){
            return false;
        }
        for (int i = 0; i < exp.length; i+= 2) {
            if((exp[i] != '1') &&(exp[i] != '0')){
                return false;
            }
        }
        for (int i = 1; i < exp.length; i+= 2) {
            if((exp[i] != '&') && (exp[i] != '|') && (exp[i] != '^')){
                return false;
            }
        }
        return true;
    }
    @Test
    void test(){
        Assertions.assertEquals(2,getNumberOfArrangement("1^0|0|1",false));
        Assertions.assertEquals(0,getNumberOfArrangement("1",false));
    }
}
