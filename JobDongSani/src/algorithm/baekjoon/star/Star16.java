package algorithm.baekjoon.star;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Star16 {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        StringBuilder sb = new StringBuilder();
        int space = num - 1;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < space; j++) {
                sb.append(" ");
            }
            space--;
            for (int j = 0; j <= i; j++) {
                sb.append("*");
                if(j != i){
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
