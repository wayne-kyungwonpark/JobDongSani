package kakao.test;

import java.util.Arrays;
import java.util.List;

public class Number5 {
	
	public static void main(String[] args) {
		int[][] test = new int[10][10];
		int[][] solution = solution(test);
	}
	
	public static int[][] solution(int[][] nodeinfo){
		class Node{
			public Node(int value, Node left, Node right) {
				this.value = value;
				this.left = left;
				this.right = right;
			}
			public Node() {}
			private int value; // 인덱스
			private Node left;
			private Node right;
			public int getValue() {
				return value;
			}
			public void setValue(int value) {
				this.value = value;
			}
			public Node getLeft() {
				return left;
			}
			public void setLeft(Node left) {
				this.left = left;
			}
			public Node getRight() {
				return right;
			}
			public void setRight(Node right) {
				this.right = right;
			}
		}
		class Tree{
			public Node root;
			public void preOrder(List<Integer> answer, Node root) {
				answer.add(root.getValue());
				preOrder(answer, root.getLeft());
				preOrder(answer, root.getRight());
			}
			public void postOrder(List<Integer> answer, Node root) {
				postOrder(answer, root.getLeft());
				postOrder(answer, root.getRight());
				answer.add(root.getValue());
			}
		}
		
		int[][] answer = {};
		// 인덱스 순서 바꾸지 않을 것임
		int[] yArr = new int[nodeinfo.length];
		int[] xArr = new int[nodeinfo.length];
		
		for(int i=0;i<nodeinfo.length;i++) {
			xArr[i] = nodeinfo[i][0];
			yArr[i] = nodeinfo[i][1];
		}
		
		int[] yArrCopy = Arrays.copyOf(yArr, yArr.length);
		Arrays.sort(yArrCopy);
		
		Tree tree = new Tree();
		// 트리 만들기
		Node node = null;
		int rootIndex = 0;
		for(int i=yArrCopy.length-1;i>=0;i--) {
			if(i == yArrCopy.length - 1) {
				for(int j=0;j<yArr.length;j++) {
					if(yArrCopy[i] == yArr[j]) {
						rootIndex = j;
						break;
					}
				}
				node = new Node(rootIndex, new Node(), new Node());
			}else {
				
			}
		}
		
        return answer;
	}
	
}
