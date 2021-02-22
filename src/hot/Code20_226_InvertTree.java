package hot;

import recursion.TreeNode;

public class Code20_226_InvertTree {

    /**
     * 翻转一棵二叉树。
     * 从上向下交换左右节点
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode treeRight = root.right;
        root.right = root.left;
        root.left = treeRight;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
