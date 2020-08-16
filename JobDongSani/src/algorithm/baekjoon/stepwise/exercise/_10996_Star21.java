package algorithm.baekjoon.stepwise.exercise;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _10996_Star21 {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = scn.nextInt();
        if(num == 1){
            System.out.println("*");
            return;
        }
        int half = num / 2;
        StringBuilder sb = new StringBuilder();
        if(num % 2 == 0){
            for (int i = 0; i < num * 2; i++) {
                if(i % 2 == 0){
                    for (int j = 0; j < half; j++) {
                        sb.append("* ");
                    }
                }else{
                    for (int j = 0; j < half; j++) {
                        sb.append(" *");
                    }
                }
                sb.append("\n");
            }
        }else{
            for (int i = 0; i < num * 2; i++) {
                if(i % 2 == 0){
                    for (int j = 0; j < half + 1; j++) {
                        sb.append("* ");
                    }
                }else{
                    for (int j = 0; j < half; j++) {
                        sb.append(" *");
                    }
                }
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        scn.close();
    }
}
