package menu_code_1;

import entity.ListNode;

import java.util.ArrayList;

public class Code14_234_IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode listNode = head;
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
