package menu_code_1;

import entity.TreeNode;

/**
 * @Author Xiaoma
 * @Date 2021/3/6 0006 14:29
 * @Email 1468835254@qq.com
 */
public class Code61_100_IsSameTree {

    /**
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean flag = true;
        // 预判断
        if (p == null && q == null) {
            return flag;
        }
        if (p == null && q != null) {
            return !flag;
        }
        if (p != null && q == null) {
            return !flag;
        }
        // 节点值判断
        if (p.val != q.val) {
            return !flag;
        }
        // 左右树递归
        boolean flagLeft = isSameTree(p.left, q.left);
        boolean flagRight = isSameTree(p.right, q.right);
        if (flagLeft && flagRight) {
            return false;
        }
        return !flag;
    }
}
