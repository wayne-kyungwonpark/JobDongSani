package algorithm.baekjoon.numbersystem;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _8741_BinarySum {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append(1);
        for (int i = 0; i < k - 1; i++) {
            sb1.append(1); sb2.append(0);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb1.toString() + sb2.toString());
        bw.flush();
        bw.close();
        scn.close();
    }
}
