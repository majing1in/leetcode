package menu_code_1;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code21_102_LevelOrder {

    /**
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        // 保存每一级的节点
        List<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.size() > 0) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            // 遍历当前层级的节点
            for (int i = 0; i < size; i++) {
                list.add(queue.get(i).val);
                if (queue.get(i).left != null) {
                    queue.add(queue.get(i).left);
                }
                if (queue.get(i).right != null) {
                    queue.add(queue.get(i).right);
                }
            }
            // 移除上一级的节点
            for (int i = size - 1; i >= 0; i--) {
                queue.remove(i);
            }
            lists.add(list);
        }
        return lists;
    }

}
