package algorithm.samsung;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class _7699_SuzyTravel {

	private static int R = 0, C = 0;
	private static char[][] islands = null;
	private static int maxSpecialties = 0;
	
	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		int testNum = Integer.parseInt(scn.nextLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= testNum; i++) {
			String[] strArr = scn.nextLine().split(" ");
			R = Integer.parseInt(strArr[0]); C = Integer.parseInt(strArr[1]);
			islands = new char[R][C];
			for(int j = 0; j < R; j++) {
				islands[j] = scn.nextLine().toCharArray();
			}
			doSomething();
			sb.append("#").append(i).append(" ").append(maxSpecialties);
			if(i != testNum){
				sb.append("\n");
			}
			R = 0; C = 0; islands = null; maxSpecialties = 0;
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.close();
		scn.close();
	}

	private static void doSomething() {
		LinkedList<Character> specialties = new LinkedList<>();
		boolean[][] checks = new boolean[R][C];
		specialties.add(islands[0][0]); checks[0][0] = true;
		dfs(0, 0, specialties, checks);
	}
	
	private static void dfs(int row, int col, LinkedList<Character> specialties, boolean[][] checks){
		if(row != 0 && !checks[row - 1][col] && !specialties.contains(islands[row - 1][col])){
			specialties.add(islands[row - 1][col]);
			checks[row - 1][col] = true;
			if(maxSpecialties < specialties.size()){
				maxSpecialties = specialties.size();
			}
			dfs(row - 1, col, specialties, checks);
//			specialties.remove(islands[row - 1][col]);
			specialties.removeLast();
			checks[row - 1][col] = false;
		}
		if(row != R - 1 && !checks[row + 1][col] && !specialties.contains(islands[row + 1][col])){
			specialties.add(islands[row + 1][col]);
			checks[row + 1][col] = true;
			if(maxSpecialties < specialties.size()){
				maxSpecialties = specialties.size();
			}
			dfs(row + 1, col, specialties, checks);
//			specialties.remove(islands[row + 1][col]);
			specialties.removeLast();
			checks[row + 1][col] = false;
		}
		if(col != 0 && !checks[row][col - 1] && !specialties.contains(islands[row][col - 1])){
			specialties.add(islands[row][col - 1]);
			checks[row][col - 1] = true;
			if(maxSpecialties < specialties.size()){
				maxSpecialties = specialties.size();
			}
			dfs(row, col - 1, specialties, checks);
//			specialties.remove(islands[row][col - 1]);
			specialties.removeLast();
			checks[row][col - 1] = false;
		}
		if(col != C - 1 && !checks[row][col + 1] && !specialties.contains(islands[row][col + 1])){
			specialties.add(islands[row][col + 1]);
			checks[row][col + 1] = true;
			if(maxSpecialties < specialties.size()){
				maxSpecialties = specialties.size();
			}
			dfs(row, col + 1, specialties, checks);
//			specialties.remove(islands[row][col + 1]);
			specialties.removeLast();
			checks[row][col + 1] = false;
		}
		if(maxSpecialties < specialties.size()){
			maxSpecialties = specialties.size();
		}
	}
}
