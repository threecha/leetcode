package com.threecha.hot100.q19;

public class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        head.next = node1;
//        ListNode node2 = new ListNode(2);
//        node1.next = node2;
//        ListNode node3 = new ListNode(3);
//        node2.next = node3;
//        ListNode node4 = new ListNode(4);
//        node3.next = node4;
//        ListNode node5 = new ListNode(5);
//        node4.next = node5;
        Solution solution = new Solution();
        ListNode startNode = solution.removeNthFromEnd(head, 1);
        int i = 0;
        while (startNode.next!=null){
            startNode = startNode.next;
            i++;
            System.out.println("当前节点为："+ i + " 节点值为：" + startNode.val);
        }
    }
}
