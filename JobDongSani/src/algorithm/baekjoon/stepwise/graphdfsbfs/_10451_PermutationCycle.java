package algorithm.baekjoon.stepwise.graphdfsbfs;

import java.io.*;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/baekjoon/stepwise/graphdfsbfs/_10451_PermutationCycle.java
 *
 * Baekjoon > 문제 > 단계별로 풀어보기 > 그래프 (DFS, BFS) > 순열 사이클
 * 1. 1부터 시작하여 1 -> 3 -> 7 -> 5 -> 1 순으로 꼬리를 물며 거쳐갔는지 여부를 체크한다.
 * 2. 그 다음 체크 안된 숫자부터 다시 시작한다. 2 -> 2, 4 -> 8 -> 6 -> 4, ... 순열의 끝으로 갔을 때 끝낸다.
 */
public class _10451_PermutationCycle {
    private static int findCycles(int[] permutation){
        int cycleNum = 0;
        boolean[] isUsed = new boolean[permutation.length];
        for (int i = 0; i < permutation.length; i++) {
            if(!isUsed[i]){
                int start = i + 1;
                int value = permutation[i];
                while(start != value){
                    isUsed[value - 1] = true;
                    value = permutation[value - 1];
                }
                cycleNum++;
            }
        }
        return cycleNum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int testNum = 0, testFreq = 0, perLen = 0;
        int[] permutation = null;
        while ((str = br.readLine()) != null) {
            if(testNum == 0){
                testNum = Integer.parseInt(str);
            }else{
                if(perLen == 0){
                    perLen = Integer.parseInt(str);
                }else{
                    permutation = new int[perLen];
                    String[] strArr = str.split(" ");
                    for (int i = 0; i < strArr.length; i++) {
                        permutation[i] = Integer.parseInt(strArr[i]);
                    }
                    bw.write(String.valueOf(findCycles(permutation)));
                    bw.newLine();
                    perLen = 0;
                    permutation = null;
                    testFreq++;
                }
            }
            if(testNum == testFreq){
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
