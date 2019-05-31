package algorithm.baekjoon.numbersystem;

import java.io.*;
import java.util.Scanner;

public class _5692_FactorialSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        int[] factorial = {1, 2, 6, 24, 120};

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(!str.equals("0")){
            char[] chArr = str.toCharArray();
            int num = 0;
            for (int i = chArr.length - 1; i >= 0; i--) {
                num += factorial[i] * Integer.parseInt(String.valueOf(chArr[chArr.length - 1 - i]));
            }
            sb.append(num).append("\n");
            bw.write(sb.toString());
            bw.flush();
            sb = new StringBuilder();
            str = br.readLine();
        }
        bw.close();
        br.close();
    }
}
