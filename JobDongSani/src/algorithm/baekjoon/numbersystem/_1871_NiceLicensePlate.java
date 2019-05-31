package algorithm.baekjoon.numbersystem;

import java.io.*;

public class _1871_NiceLicensePlate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testNum; i++) {
            String[] strArr = br.readLine().split("-");
            int first = getFirstPart(strArr[0]);
            if(Math.abs(first - Integer.parseInt(strArr[1])) <= 100){
                sb.append("nice");
            }else{
                sb.append("not nice");
            }
            if(i != testNum - 1){
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getFirstPart(String first){
        int part = 0;
        int exp = 1;
        char A = 'A';
        char[] chArr = first.toCharArray();
        for (int i = chArr.length - 1; i >= 0; i--) {
            part += (chArr[i] - A) * exp;
            exp *= 26;
        }
        return part;
    }
}
