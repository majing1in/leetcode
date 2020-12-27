package recursion.code;

public class Code1_938_RangeSumBST {

    private static int target = 0;

    /**
     * 解题 1
     * @param root
     * @param low
     * @param high
     * @return
     */
    public static int rangeSumBST1(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        rec1(root, low, high);
        return target;
    }

    public static int rec1(TreeNode root, int low, int high) {
        if (root.val <= high && root.val >= low) {
            target = target + root.val;
        }
        return rangeSumBST1(root.left, low, high) + rangeSumBST1(root.right, low, high);
    }

    /**
     * 题解 2
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        } else {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
    }

}
