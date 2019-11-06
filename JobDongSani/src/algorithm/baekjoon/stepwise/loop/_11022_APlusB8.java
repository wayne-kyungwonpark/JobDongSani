package algorithm.baekjoon.stepwise.loop;

import java.io.*;

public class _11022_APlusB8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int testNum = 0, testFreq = 0;
        StringBuilder sb = new StringBuilder();
        while((str = br.readLine()) != null){
            if (testNum == 0) {
                testNum = Integer.parseInt(str);
            }else{
                testFreq++;
                String[] strArr = str.split(" ");
                int a = Integer.parseInt(strArr[0]), b = Integer.parseInt(strArr[1]);
                sb.append("Case #").append(testFreq).append(": ").append(a).append(" + ").append(b).append(" = ").append(a + b);
                if(testFreq == testNum){
                    break;
                }else{
                    sb.append("\n");
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
