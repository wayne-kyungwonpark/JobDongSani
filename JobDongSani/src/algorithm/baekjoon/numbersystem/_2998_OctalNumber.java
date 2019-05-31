package algorithm.baekjoon.numbersystem;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _2998_OctalNumber {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int r = str.length() % 3;
        int p = str.length() / 3;
        if(r == 1){
            str = "00" + str;
            p++;
        }else if(r == 2){
            str = "0" + str;
            p++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p; i++) {
            String tmp = null;
            if(i != p - 1){
                tmp = str.substring(i * 3, (i + 1) * 3);
            }else{
                tmp = str.substring(i * 3);
            }
            switch (tmp){
                case "000":
                    sb.append("0");
                    break;
                case "001":
                    sb.append("1");
                    break;
                case "010":
                    sb.append("2");
                    break;
                case "011":
                    sb.append("3");
                    break;
                case "100":
                    sb.append("4");
                    break;
                case "101":
                    sb.append("5");
                    break;
                case "110":
                    sb.append("6");
                    break;
                case "111":
                    sb.append("7");
                    break;
                default:
                    break;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        scn.close();
    }
}
