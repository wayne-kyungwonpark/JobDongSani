package algorithm.baekjoon.stepwise.tree;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _2263_TreeTraversal {
    private static int n = 0;
    private static int[] inorder = null;
    private static int[] postorder = null;
    private static StringBuilder sb = null;

    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = scn.nextInt(); scn.nextLine();
        inorder = new int[n];
        postorder = new int[n];
        for (int i = 0; i < n; i++) {
            inorder[i] = scn.nextInt();
        }
        scn.nextLine();
        for (int i = 0; i < n; i++) {
            postorder[i] = scn.nextInt();
        }

        Node root = makeTree(0, n - 1, 0, n - 1);

        sb = new StringBuilder();
        preOrder(root);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        scn.close();
    }

    private static void preOrder(Node root) {
        if(root == null){
            return;
        }
        sb.append(root.value).append(" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 핵심 로직.
     * 1. postorder의 마지막 element는 해당 트리의 root 노드가 된다.
     * 2. 해당 element를 inorder에서 찾는다. (inorder의 index에서 찾았다고 가정)
     * 3. root 노드의 오른쪽 서브 트리, 왼쪽 서브 트리에 속한 element의 범위 인덱스를 구해 재귀 로직을 돌린다.
     *    (오른쪽 서브 트리)
     *    - inorder의 index + 1 인덱스부터 inorderEnd까지는 root 노드의 오른쪽 서브 트리에 존재
     *    - postorder의 {postOrderEnd - (inorderEnd - index)} 인덱스부터 {postOrderEnd - 1} 인덱스까지는 root 노드의 오른쪽 서브 트리에 존재
     *    (왼쪽 서브 트리)
     *    - inorder의 inorderStart 인덱스부터 index - 1 인덱스까지는 root 노드의 왼쪽 서브 트리에 존재
     *    - postorder의 postOrderStart 인덱스부터 {postOrderEnd - (inorderEnd - index) - 1} 인덱스까지는 root 노드의 왼쪽 서브 트리에 존재
     * @param inorderStart
     * @param inorderEnd
     * @param postOrderStart
     * @param postOrderEnd
     * @return
     */
    private static Node makeTree(int inorderStart, int inorderEnd, int postOrderStart, int postOrderEnd) {
        if(postOrderStart > postOrderEnd || inorderStart > inorderEnd){
            return null;
        }
        Node root = new Node(postorder[postOrderEnd]);
        for (int i = inorderEnd; i >= inorderStart; i--) {
            if(inorder[i] == postorder[postOrderEnd]){
                root.right = makeTree(i + 1, inorderEnd, postOrderEnd - (inorderEnd - i), postOrderEnd - 1);
                root.left = makeTree(inorderStart, i - 1, postOrderStart, postOrderEnd - (inorderEnd - i) - 1);
                break;
            }
        }
        return root;
    }

    private static class Node{
        public Node left = null;
        public Node right = null;
        public int value;
        public Node(int value){
            this.value = value;
        }
    }
}
