package com.threecha.hot100.q160;

/**
 * 求2个链表交点 长的链表先走长度差 后续各走一步。第一个相交的点符合题意。
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lA = 0;
        int lB = 0;
        ListNode hA = headA;
        ListNode hB = headB;
        while (hA.next != null) {
            lA++;
            hA = hA.next;
        }
        while (hB.next!= null){
            lB++;
            hB = hB.next;
        }
        int flag = 0;
        if (lA>lB){
            flag = lA - lB;
            while (flag>0){
                headA = headA.next;
                flag--;
            }
        }else if ( lA<lB){
            flag = lB-lA;
            while (flag>0){
                headB = headB.next;
                flag--;
            }
        }else {
            // lA == lB 同时移动即可
        }

        while (headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;

    }
}
