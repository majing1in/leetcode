package menu_code_1;

import entity.ListNode;

public class Code13_21_MergeTwoLists {

    ListNode listNode = new ListNode();

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 ==null && l2 == null) {
            return null;
        }
        dfs(l1, l2, listNode);
        return listNode;
    }

    /**
     * 合并链表
     * @param l1
     * @param l2
     * @param listNode
     */
    public void dfs(ListNode l1, ListNode l2, ListNode listNode) {
        if (l1 != null && l2 != null) {
            listNode.next = new ListNode();
            if (l1.val < l2.val) {
                listNode.val = l1.val;
                dfs(l1.next, l2, listNode.next);
            } else {
                listNode.val = l2.val;
                dfs(l1, l2.next, listNode.next);

            }
        } else if (l1 != null) {
            listNode.val = l1.val;
            if (l1.next != null) {
                listNode.next = new ListNode();
                dfs(l1.next, l2, listNode.next);
            }
        } else if (l2 != null) {
            listNode.val = l2.val;
            if (l2.next != null) {
                listNode.next = new ListNode();
                dfs(l1, l2.next, listNode.next);
            }
        }
    }
}
