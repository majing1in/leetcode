package menu_code_2;

import entity.ListNode;

public class Code9_面试题0205_addTwoNumbers {

    /**
     * 给定两个用链表表示的整数，每个节点包含一个数位。
     * 这些数位是反向存放的，也就是个位排在链表首部。
     * 编写函数对这两个整数求和，并用链表形式返回结果。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        ListNode node1 = l1;
        ListNode node2 = l2;
        while (node1 != null || node2 != null) {
            if (node1 != null) {
                num1.append(node1.val);
                node1 = node1.next;
            }
            if (node2 != null) {
                num2.append(node2.val);
                node2 = node2.next;
            }
        }
        char[] chars1 = num1.reverse().toString().toCharArray();
        char[] chars2 = num2.reverse().toString().toCharArray();
        StringBuilder builder = new StringBuilder();
        int cur = Math.max(chars2.length - 1, chars1.length - 1);
        int def = 0;
        while (cur >= 0) {
            int sum = def;
            if (cur < chars1.length) {
                sum = sum + Integer.parseInt(String.valueOf(chars1[cur]));
            }
            if (cur < chars2.length) {
                sum = sum + Integer.parseInt(String.valueOf(chars2[cur]));
            }
            int value = 0;
            if (sum >= 10) {
                def = 1;
                value = sum - 10;
            } else {
                def = 0;
                value = sum;
            }
            builder.append(value);
            cur--;
        }
        if (def == 1) {
            builder.append(def);
        }
        char[] chars = builder.reverse().toString().toCharArray();
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = listNode1;
        for (int i = 0; i < chars.length; i++) {
            if (listNode2 != null) {
                listNode2.val = Integer.parseInt(String.valueOf(chars[i]));
            }
            if (i != 0) {
                listNode2.next = new ListNode();
                listNode2 = listNode2.next;
            }
        }
        return listNode1;
    }
}
