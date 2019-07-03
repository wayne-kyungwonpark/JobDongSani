package algorithm.baekjoon.stepwise.function;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _11729_Hanoi {
    private static int num = 0;
    private static int K = 0;
    private static StringBuilder sb = new StringBuilder();

    private static void doHanoi(int level, int start, int mid, int end){
        if(level == 1){
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }
        doHanoi(level - 1, start, end, mid);
        sb.append(start).append(" ").append(end).append("\n");
        doHanoi(level - 1, mid, start, end);
    }

    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        num = scn.nextInt();
        K = (int) Math.pow(2, num) - 1;
        sb.append(K).append("\n");
        doHanoi(num, 1, 2, 3);
        bw.write(sb.toString());
        bw.flush();
        scn.close();
        bw.close();
    }
}
