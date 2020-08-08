package algorithm.leetcode.hard;

public class _1028_RecoverATreeFromPreorderTraversal {
    public static void main(String[] args) {
        String S = "1-2--3--4-5--6--7";
        recoverFromPreorder(S);
    }

    public static TreeNode recoverFromPreorder(String S) {
        TreeNode root = new TreeNode();
        String[] strArr = S.split("-");
        for (int i = 0; i < strArr.length; i++) {
            System.out.println(strArr[i]);
        }
        return root;
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
