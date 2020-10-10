package Chapter3_二叉树问题.Q19_Tarjan算法与并查集解决二叉树节点间最近公共祖先的批量查询问题;

import Chapter3_二叉树问题.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.zip.ZipInputStream;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/06/2020 19:40
 **/

public class TarjanAlgorithm {
    /**
     * 太难了!!!
     * @param head
     * @param queries
     * @return
     */
    public Tree[] tarJanQuery(Tree head, Query[] queries){
        Tree[] ans = new Tarjan().query(head,queries);
        return ans;
    }
}
class Tarjan{
    private HashMap<Tree, LinkedList<Tree>> queryMap;
    private HashMap<Tree, LinkedList<Integer>> indexMap;
    private HashMap<Tree, Tree> ancestorMap;
    private DisjointSets sets;
    public Tarjan(){
        queryMap = new HashMap <>();
        indexMap = new HashMap <>();
        sets = new DisjointSets();
        ancestorMap = new HashMap <>();
    }
    public Tree[] query(Tree head, Query[] ques){
        Tree[] ans = new Tree[ques.length];
        setQueries(ques,ans);
        sets.makeSets(head);
        setAnswers(head,ans);
        return ans;
    }

    private void setQueries(Query[] ques, Tree[] ans){
        Tree o1 = null;
        Tree o2 = null;
        for (int i = 0; i < ans.length; i++) {
            o1 = ques[i].o1;
            o2 = ques[i].o2;
            if(o1 == o2 || o1 == null || o2 == null){
                ans[i] = o1 != null ? o1 : o2;
            }else{
                if(!queryMap.containsKey(o1)){
                    queryMap.put(o1,new LinkedList <Tree>());
                    indexMap.put(o1,new LinkedList <Integer>());
                }
                if(!queryMap.containsKey(o2)){
                    queryMap.put(o2,new LinkedList <Tree>());
                    indexMap.put(o2,new LinkedList <Integer>());
                }
                queryMap.get(o1).add(o2);
                indexMap.get(o1).add(i);
                queryMap.get(o2).add(o1);
                indexMap.get(o2).add(i);
            }
        }
    }
    private void setAnswers(Tree head, Tree[] ans){
        if(head == null){
            return;
        }
        setAnswers(head.left,ans);
        sets.union(head.left,head);
        ancestorMap.put(sets.findFather(head),head);
        setAnswers(head.right,ans);
        sets.union(head.right,head);
        ancestorMap.put(sets.findFather(head),head);
        LinkedList<Tree> nList = queryMap.get(head);
        LinkedList<Integer> iList = indexMap.get(head);
        Tree node = null;
        Tree nodeFather = null;
        int index = 0;
        while (nList != null && !nList.isEmpty()){
            node = nList.poll();
            index = iList.poll();
            nodeFather = sets.findFather(node);
            if(ancestorMap.containsKey(nodeFather)){
                ans[index] = ancestorMap.get(nodeFather);
            }
        }
    }

}
