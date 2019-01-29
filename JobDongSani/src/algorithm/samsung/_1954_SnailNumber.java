package algorithm.samsung;

import java.io.*;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/samsung/_1954_SnailNumber.java
 *
 * Samsung > 문제 > 달팽숫자
 * 규칙성 찾기
 * * N = 2
 * 	* 2(오른쪽) 1(아래) 1(왼)
 * * N = 3
 * 	* 3(오) 2(아) 2(왼) 1(위) 1(오)
 * * N = 4
 * 	* 4(오) 3(아) 3(왼) 2(위) 2(오) 1(아) 1(왼)
 * * N = 5
 * 	* 5(오) 4(아) 4(왼) 3(위) 3(오) 2(아) 2(왼) 1(위) 1(오)
 *
 * * 임의의 N에 대해, 아래와 같은 프로세스를 거친다.
 * 	1. 이차원 int 배열을 만든다: snail[N][N]
 * 	2. snail[0] = {1, 2, 3, …, N} (snail[0][0] = 1, …, snail[0][N-1] = N)
 *
 * (j = 0)
 * 	3. i = 1 to N, snail[0][i - 1] = i
 * 	4. i = 1 to N - 1, snail[i][N-1] = N + i
 * 	5. i = 1 to N - 1, snail[N-1][N-1-i] = N + (N - 1) + i
 * 	6. i = 1 to N - 2, snail[N-1-i][0] = N + (N - 1) + (N - 1) + i
 * (j  = 1)
 * 	7. i = 2 to N - 1, snail[1][i - 1] = N + (N - 1) + (N - 1) + (N - 2) + (i - 1)
 * 	8. i = 2 to N - 2, snail[i][N-2] = N + 2(N - 1) + 2(N - 2) + (i - 1)
 * 	9. i = 2 to N - 2, snail[N-2][N—1-i] = N + 2(N - 1) + 2(N - 2) + (N - 3) + (i - 1)
 * 	10. i = 2 to N - 3, snail[N-1-i][1] = N + 2(N - 1) + 2(N - 2) + 2(N - 3) + (i - 1)
 *
 * * i의 범위가 1인 경우가 두 번 나왔을 때 break
 */
public class _1954_SnailNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int testNum = 0, testFreq = 0;
        while((str = br.readLine()) != null){
            if (testNum == 0) {
                testNum = Integer.parseInt(str);
            }else{
                testFreq++;
                int N = Integer.parseInt(str);
                int iter = (N % 2 == 0)?  N / 2 : N / 2 + 1;
                int[][] snail = new int[N][N];
                int end = 0;
                for (int i = 0; i < iter; i++) {
                    for (int j = 1 + i; j <= N - i; j++) {
                        snail[i][j - 1] = end + (j - i);
                        if(j == N - i){
                            end += (j - i);
                        }
                    }
                    if(N - 2 * i == 1){
                        break;
                    }
                    for (int j = 1 + i; j <= N - 1 - i; j++) {
                        snail[j][N - 1 - i] = end + (j - i);
                        if(j == N - 1 - i){
                            end += (j - i);
                        }
                    }
                    for (int j = 1 + i; j <= N - 1 - i ; j++) {
                        snail[N - 1 - i][N - 1 - j] = end + (j - i);
                        if(j == N - 1 - i){
                            end += (j - i);
                        }
                    }
                    if(N - 2 * i - 1 == 1){
                        break;
                    }
                    for (int j = 1 + i; j <= N - 2 - i ; j++) {
                        snail[N - 1 - j][i] = end + (j - i);
                        if(j == N - 2 - i){
                            end += (j - i);
                        }
                    }
                }
                bw.write("#" + testFreq);
                bw.newLine();
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        bw.write(String.valueOf(snail[i][j]) + " ");
                    }
                    if(i != N - 1){
                        bw.newLine();
                    }
                }
                if (testFreq == testNum) {
                    break;
                }else{
                    bw.newLine();
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
