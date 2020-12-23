package Chapter0_其他.Q166_分数到小数;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/12/2020 20:20
 **/

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        //后续计算都用绝对值计算
        long num = Math.abs(Long.valueOf(numerator));
        long den = Math.abs(Long.valueOf(denominator));
        //新知识点，布尔值也可以用异或运算来处理两个中只有一个为负数的情况
        if(numerator < 0 ^ denominator < 0){
            builder.append("-");
        }
        //计算整数部分
        builder.append(num/den);
        //计算余数
        long remainder = num % den;
        //如果余数为0，则直接返回
        if(remainder == 0){
            return builder.toString();
        }
        //添加小数点来准备计算余数部分
        builder.append(".");
        //保存计算出来的余数，因为都是整数相除
        // 所以结果要么有限但如果小数部分重复要么是有限长度的
        Map <Long,Integer> map = new HashMap <>();
        //利用长除法来计算小数
        while(remainder != 0){
            //发现是循环小数则在对应位置插入括号
            if(map.containsKey(remainder)){
                builder.insert(map.get(remainder),"(");
                builder.append(")");
                break;
            }
            //保存计算出来的小数和在数组中的位置
            map.put(remainder,builder.length());
            remainder *= 10;
            builder.append(remainder /den);
            //更新余数
            remainder = remainder % den;
        }
        return builder.toString();
    }
}
