package com.threecha.hot100.q160;

/**
 * 2条AB链表移动到达末尾后分别指BA的head 如果相遇则为交点
 */
public class SolutionTwo {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA;
        ListNode hb = headB;
        while (ha != hb) {
            ha = ha == null ? headB : ha.next;
            hb = hb == null ? headA : hb.next;
        }
        return ha;
    }
}
