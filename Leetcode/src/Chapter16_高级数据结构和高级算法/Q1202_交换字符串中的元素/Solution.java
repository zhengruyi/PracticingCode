package Chapter16_高级数据结构和高级算法.Q1202_交换字符串中的元素;

import java.util.*;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/02/2021 23:35
 **/

public class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();
        UnionSet  us = new UnionSet(len);
        //用并查集来保存节点间的连通关系
        for(List <Integer> list : pairs){
            us.merge(list.get(0),list.get(1));
        }
        HashMap <Integer,List<Character>> map = new HashMap<>();
        for(int i =0; i < len; i++){
            //找出这个节点的父节点，把当前节点的字符归类到父节点中
            int parent = us.find(i);
            if(!map.containsKey(parent)){
                map.put(parent,new ArrayList <Character>());
            }
            map.get(parent).add(s.charAt(i));
        }
        for(int key : map.keySet()){
            //对可以相互交换的字符进行排序,从大到小，因为每次都需要移除一个元素
            Collections.sort(map.get(key),new Comparator <Character>(){
                @Override
                public int compare(Character c1, Character c2){
                    return c2 - c1;
                }
            });
        }
        //构造答案
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < len; i++){
            int parent = us.find(i);
            List<Character> list = map.get(parent);
            builder.append(list.remove(list.size() - 1));
        }
        return builder.toString();
    }
}

/**
 * 并查集用来记录节点之间的连通关系
 */
class UnionSet{
    int n;
    int[] rank;
    int[] parent;

    public UnionSet(int n){
        rank = new int[n];
        parent = new int[n];
        for(int i = 0; i < n; i++){
            rank[i] = 1;
            parent[i] = i;
        }
    }

    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void merge(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        if(parentX != parentY){
            if(rank[parentX] < rank[parentY]){
                int tmp = parentY;
                parentY = parentX;
                parentX = tmp;
            }
            parent[parentX] = parentY;
            if(parentX == parentY){
                rank[parentX] += 1;
            }
        }
    }
}