package algorithm.codeforces.Div2._623;

import java.io.*;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] strArr = br.readLine().split(" ");
            int a = Integer.parseInt(strArr[0]);
            int b = Integer.parseInt(strArr[1]);
            int x = Integer.parseInt(strArr[2]);
            int y = Integer.parseInt(strArr[3]);
            sb.append(findMaxWindow(a, b, x, y)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int findMaxWindow(int a, int b, int x, int y) {
        int max = 0;
        if(x != 0){
            max = Math.max(max, b * x);
        }
        if(x != a - 1){
            max = Math.max(max, b * (a - 1 - x));
        }
        if(y != 0){
            max = Math.max(max, a * y);
        }
        if(y != b - 1){
            max = Math.max(max, a * (b - 1 - y));
        }
        return max;
    }
}
