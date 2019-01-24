package algorithm.baekjoon.stepwise.graphdfsbfs;

import java.io.*;

public class _2606_Virus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int comNum = 0, lineNum = 0, lineFreq = 0;
        boolean[][] graph = null;
        while ((str = br.readLine()) != null) {
            if (comNum == 0) {
                comNum = Integer.parseInt(str);
                graph = new boolean[comNum + 1][comNum + 1];
            } else {
                if (lineNum == 0) {
                    lineNum = Integer.parseInt(str);
                } else {
                    String[] strArr = str.split(" ");
                    int i = Integer.parseInt(strArr[0]);
                    int j = Integer.parseInt(strArr[1]);
                    graph[i][j] = true;
                    graph[j][i] = true;
                    lineFreq++;
                }
                if (lineFreq == lineNum) {
                    break;
                }
            }
        }
        boolean[] infested = new boolean[comNum + 1];
        infested[1] = true;
        for (int i = 2; i < infested.length; i++) {
            boolean[] connected = new boolean[comNum + 1];
            if(graph[1][i] == true){
                infested[i] = true;
                connected[i] = true;
            }
        }
//        // graph가 제대로 만들어졌는지 체크
//        for (int i = 1; i < graph.length; i++) {
//            for (int j = 1; j < graph.length; j++) {
//                bw.write(String.valueOf(graph[i][j]) + " ");
//            }
//            bw.newLine();
//        }
        bw.flush();
        bw.close();
        br.close();
    }
}
