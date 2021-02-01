package Chapter0_其他.Q725_分隔链表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/02/2021 23:01
 **/

public class Solution {
    /**
     * 本质就是先求出链表的总长度,然后知道大概每个分段要安排几个元素,最后考虑余数
     * 如果余数有剩余就在每个分段分隔完毕后在后面在加上一个分段
     * 采用虚拟节点来避免头结点为空的情况
     * @param root
     * @param k
     * @return
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] heads = new ListNode[k];
        ListNode[] cur = new ListNode[k];
        for(int i = 0; i < k; i++){
            heads[i] = new ListNode(-1);
            cur[i] = heads[i];
        }
        int size = getSize(root);
        int mod = size % k;
        int subLength = size / k;
        for(int i = 0; i < k; i++){
            for(int j = 0; j < subLength; j++){
                ListNode tmp = root;
                root = root.next;
                tmp.next = null;
                cur[i].next = tmp;
                cur[i] = tmp;
            }
            if(mod > 0){
                ListNode tmp = root;
                root = root.next;
                tmp.next = null;
                cur[i].next = tmp;
                cur[i] = tmp;
                mod--;
            }
        }
        for(int i = 0; i < k; i++){
            heads[i] = heads[i].next;
        }
        return heads;
    }
    public int getSize(ListNode root){
        int size = 0;
        while(root != null){
            root = root.next;
            size++;
        }
        return size;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}