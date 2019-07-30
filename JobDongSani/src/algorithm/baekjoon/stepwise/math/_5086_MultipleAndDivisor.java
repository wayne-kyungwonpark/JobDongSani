package algorithm.baekjoon.stepwise.math;

import java.io.*;

public class _5086_MultipleAndDivisor {
    private static final String DIVISOR = "factor";
    private static final String MULTIPLE = "multiple";
    private static final String NEITHER = "neither";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        StringBuilder sb = new StringBuilder();
        while((str = br.readLine()) != null){
            String[] strArr = str.split(" ");
            int first = Integer.parseInt(strArr[0]), second = Integer.parseInt(strArr[1]);
            if(first == 0 && second == 0){
                break;
            }else{
                if(second % first == 0){
                    sb.append(DIVISOR);
                }else if(first % second == 0){
                    sb.append(MULTIPLE);
                }else{
                    sb.append(NEITHER);
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
