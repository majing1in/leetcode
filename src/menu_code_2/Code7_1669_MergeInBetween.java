package menu_code_2;

import entity.ListNode;

public class Code7_1669_MergeInBetween {

    /**
     * 给你两个链表list1 和list2，它们包含的元素分别为n 个和m 个。
     * 请你将list1中第a个节点到第b个节点删除，并将list2接在被删除节点的位置。
     * @param list1
     * @param a
     * @param b
     * @param list2
     * @return
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // aNode a位置的节点，bNode b位置的节点
        ListNode aNode = null, bNode = null, next = list1;
        int cur = 0;
        while (next != null) {
            // 不需要取到a位置，应该是截取前一个位置
            if (cur == a - 1) {
                aNode = next;
            }
            // 截取到b位置后一个位置
            if (cur == b + 1) {
                bNode = next;
            }
            cur++;
            next = next.next;
        }
        // 与list2头部连接
        aNode.next = list2;
        ListNode next2 = list2;
        while (next2.next != null) {
            next2 = next2.next;
        }
        // 与list2尾部连接
        next2.next = bNode;
        return list1;
    }
}
