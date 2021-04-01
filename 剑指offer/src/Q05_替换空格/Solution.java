package Q05_替换空格;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 31/03/2021 15:09
 **/

public class Solution {
    public String replaceSpace(String s) {
        //进行大量的字符串的替换
        return s.replaceAll(" ","%20");
    }
}
