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
            int val = k / 4;
            int mod = k % 4;
            if(mod == 0){
                sb.append(0).append("\n");
            }else{
                val++;
                sb.append(2).append("\n");
            }
            int index = 0;
            for (int j = 0; j < n; j++) {
                if(index < n){
                    for (int l = 0; l < index; l++) {
                        sb.append(0);
                    }
                    for (int l = index; l < val; l++) {
                        sb.append(1);
                    }
                    for (int l = 0; l < n - val; l++) {
                        sb.append(0);
                    }
                }else{
                    int left = index % n;
                    for (int l = 0; l < index; l++) {
                        sb.append(1);
                    }
                    for (int l = index; l < val + 1; l++) {
                        sb.append(0);
                    }
                    for (int l = 0; l < n - (val + 1); l++) {
                        sb.append(1);
                    }
                }
                sb.append("\n");
                index++;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
