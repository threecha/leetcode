package com.threecha.hot100.q160;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        SolutionTwo solutionTwo = new SolutionTwo();
        // 初始化相交链表
        ListNode headA = new ListNode(0);
        ListNode headB = new ListNode(0);
        ListNode pubHead = new ListNode(0);
        // 公共链表部分
        ListNode pubNode1 = new ListNode(5);
        ListNode pubNode2 = new ListNode(5);
        ListNode pubNode3 = new ListNode(5);
        pubHead.next = pubNode1;
        pubNode1.next = pubNode2;
        pubNode2.next = pubNode3;


        // 对A链表初始化
        ListNode nodeA1 = new ListNode(2);
        ListNode nodeA2 = new ListNode(2);
        ListNode nodeA3 = new ListNode(2);
        ListNode nodeA4 = new ListNode(2);
        ListNode nodeA5 = new ListNode(2);
        headA.next = nodeA1;
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeA3.next = nodeA4;
        nodeA4.next = nodeA5;
        nodeA5.next = pubHead.next;



        // 对B链表初始化
        ListNode nodeB1 = new ListNode(1);
        ListNode nodeB2 = new ListNode(1);
        ListNode nodeB3 = new ListNode(1);
        headB.next = nodeB1;
        nodeB1.next = nodeB2;
        nodeB2.next = nodeB3;
        nodeB3.next = pubHead.next;

        ListNode pub = solution.getIntersectionNode(headA, headB);
        System.out.println(pub.val);


    }
}
