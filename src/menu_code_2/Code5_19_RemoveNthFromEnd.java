package menu_code_2;

import entity.ListNode;

public class Code5_19_RemoveNthFromEnd {

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode next = head;
        int len = 0;
        // 链表长度
        while (next != null) {
            next = next.next;
            len++;
        }
        // 移除的节点是头节点
        if (n == len) {
            return head.next;
        }
        ListNode listNode = head;
        // 节点从 0 开始多减 1
        int i = len - n - 1;
        // 定位到移除的节点
        while (i > 0) {
            listNode = listNode.next;
            i--;
        }
        listNode.next = listNode.next.next;
        return head;
    }
}
