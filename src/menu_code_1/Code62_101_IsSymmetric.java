package menu_code_1;

import entity.TreeNode;

/**
 * @Author Xiaoma
 * @Date 2021/3/6 0006 14:40
 * @Email 1468835254@qq.com
 */
public class Code62_101_IsSymmetric {

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return flag;
        }
        isSymmetricMethod(root.left, root.right);
        return flag;
    }
    boolean flag = true;
    public void isSymmetricMethod(TreeNode le, TreeNode ri) {
        // 预判断
        if (le == null && ri == null) {
            return;
        }
        if (le == null) {
            flag = false;
            return;
        }
        if (ri == null) {
            flag = false;
            return;
        }
        if (le.val != ri.val) {
            flag = false;
            return;
        }
        // 左右相互取值判断
        isSymmetricMethod(le.left, ri.right);
        isSymmetricMethod(le.right, ri.left);
    }
}
