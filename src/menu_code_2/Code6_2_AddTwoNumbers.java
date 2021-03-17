package menu_code_2;

import entity.ListNode;

public class Code6_2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = null, node2 = null;
        int def = 0;
        while(l1 != null || l2 != null) {
            int sum = 0;
            if(l1 != null) {
                sum += l1.val;
            }
            if(l2 != null) {
                sum += l2.val;
            }
            int value = sum +def;
            int cur = (sum +def) % 10;
            // 初始化头节点
            if(node1 == null) {
                node1 = new ListNode(cur);
                node2 = node1;
                def = value >= 10 ? 1 : 0;
            } else {
                node2.next = new ListNode(cur);
                node2 = node2.next;
                def = value >= 10 ? 1 : 0;
            }
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        // 判断最后一位是否需要进位
        if(def == 1) {
            node2.next = new ListNode(def);
        }
        return node1;
    }
}
