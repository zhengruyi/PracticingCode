package Q4_替换空格;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/04/2020 23:03
 **/
//解决问题的关键是考虑从后往前替换字符来解决数组插值引起的拷贝问题
public class ReplaceSpace {
    public static String replace(String origin) {
        if (origin == null)
            return null;
        char[] old = origin.toCharArray();
        int num_space = 0;
        for (int i = 0; i < old.length; i++) {
            if (old[i] == ' ')
                num_space++;
        }
        char[] result = new char[old.length + num_space * 2];
        int p1 = old.length - 1;
        int p2 = result.length - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (old[p1] != ' ') {
                result[p2] = old[p1];
                p2--;
                p1--;
            } else {
                p1--;
                result[p2--] = '0';
                result[p2--] = '2';
                result[p2--] = '%';
            }
        }
        return new String(result);
    }

    @Test
    void test() {
        Assertions.assertEquals("We%20are%20happy", replace("We are happy"));
        Assertions.assertEquals("%20are%20happy", replace(" are happy"));
        Assertions.assertEquals("We%20are%20happy%20", replace("We are happy "));
        Assertions.assertEquals("Wearehappy", replace("Wearehappy"));
        Assertions.assertEquals("%20", replace(" "));
        Assertions.assertEquals("%20%20", replace("  "));
        Assertions.assertNull(replace(null));
        Assertions.assertEquals("", replace(""));
    }
}
