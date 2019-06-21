package algorithm.samsung;

import java.io.*;

public class _3752_PossibleTestScore {
    private static int N = 0;
    private static int[] scores = null;
    private static boolean[] checkScores;
    private static int possibleNum = 0;
    private static int totalScore = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int testNum = 0, testFreq = 0;
        while((str = br.readLine()) != null){
            if(testNum == 0){
                testNum = Integer.parseInt(str);
            }else{
                if(N == 0){
                    N = Integer.parseInt(str);
                    scores = new int[N];
                }else{
                    testFreq++;
                    String[] strArr = str.split(" ");
                    for (int i = 0; i < N; i++) {
                        scores[i] = Integer.parseInt(strArr[i]);
                    }
                    for (int i = 0; i < scores.length; i++) {
                        totalScore += scores[i];
                    }
                    checkScores = new boolean[totalScore + 1];
                    StringBuilder sb = new StringBuilder();
                    sb.append("#").append(testFreq).append(" ").append(doSomething());
                    bw.write(sb.toString());
                    N = 0; scores = null; checkScores = null; possibleNum = 0; totalScore = 0;
                    if(testFreq == testNum){
                        break;
                    }else{
                        bw.newLine();
                    }
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int doSomething() {
        checkScores[0] = true;
        dfs(0);
        for (int i = 0; i < checkScores.length; i++) {
            if(checkScores[i]){
                possibleNum++;
            }
        }
        return possibleNum;
    }

    private static void dfs(int depth){
        if(depth >= N){
            return;
        }
        for (int i = totalScore - 1; i >= 0; i--) {
            if(checkScores[i]){
                checkScores[i + scores[depth]] = true;

            }
        }
        dfs(depth + 1);
    }
}
