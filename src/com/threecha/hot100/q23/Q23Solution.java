package com.threecha.hot100.q23;

/**
 * q23 合并 k个升序链表
 * 思路同合并2个升序链表一样
 * <p>
 * 链表不带头结点 可以尝试自己构建头结点
 * 22合并向下递归
 */
public class Q23Solution {
    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(1);
        ListNode listNode01 = new ListNode(4);
        ListNode listNode02 = new ListNode(5);
        listNode0.next=listNode01;
        listNode01.next=listNode02;

        ListNode listNode1 = new ListNode(1);
        ListNode listNode11 = new ListNode(3);
        ListNode listNode12 = new ListNode(4);
        listNode1.next=listNode11;
        listNode11.next=listNode12;

        ListNode listNode2 = new ListNode(2);
        listNode2.next= new ListNode(6);

        ListNode[] list = new ListNode[]{listNode0,listNode1,listNode2};
        ListNode listNode = mergeKLists(list);
        printNode(listNode);

    }
    private static void printNode(ListNode head){
        System.out.print("[ ");
        while (head!=null){
            System.out.print(head.val);
            head =head.next;
        }
        System.out.println(" ]");

    }

    public static  ListNode mergeKLists(ListNode[] lists) {
        ListNode tempHead = new ListNode();
        ListNode head = tempHead;
        int length = lists.length;
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            return lists[0];
        }
        ListNode tempNode = lists[0];
        for (int i = 1; i < length; i++) {
            ListNode nodeI = lists[i];
            printNode(nodeI);
            while (tempNode != null && nodeI != null) {
                if (tempNode.val >= nodeI.val) {
                    tempHead.next = nodeI;
                    nodeI = nodeI.next;
                } else {
                    tempHead.next = tempNode;
                    tempNode = tempNode.next;
                }
                tempHead = tempHead.next;
                if (tempNode == null) {
                    tempHead.next = nodeI;
                }
                if (nodeI == null) {
                    tempHead.next = tempNode;
                }
            }
            tempNode = head.next;
            tempHead = head;
        }
        return tempNode;
    }
}
