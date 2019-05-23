package algorithm.baekjoon.nm;

import java.io.*;
import java.util.LinkedList;

public class _15652_NM4 {
    private static void rePermutationNonDescending(int N, int M, LinkedList<Integer> rCom, StringBuilder sb){
        if(rCom.size() == M){
            for(int i : rCom){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(rCom.isEmpty() || rCom.getLast() <= i){
                rCom.add(i);
                rePermutationNonDescending(N, M, rCom, sb);
                rCom.removeLast();
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int N = 0, M = 0;
        while((str = br.readLine()) != null){
            String[] strArr = str.split(" ");
            N = Integer.parseInt(strArr[0]);
            M = Integer.parseInt(strArr[1]);
            break;
        }
        LinkedList<Integer> rCom = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        rePermutationNonDescending(N, M, rCom, sb);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
