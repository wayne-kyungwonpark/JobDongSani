package algorithm.baekjoon.nm;

import java.io.*;
import java.util.LinkedList;

public class _15649_NM1 {
    private static void rePermutation(int N, int M, LinkedList<Integer> rCom, int[] check, StringBuilder sb) throws IOException {
        if(rCom.size() == M){
            for(int i : rCom){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(check[i] == 0){
                check[i] = 1;
                rCom.add(i);
                rePermutation(N, M, rCom, check, sb);
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
        int[] check = new int[N + 1];
        LinkedList<Integer> rCom = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        rePermutation(N, M, rCom, check, sb);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
