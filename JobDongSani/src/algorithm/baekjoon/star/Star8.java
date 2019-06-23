package algorithm.baekjoon.star;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Star8 {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int space = num - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            for (int j = 0; j < space * 2; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
            space--;
        }
        space = 1;
        for (int i = num - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            for (int j = 0; j < space * 2; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
            space++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
