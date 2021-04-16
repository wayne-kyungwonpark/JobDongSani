package algorithm.leetcode.easy;

public class _101_SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.right = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        System.out.println(isSymmetric(root));

    }

    public static boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private static boolean check(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null && right != null){
            return false;
        }
        if(left != null && right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
