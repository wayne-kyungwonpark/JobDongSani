package algorithm.algospot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Graduation {

	private static final int INF = 987654321;
	private static int n, k, m, l;
	private static int[] prerequisite;
	private static int[] classes;
	private static int[][] cache;
	
	//이번학기가 semester, 지금까지 들은 과목의 집합이 taken
	//k개 이상의 과목을 모두 듣기 위해 몇 학기나 더 있어야 하는지?
	private static int graduate(int semester, int taken) {
		if(Integer.bitCount(taken) >= k) {
			return 0;
		}
		if(semester == m) {
			return INF;
		}
		int ret = cache[semester][taken];
		if(ret != 0) {
			return ret;
		}
		ret = INF;
		//이번학기에 들을 수 있는 과목 중 아직 듣지 않은 과목들을 찾음
		int canTake = (classes[semester] & ~taken);
		//선수과목을 다 듣지 않은 과목들을 걸러냄
		for(int i=0;i<n;i++) {
			if((canTake & (1 << i)) != 0 && (taken & prerequisite[i]) != prerequisite[i]) {
				canTake &= ~(1 << i);
			}
		}
		//이 집합의 모든 부분집합을 순회
		for(int take=canTake;take>0;take=((take - 1) & canTake)) {
			if(Integer.bitCount(take) > l) {
				continue;
			}
			ret = Math.min(ret, graduate(semester + 1, taken | take) + 1);
		}
		//이번 학기에 아무 것도 듣지 않을 경우 체크
		ret = Math.min(ret, graduate(semester + 1, taken));
		//자바에서는 값에 대한 포인터 지정이 안되므로 따로 넣어줘야 메모이제이션이 가능
		cache[semester][taken] = ret;
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		
		int testNum = 0;
		
		int testFreq = 0; int classFreq = 0; int semesterFreq = 0;
		
		while((str = br.readLine()) != null) {
			if(testNum == 0) {
				testNum = Integer.parseInt(str);
			}else {
				if(n == 0) {
					String[] strArr = str.split(" ");
					n = Integer.parseInt(strArr[0]); k = Integer.parseInt(strArr[1]);
					m = Integer.parseInt(strArr[2]); l = Integer.parseInt(strArr[3]);
					prerequisite = new int[n];
					classes = new int[m];
					cache = new int[m][1 << n];
				}else {
					if(n > classFreq) {
						String[] strArr = str.split(" ");
						for(int i=1;i<=Integer.parseInt(strArr[0]);i++) {
							prerequisite[classFreq] |= (1 << Integer.parseInt(strArr[i]));					
						}
						classFreq++;
					}else if(m > semesterFreq) {
						String[] strArr = str.split(" ");
						for(int i=1;i<=Integer.parseInt(strArr[0]);i++) {
							classes[semesterFreq] |= (1 << Integer.parseInt(strArr[i]));
						}
						semesterFreq++;
					}
					if(n == classFreq && m == semesterFreq){
						int value = graduate(0, 0);
						if(value != INF) {
							bw.write(String.valueOf(value));
						}else {
							bw.write("IMPOSSIBLE");
						}
						bw.newLine();
						testFreq++;
						classFreq = 0; semesterFreq = 0; n = 0; k = 0; n = 0; l = 0;
						prerequisite = null; classes = null; cache = null;
					}
				}
			}
			if(testFreq >= testNum) {
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
