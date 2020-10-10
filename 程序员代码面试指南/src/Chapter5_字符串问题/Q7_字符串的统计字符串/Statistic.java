package Chapter5_字符串问题.Q7_字符串的统计字符串;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/06/2020 20:42
 **/

public class Statistic {
    public String getStatistic(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        char[] chars = s.toCharArray();
        int times = 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                times++;
            } else {
                builder.append(chars[i] + "_" + times);
                if (i != chars.length - 1) {
                    builder.append('_');
                }
                times = 1;
            }
        }
        return builder.toString();
    }

    public char getIndexChar(String s, int index) {
        String statistic = getStatistic(s);
        boolean nextChar = true;
        char[] chars = statistic.toCharArray();
        char result = ' ';
        int sum = 0;
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '_') {
                nextChar = !nextChar;
            } else if (nextChar) {
                result = chars[i];
            } else {
                num = num*10 + chars[i] - '0';
                if(i == chars.length -1 || chars[i+1] == '_'){
                    if(sum + num >= index){
                        return result;
                    }
                    sum += num;
                    num = 0;
                }
            }
        }
        return  result;
    }

    @Test
    void test() {
        Assertions.assertEquals("a_3_b_2", getStatistic("aaabb"));
        Assertions.assertEquals("a_3_b_2_a_1_d_3_f_2_c_1", getStatistic("aaabbadddffc"));
    }

    @Test
    void test1(){
        Assertions.assertEquals('b', getIndexChar("aaabb",4));
        Assertions.assertEquals('a', getIndexChar("aaabb",2));
        Assertions.assertEquals('c', getIndexChar("aaabbc",6));
    }
}
