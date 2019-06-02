package algorithm.baekjoon.star;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Star17 {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        StringBuilder sb = new StringBuilder();
        int firstSpace = num - 1;
        int secondSpace = 1;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < firstSpace; j++) {
                sb.append(" ");
            }
            firstSpace--;
            sb.append("*");
            if(i != 0 && i != num - 1){
                for (int j = 0; j < secondSpace; j++) {
                    sb.append(" ");
                }
                secondSpace += 2;
                sb.append("*");
            }else if(i == num - 1){
                for (int j = 0; j < 2 * i; j++) {
                    sb.append("*");
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
