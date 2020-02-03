package algorithm.codeforces.Div3._615;

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
            int c = Integer.parseInt(strArr[2]);
            int n = Integer.parseInt(strArr[3]);
            int sum = a + b + c + n;
            int sumDiv3 = sum / 3;
            if(sum % 3 == 0 && a <= sumDiv3 && b <= sumDiv3 && c <= sumDiv3){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
