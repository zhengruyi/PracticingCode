package Chapter0_其他.Q1233_删除子文件夹;

import java.util.*;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/12/2020 22:33
 **/

public class Solution {
    public List <String> removeSubfolders(String[] folder) {
        //先按照字符串长度排序,保证父文件夹在子文件夹前加入集合,从而被过滤
        Arrays.sort(folder,(o1, o2) -> o1.length() - o2.length());
        TreeSet <String> set = new TreeSet<String>((o1, o2) -> {
            //这里o2指的是集合中的元素，o1指的是要添加的元素
            //加斜杠是因为为了避免把/a/c判断成/a/ca的父文件夹
            if(o1.contains(o2+'/')){
                return 0;
            }
            //按照字符串大小排序
            return o1.compareTo(o2);
        });
        //生成结果
        for(String s : folder){
            set.add(s);
        }
        Collections.addAll(set);
        return new ArrayList <>(set);
    }
}
