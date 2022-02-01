package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class _94_BinaryTreeInorderTraversal {
    private static List<Integer> answer = null;

    public static List<Integer> inorderTraversal(TreeNode root) {
        answer = new ArrayList<>();
        inorder(root);
        return answer;
    }

    private static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        answer.add(root.val);
        inorder(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
