package algorithm.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class _1028_RecoverATreeFromPreorderTraversal {
    public static void main(String[] args) {
//        String S = "1-2--3--4-5--6--7";
//        String S = "1-2--3---4-5--6---7";
//        String S = "1-401--349---90--88";
        String S = "10-7--8";
        TreeNode root = recoverFromPreorder(S);
        System.out.println();
    }

    private static int presentIndex;
    private static List<Integer> heights, values;

    public static TreeNode recoverFromPreorder(String S) {
        TreeNode root = new TreeNode();
        char[] chArr = S.toCharArray();
        values = new ArrayList<>();
        heights = new ArrayList<>();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while(index < chArr.length && chArr[index] != '-'){
            sb.append(chArr[index++]);
        }
        makeNodes(chArr, index);
        root.val = Integer.parseInt(sb.toString());
        presentIndex = 0;
        makeTree(root, 0);
        return root;
    }

    private static void makeNodes(char[] chArr, int index){
        while(index < chArr.length){
            int height = 0;
            StringBuilder sb = new StringBuilder();
            while(chArr[index] == '-'){
                index++;
                height++;
            }
            while(index < chArr.length && chArr[index] != '-'){
                sb.append(chArr[index]);
                index++;
            }
            heights.add(height);
            values.add(Integer.parseInt(sb.toString()));
        }
    }

    private static void makeTree(TreeNode node, int height){
        if(presentIndex >= values.size()){
            return;
        }

        if(node.left == null){
            if(presentIndex >= values.size()){
                return;
            }
            if(heights.get(presentIndex) != height + 1){
                return;
            }
            node.left = new TreeNode(values.get(presentIndex));
            presentIndex++;
            makeTree(node.left, height + 1);
        }
        if(node.right == null){
            if(presentIndex >= values.size()){
                return;
            }
            if(heights.get(presentIndex) != height + 1){
                return;
            }
            node.right = new TreeNode(values.get(presentIndex));
            presentIndex++;
            makeTree(node.right, height + 1);
        }
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
