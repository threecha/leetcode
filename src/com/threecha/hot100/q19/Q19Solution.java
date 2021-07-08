package com.threecha.hot100.q19;

/**
 * 删除链表的倒数第n个节点
 * <p>
 * 思路：N => 1
 * <p>
 * 1. 双指针问题 第一个先走N
 * 2. 后续2个指针向后移动
 * 3. 第二个指针到达链表的末尾 第一个指向的即时待删除的元素
 *
 *
 *  这里有个注意事项 head 和自己定义的双指针节 都是一个正常的节点
 */
public class Q19Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.next = new ListNode(1);
        printNodeFunction(head);
        ListNode result = solution(head, 1);

        printNodeFunction(result);
    }

    private static ListNode solution(ListNode head, int n) {
        // 定义双指针
        ListNode a = head;
        ListNode b = head;
        // B先往前走n步
        int i = 0;
        while (i < n) {
            i++;
            b = b.next;
        }
        while (b.next != null) {
            a = a.next;
            b = b.next;
        }
        //删掉a指针的下一个元素即可
        ListNode temp = a.next;
        a.next = temp.next;
        temp.next = null;// 将待删除的元素索引置位空

        return head;
    }

    private static void printNodeFunction(ListNode head){
        System.out.print("[ ");
        while (head.next!=null){
            System.out.print(head.next.val+" ");
            head = head.next;
        }
        System.out.print(" ]");
    }
}
