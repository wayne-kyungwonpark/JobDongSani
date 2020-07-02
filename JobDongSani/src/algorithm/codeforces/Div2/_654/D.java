package algorithm.codeforces.Div2._654;

import java.io.*;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String[] strArr = br.readLine().split(" ");
            int n = Integer.parseInt(strArr[0]);
            int k = Integer.parseInt(strArr[1]);
            int val = k / n;
            int mod = k % n;
            if(mod == 0){
                sb.append(0).append("\n");
            }else{
                sb.append(2).append("\n");
            }
            for (int j = 0; j < n; j++) {
                int add = (mod != 0)? (mod > j)? 1 : 0 : 0;
                if(j + val < n) {
                    for (int l = 0; l < j; l++) {
                        sb.append(0);
                    }
                    for (int l = j; l < j + val + add; l++) {
                        sb.append(1);
                    }
                    for (int l = 0; l < n - (j + val + add); l++) {
                        sb.append(0);
                    }
                }
                else{
                    int left = (j + val + add) % n;
                    for (int l = 0; l < left; l++) {
                        sb.append(1);
                    }
                    for (int l = left; l < j; l++) {
                        sb.append(0);
                    }
                    for (int l = j; l < n; l++) {
                        sb.append(1);
                    }
                }
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
