package Chapter5_字符串问题.Q18_找到被指的新类型字符;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/06/2020 21:11
 **/

public class NewCharacter {
    public String get(String s, int k) {
        if (s == null || s.length() == 0 || k > s.length()) {
            return null;
        }
        char[] chas = s.toCharArray();
        int num = 0;
        for (int i = k - 1; i >= 0; i--) {
            if (chas[i] >= 'a' && chas[i] <= 'z') {
                break;
            } else if (chas[i] >= 'A' && chas[i] <= 'Z') {
                num++;
            }
        }
        if (num % 2 == 1) {
            return s.substring(k - 1, k + 1);
        } else {
            if(chas[k] >= 'A' && chas[k] <= 'Z'){
                return s.substring(k,k+2);
            }else{
                return s.substring(k,k+1);
            }
        }
    }
    @Test
    void test(){
        Assertions.assertEquals("Ec",get("aaABCDEcBCg",7));
        Assertions.assertEquals("CD",get("aaABCDEcBCg",4));
        Assertions.assertEquals("g",get("aaABCDEcBCg",10));
    }
}
