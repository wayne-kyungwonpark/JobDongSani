package algorithm.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Trail {

	private static int[][] trailInfo;
	private static boolean[][] isPassed;
	private static int N;
	private static int K;
	
	/**
	 * DP 사용
	 * @param cutUsed	: 깎았는지 여부
	 * @param passYn	: 이때까지 거쳐온 경로 표시
	 * @param x			: 현재 위치(x)
	 * @param y			: 현재 위치(y)
	 * @param value		: 현재 값
	 * @return 경로 수
	 */
	private static int pathValue(boolean cutUsed, boolean[][] passYn, int x, int y, int value) {
		boolean[][] newPassYn = new boolean[N][N];
		for(int i=0;i<N;i++) {
			System.arraycopy(passYn[i], 0, newPassYn[i], 0, N);
		}
		newPassYn[x][y] = true;
		int maxPath = 1;
		// 위
		if(x != 0 && !passYn[x - 1][y]) {
			if(trailInfo[x - 1][y] < value) {
				maxPath = Math.max(maxPath
						, pathValue(cutUsed, newPassYn, x - 1, y, trailInfo[x - 1][y]) + 1);
			}else if(trailInfo[x - 1][y] - value < K && !cutUsed) {
				for(int i=1;i<=K;i++) {
					if(trailInfo[x - 1][y]-i<value) {
						maxPath = Math.max(maxPath
								, pathValue(true, newPassYn, x - 1, y, trailInfo[x - 1][y] - i) + 1);
					}
				}
			}
		}
		// 아래
		if(x != N - 1 && !passYn[x + 1][y]) {
			if(trailInfo[x + 1][y] < value) {
				maxPath = Math.max(maxPath
						, pathValue(cutUsed, newPassYn, x + 1, y, trailInfo[x + 1][y]) + 1);
			}else if(trailInfo[x + 1][y] - value < K && !cutUsed) {
				for(int i=1;i<=K;i++) {
					if(trailInfo[x + 1][y]-i<value) {
						maxPath = Math.max(maxPath
								, pathValue(true, newPassYn, x + 1, y, trailInfo[x + 1][y] - i) + 1);
					}
				}
			}
		}
		// 왼쪽
		if(y != 0 && !passYn[x][y - 1]) {
			if(trailInfo[x][y - 1] < value) {
				maxPath = Math.max(maxPath
						, pathValue(cutUsed, newPassYn, x, y - 1, trailInfo[x][y - 1]) + 1);
			}else if(trailInfo[x][y - 1] - value < K && !cutUsed) {
				for(int i=1;i<=K;i++) {
					if(trailInfo[x][y - 1]-i<value) {
						maxPath = Math.max(maxPath
								, pathValue(true, newPassYn, x, y - 1, trailInfo[x][y - 1] - i) + 1);
					}
				}
			}
		}
		// 오른쪽
		if(y != N - 1 && !passYn[x][y + 1]) {
			if(trailInfo[x][y + 1] < value) {
				maxPath = Math.max(maxPath
						, pathValue(cutUsed, newPassYn, x, y + 1, trailInfo[x][y + 1]) + 1);
			}else if(trailInfo[x][y + 1] - value < K && !cutUsed) {
				for(int i=1;i<=K;i++) {
					if(trailInfo[x][y + 1]-i<value) {
						maxPath = Math.max(maxPath
								, pathValue(true, newPassYn, x, y + 1, trailInfo[x][y + 1] - i) + 1);
					}
				}
			}
		}
		return maxPath;
	}
	
	// 스타팅 위치 찾는 메소드
	private static boolean[][] findStart(int[][] trailInfo, int maxHeight){
		boolean[][] start = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(trailInfo[i][j] == maxHeight) {
					start[i][j] = true;
				}
			}
		}
		return start;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int testNum = 0, testFreq = 0;
		int inCaseFreq = 0, maxHeight = 0;
		N = 0; K = 0;
		while((str = br.readLine()) != null) {
			if(testNum == 0) {
				testNum = Integer.parseInt(str);
			}else {
				String[] strArr = str.split(" ");
				if(N == 0) {
					N = Integer.parseInt(strArr[0]);
					K = Integer.parseInt(strArr[1]);
					trailInfo = new int[N][N];
					isPassed = new boolean[N][N];
				}else {
					for(int i=0;i<N;i++) {
						int tmp = Integer.parseInt(strArr[i]);
						if(maxHeight < tmp) {
							maxHeight = tmp;
						}
						trailInfo[inCaseFreq][i] = tmp; 
					}
					inCaseFreq++;
				}
				if(N == inCaseFreq) {
					testFreq++;
					// 스타트 위치 찾기
					boolean[][] start = findStart(trailInfo, maxHeight);
					
					// 스타트 위치마다 최대 등산 경로 찾기
					int maxValue = 0;
					for(int i=0;i<N;i++) {
						for(int j=0;j<N;j++) {
							if(start[i][j]) {
								maxValue = Math.max(maxValue
										, pathValue(false, isPassed, i, j, maxHeight));
							}
						}
					}
					
					StringBuilder sb = new StringBuilder();
					sb.append("#").append(testFreq).append(" ").append(maxValue);
					bw.write(sb.toString());
					bw.newLine();
					
					trailInfo = null; isPassed = null;
					N = 0; K = 0; inCaseFreq = 0; maxHeight = 0;
					maxValue = 0;
				}
			}
			if(testNum == testFreq) {
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
}
