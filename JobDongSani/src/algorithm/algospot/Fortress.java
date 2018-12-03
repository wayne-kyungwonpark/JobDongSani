package algorithm.algospot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Fortress {

	private static int num;
	
	private static int calculate(Node root) {
		if(root.children.isEmpty()) {
			return 0;
		}
//		if(root.children.size() == 1) {
//			return root.children.get(0).height;
//		}
		for(int i=0;i<root.children.size();i++) {
			for(int j=i+1;j<root.children.size();j++) {
				num = Math.max(num, root.children.get(i).height + root.children.get(j).height);
			}
		}
		for(int i=0;i<root.children.size();i++) {
			num = Math.max(num, calculate(root.children.get(i)));
		}
		return num;
	}
	
	private static int insertHeight(Node root) {
		if(root.children.isEmpty()) {
			return root.height;
		}else {
			int height = 2;
			for(int i=0;i<root.children.size();i++) {
				height = Math.max(height, insertHeight(root.children.get(i)) + 1);
			}
			root.height = height;
			return height;
		}
	}
	
	private static void makeTree(Node A, Node B) {
		double dist = (A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y - B.y);
		double r1 = A.r * A.r;
		double r2 = B.r * B.r;
		if(dist < r1 + r2) {
			Node small = null, large = null;
			if(r1 > r2) {
				small = B; large = A;
			}else {
				small = A; large = B;
			}
			if(small.parent == null) {
				small.parent = large;
				large.children.add(small);
			}else if(small.parent != large){
				insert(large, small);
			}
		}
	}
	
	private static void insert(Node large, Node small) {
		if(large.r < small.parent.r) {
			large.children.add(small);
			small.parent.children.remove(small);
			small.parent = large;
		}else { // large.r >= small.parent.r
			if(small.parent.parent == null) {
				small.parent.parent = large;
				large.children.add(small.parent);
			}else if(small.parent.parent != large){
				insert(large, small.parent);
			}
		}
	}
	
	public static class Node {
		public int height = 1;
		public int x, y, r;
		public Node parent;
		public List<Node> children = new ArrayList<Node>();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int testNum = 0, testFreq = 0;
		int fortNum = 0, fortFreq = 0;
		Node root = null;
		List<Node> nodeList = null;
		while((str = br.readLine()) != null) {
			if(testNum == 0) {
				testNum = Integer.parseInt(str);
			}else {
				if(fortNum == 0) {
					fortNum = Integer.parseInt(str);
				}else {
					String[] strArr = str.split(" ");
					if(fortFreq == 0) {
						root = new Node();
						nodeList = new ArrayList<Node>();
						root.x = Integer.parseInt(strArr[0]);
						root.y = Integer.parseInt(strArr[1]);
						root.r = Integer.parseInt(strArr[2]);
						nodeList.add(root);
					}else {
						Node node = new Node();
						node.x = Integer.parseInt(strArr[0]);
						node.y = Integer.parseInt(strArr[1]);
						node.r = Integer.parseInt(strArr[2]);
						nodeList.add(node);
					}
					fortFreq++;
					if(fortNum == fortFreq) {
						testFreq++;
						for(int i=0;i<nodeList.size();i++) {
							for(int j=i+1;j<nodeList.size();j++) {
								makeTree(nodeList.get(i), nodeList.get(j));
							}
						}
						num = 0;
						insertHeight(root);
						num = Math.max(num, root.height - 1);
						bw.write(String.valueOf(calculate(root)));
						bw.newLine();
						fortNum = 0; fortFreq = 0;
						root = null; nodeList = null;
					}
				}
				if(testNum == testFreq) {
					break;
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
