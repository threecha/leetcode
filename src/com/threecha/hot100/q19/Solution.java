package com.threecha.hot100.q19;

/***
 * 删除链表的倒数第n个节点
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hd = head;
        int i = 0;
        ListNode ld = head;
        int length = 0;
        while (ld.next!=null){
            ld = ld.next;
            length++;
        }
        int pointLength = length -n;
        while (i<pointLength){
            hd = hd.next;
            i++;
        }// 扫描到待删除的前一个节点
        ListNode pre = hd;
        ListNode point = hd.next;
        ListNode behind = hd.next.next;
        if (behind==null){
            // 待删除的节点为最后一个节点
            hd.next = null;
        }else{
            pre.next = behind;
            point.next = null;// 引用置空 JVM回收
        }
    return head;
    }
}
