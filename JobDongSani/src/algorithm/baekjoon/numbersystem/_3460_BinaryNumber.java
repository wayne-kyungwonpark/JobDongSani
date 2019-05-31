package algorithm.baekjoon.numbersystem;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _3460_BinaryNumber {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int testNum = scn.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testNum; i++) {
            int num = scn.nextInt();
            int compare = 1;
            for (int j = 0; j < 20; j++) {
                if((compare & num) == compare){
                    sb.append(j).append(" ");
                }
                compare = compare << 1;
            }
            if(i != testNum - 1){
                sb.append("\n");
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        scn.close();
    }
}
