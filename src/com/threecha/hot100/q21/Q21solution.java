package com.threecha.hot100.q21;


/**
 * 21 合并两个有序链表
 * <p>
 * 思路 对2个链表的当前节点进行比较 选取最小的依次加入新的链表的
 * 2个链表都不带头结点
 */
public class Q21solution {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode l1, ListNode l2) {
        // 其中一个节点到达末尾的话 直接链接过去即可
        ListNode tempHead = new ListNode();
        ListNode head = tempHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tempHead.next = l1;
                l1 = l1.next;
                tempHead = tempHead.next;
            } else {
                tempHead.next = l2;
                l2 = l2.next;
                tempHead = tempHead.next;
            }
        }
        //这时候其中一条链表走到了尽头 将另一条不为null的链表 拼接到后面即可
        if (l1 == null) {
            tempHead.next = l2;
        } else {
            tempHead.next = l1;
        }
        return head.next;

    }
}
