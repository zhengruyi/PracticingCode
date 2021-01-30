package Chapter0_其他.Q686_重复叠加字符串匹配;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/01/2021 21:20
 **/

public class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder builder = new StringBuilder();
        //当b的长度大于a的长度时，那么所需要的最多的a的数目是n+2
        //当 b = n*a时，需要 n，当头或尾一部分不匹配，那么需要n+1
        //当 b的头尾都不匹配时需要n + 2
        int max = b.length() + a.length() * 2;
        for(int count = 0; builder.length() < max; builder.append(a),count++){
            if(builder.toString().contains(b)){
                return count;
            }
        }
        return -1;
    }
}
