package algorithm.baekjoon.stepwise.loop;

import java.io.*;

public class _10951_APlusB4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        StringBuilder sb = new StringBuilder();
        while((str = br.readLine()) != null){
            String[] strArr = str.split(" ");
            int a = Integer.parseInt(strArr[0]), b = Integer.parseInt(strArr[1]);
            bw.write(String.valueOf(a + b));
            bw.write("\n");
            bw.flush();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
