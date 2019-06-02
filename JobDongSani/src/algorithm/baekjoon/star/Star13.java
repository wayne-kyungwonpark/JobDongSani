package algorithm.baekjoon.star;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Star13 {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for (int i = num - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
