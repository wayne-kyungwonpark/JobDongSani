package algorithm.baekjoon.stepwise.loop;

import java.io.*;

public class _10950_APlusB3 {
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
                sb.append(Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[1]));
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
