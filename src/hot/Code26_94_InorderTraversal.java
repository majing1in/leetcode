package hot;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Code26_94_InorderTraversal {

    List<Integer> list = new ArrayList<>();

    /**
     * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right);
        }
        return list;
    }

}
