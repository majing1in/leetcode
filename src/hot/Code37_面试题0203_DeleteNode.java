package hot;

import entity.ListNode;

/**
 * @Author Xiaoma
 * @Date 2021/2/28 0028 23:04
 * @Email 1468835254@qq.com
 */
public class Code37_面试题0203_DeleteNode {

    /**
     * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
     * 未做出
     * @param node
     */
    public void deleteNode(ListNode node) {
        //将这个结点的数据替换为下一个结点
        node.val = node.next.val;
        //删除下一个结点
        node.next = node.next.next;
    }
}
