package hot;

import entity.TreeNode;

public class Code19_617_MergeTrees {

    /**
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为NULL 的节点将直接作为新二叉树的节点。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        // 对应节点相加
        root1.val = root1.val + root2.val;
        // 递归左右子树
        TreeNode treeLeft = mergeTrees(root1.left, root2.left);
        TreeNode treeRight = mergeTrees(root1.right, root2.right);
        // 构建返回树
        root1.left = treeLeft;
        root1.right = treeRight;
        return root1;
    }
}
