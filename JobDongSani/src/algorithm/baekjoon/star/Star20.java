package algorithm.baekjoon.star;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Star20 {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        StringBuilder sb = new StringBuilder();
        StringBuilder sbNew = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append("*").append(" ");
        }
        for (int i = 0; i < num; i++) {
            if(i % 2 != 0){
                sbNew.append(" ");
            }
            sbNew.append(sb.toString()).append("\n");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sbNew.toString());
        bw.flush();
        bw.close();
        scn.close();
    }
}
