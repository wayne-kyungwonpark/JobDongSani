package algorithm.baekjoon.stepwise.loop;

import java.io.*;

public class _10952_APlusB5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        StringBuilder sb = new StringBuilder();
        while((str = br.readLine()) != null){
            String[] strArr = str.split(" ");
            int a = Integer.parseInt(strArr[0]), b = Integer.parseInt(strArr[1]);
            if(a == 0 && b == 0){
                break;
            }else{
                sb.append(Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[1]));
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
