package Q7_括号匹配深度;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/05/2020 15:15
 **/

public class GetBracketsDeep {
    public int getBracketsDeep(String s){
        int count = 0;
        int max = 0;
        char[] brackets = s.toCharArray();
        for (int i = 0; i < brackets.length; i++) {
            if(brackets[i] == '(')
                count += 1;
            else if( brackets[i] == ')')
                count -= 1;

            max = Math.max(max, count);
        }
        return max;
    }

    @Test
    void test(){
        Assertions.assertEquals(2,getBracketsDeep("(())"));
        Assertions.assertEquals(3,getBracketsDeep("((()))()"));
    }
}
