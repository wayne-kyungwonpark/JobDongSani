package algorithm.leetcode.medium;

import sun.reflect.generics.tree.Tree;

public class _98_ValidateBinarySearchTree {

    public static void main(String[] args) {
        //[5,1,7,null,null,3,8] -> false 나와야 함
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root.right, root.val, Long.MAX_VALUE) && isValidBST(root.left, Long.MIN_VALUE, root.val);
    }

    private static boolean isValidBST(TreeNode node, long lbound, long rbound) {
        if(node == null){
            return true;
        }

        if(node.val > lbound && node.val < rbound){
            return isValidBST(node.left, lbound, Math.min(node.val, rbound))
                    && isValidBST(node.right, Math.max(node.val, lbound), rbound);
        }

        return false;
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

