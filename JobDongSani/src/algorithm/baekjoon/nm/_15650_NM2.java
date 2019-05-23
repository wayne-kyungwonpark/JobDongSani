package algorithm.baekjoon.nm;

import java.io.*;
import java.util.LinkedList;

public class _15650_NM2 {
    private static void permutationAscending(int N, int M, LinkedList<Integer> rCom, int[] check, StringBuilder sb){
        if(rCom.size() == M){
            // sb 저장
            for(int i : rCom){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if((rCom.isEmpty() || rCom.getLast() < i) && check[i] == 0){
                check[i] = 1;
                rCom.add(i);
                permutationAscending(N, M, rCom, check, sb);
                check[i] = 0;
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
        int[] check = new int[N + 1];
        StringBuilder sb = new StringBuilder();
        permutationAscending(N, M, rCom, check, sb);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
