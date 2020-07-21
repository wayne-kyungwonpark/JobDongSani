package algorithm.codeforces.Div2._623;

import java.io.*;
import java.util.Arrays;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            boolean[] check = new boolean[n * 2 + 1];
            String[] strArr = br.readLine().split(" ");
            int[] bArr = new int[n];
            for (int j = 0; j < n; j++) {
                bArr[j] = Integer.parseInt(strArr[j]);
                check[bArr[j]] = true;
            }
            boolean isPossible = true;

            int[] aArr = new int[2 * n];
            for (int j = 0; j < n; j++) {
                aArr[j * 2] = bArr[j];
                int tmp = aArr[j * 2];
                do{
                    tmp++;
                    if(tmp > n * 2){
                        isPossible = false;
                        break;
                    }
                } while(check[tmp]);
                if(tmp > n * 2){
                    isPossible = false;
                    break;
                }
                aArr[j * 2 + 1] = tmp;
                check[tmp] = true;
            }

            if(isPossible){
                for (int j = 0; j < n * 2; j++) {
                    sb.append(aArr[j]).append(" ");
                }
            }else{
                sb.append(-1);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
