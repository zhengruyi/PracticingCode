package Chapter0_其他.Q148_排序链表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/12/2020 22:05
 **/

public class Solution {
    /**
     * 要达到 o(nlogn)的时间复杂度和O(1)d的空间复杂度，需要采用迭代的归并排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        //虚拟节点，用来每次定位头结点
        ListNode res = new ListNode(Integer.MIN_VALUE,head);
        //获取链表总长度
        int length = getLength(head);
        //归并排序，每次合并的有序链表长度是上次的两倍
        for(int inv = 1; inv < length; inv *= 2){
            //链接链表的节点
            ListNode prev = res;
            ListNode h = res.next;
            while(h!= null){
                ListNode h1 = h,h2 = null;
                //分割链表到制定长度，如果不满足长度，则直接跳出进行下一次合并
                int i = inv;
                while(h!= null && i > 0){
                    h = h.next;
                    i--;
                }
                if(i!= 0){
                    break;
                }
                //由于h1的链表已经分割，对于h2,不要求一定要分割指定长度
                h2 = h;
                i = inv;
                while(h!= null && i > 0){
                    h = h.next;
                    i--;
                }
                //分别计算链表的长度
                int c1 = inv;
                int c2 = inv - i;
                //合并两个有序链表
                while( c1 > 0 && c2 > 0){
                    if(h1.val < h2.val){
                        prev.next = h1;
                        c1--;
                        h1 = h1.next;
                    }else{
                        prev.next = h2;
                        c2--;
                        h2 = h2.next;
                    }
                    prev = prev.next;
                }
                //把两个链表的为连接的部分连接上
                prev.next = c1 > 0 ? h1 : h2;
                //移动prev的位置到已排序的位置
                while(c1-- > 0 || c2-- > 0){
                    prev = prev.next;
                }
                prev.next = h;
            }
        }
        return res.next;
    }
    public int getLength(ListNode head){
        int res = 0;
        while(head != null){
            res++;
            head = head.next;
        }
        return res;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
