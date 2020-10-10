package Chapter3_二叉树问题.Q19_Tarjan算法与并查集解决二叉树节点间最近公共祖先的批量查询问题;

import Chapter3_二叉树问题.Tree;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/06/2020 13:39
 **/

public class DisjointSets {
    public HashMap<Tree,Tree> fatherMap;
    public HashMap<Tree,Integer> rankMap;
    public DisjointSets(){
        fatherMap = new HashMap <>();
        rankMap = new HashMap <>();
    }

    public void makeSets(Tree head){
        fatherMap.clear();
        rankMap.clear();
        preOrderMake(head);
    }

    private void preOrderMake(Tree head){
        if(head == null){
            return;
        }
        fatherMap.put(head,head);
        rankMap.put(head,0);
        preOrderMake(head.left);
        preOrderMake(head.right);
    }
    public Tree findFather(Tree head){
        Tree father = fatherMap.get(head);
        //如果节点的代表节点不是自身，则迭代找到最上层节点的代表结点
        // 并对沿途所有的节点的代表结点进行重新设置
        if(father != head){
            father = findFather(father);
        }
        fatherMap.put(head,father);
        return father;
    }

    public void union(Tree a, Tree b){
        if(a == null || b == null){
            return;
        }
        Tree aFather = findFather(a);
        Tree bFather = findFather(b);
        if(aFather != bFather){
            int aRank =rankMap.get(aFather);
            int bRank = rankMap.get(bFather);
            if(aRank < bRank){
                fatherMap.put(aFather,bFather);
            }else if(aRank > bRank){
                fatherMap.put(bFather,aFather);
            }else{
                fatherMap.put(bFather,aFather);
                rankMap.put(aFather,aRank + 1);
            }
        }
    }
}
