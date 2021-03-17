package menu_code_2;

import entity.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Code8_445_AddTwoNumbers {

    /**
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * 进阶：如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        ListNode next1 = l1;
        ListNode next2 = l2;
        // 获得l1和l2的所有值
        while (next1 != null || next2 != null) {
            if (next1 != null) {
                list1.add(next1.val);
                next1 = next1.next;
            }
            if (next2 != null) {
                list2.add(next2.val);
                next2 = next2.next;
            }
        }
        // 反转集合，方便直接相加
        Collections.reverse(list1);
        Collections.reverse(list2);
        List<Integer> nums = new ArrayList<>();
        int length = Math.max(list1.size(), list2.size());
        int curry = 0;
        // 合并两个集合的值
        for (int i = 0; i < length; i++) {
            int sum = 0;
            if (i < list1.size()) {
                sum = list1.get(i) + sum;
            }
            if (i < list2.size()) {
                sum = list2.get(i) + sum;
            }
            int temp = sum + curry;
            // 取余
            int value = temp % 10;
            nums.add(value);
            // 判断前一次是否进位的值+当前sum是否超过了10
            if (temp >= 10) {
                curry = 1;
            } else {
                curry = 0;
            }
        }
        // 判断最后一位是否进位，进位则+1
        if (curry == 1) {
            nums.add(curry);
        }
        // 再次反转回正常状态
        Collections.reverse(nums);
        ListNode node1 = new ListNode();
        ListNode node2 = node1;
        // 组成新链表
        for (int i = 0; i <= nums.size() - 1; i++) {
            node2.val = nums.get(i);
            // 最后一位时不需要构建下一位
            if (i != nums.size() - 1) {
                node2.next = new ListNode();
                node2 = node2.next;
            }
        }
        return node1;
    }
}
