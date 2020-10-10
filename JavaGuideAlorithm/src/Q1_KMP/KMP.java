package Q1_KMP;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/05/2020 19:42
 **/
/*
时间复杂度: O(m+n), m是子串长度，n是父串长度
空间复杂度：O(m),需要一定空间来计算部分匹配长度
 */
public class KMP {
    public int findSubStringWithKMP(String parent, String sub) {
        if (parent == null || sub == null || parent.length() == 0 || sub.length() == 0)
            return -1;
        char[] origin = parent.toCharArray();
        char[] target = sub.toCharArray();
        return find(origin, target);
    }

    public int find(char[] origin, char[] target) {
        int index = -1;
        int i = 0;
        end:
        while (i < origin.length) {
            int sameChar = 0;
            for (int j = 0; j <= target.length; j++) {
                //子字符串已经全部找到
                if (j == target.length) {
                    index = i;
                    break end;
                }
                if (origin[i + j] != target[j]) {
                    //根据公式 移动为数 = 已经匹配的字符数 - 对应的部分匹配值
                    int gap = sameChar - getCommonPrefix(target, sameChar);
                    if (gap > 0)
                        i += gap;
                    else
                        i++;
                    break;
                } else {
                    sameChar++;
                }
            }
        }
        return index;
    }
    //计算已经匹配的部分子字符串的最大公共前后缀长度
    public int getCommonPrefix(char[] target, int sameChar) {
        if (sameChar == 1)
            return 0;
        HashSet <String> frontPrefix = new HashSet <String>();
        HashSet <String> backPrefix = new HashSet <String>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sameChar - 1; i++) {
            builder.append(target[i]);
            frontPrefix.add(builder.toString());
        }
        builder.delete(0, sameChar);
        for (int i = sameChar - 1; i > 0; i--) {
            builder.append(target[i]);
            backPrefix.add(builder.reverse().toString());
            builder.reverse();
        }
        frontPrefix.retainAll(backPrefix);

        //在并集中找出最大的公共长度
        if (frontPrefix.size() == 0)
            return 0;
        else {
            int max = 0;
            Iterator <String> it = frontPrefix.iterator();
            while (it.hasNext()) {
                String s = it.next();
                if (s.length() > max)
                    max = s.length();
            }
            return max;
        }

    }

    @Test
    void test() {
        //测试前后缀最大长度部分
        Assertions.assertEquals(2, getCommonPrefix("ABCDAB".toCharArray(), 6));
        Assertions.assertEquals(0, getCommonPrefix("ABCDABD".toCharArray(), 7));
        Assertions.assertEquals(1, getCommonPrefix("ABCDA".toCharArray(), 5));

        //完整测试
        Assertions.assertEquals(2, findSubStringWithKMP("ABCBA", "CBA"));
        Assertions.assertEquals(15, findSubStringWithKMP("BBC ABCDAB ABCDABCDABDE", "ABCDABD"));
    }
}
