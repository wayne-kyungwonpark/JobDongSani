package algorithm.baekjoon.stepwise.array;

import java.io.*;

public class _10818_MinMax {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int num = 0, min = 0, max = 0;
        while((str = br.readLine()) != null){
            if(num == 0){
                num = Integer.parseInt(str);
            }else{
                String[] strArr = str.split(" ");
                int init = Integer.parseInt(strArr[0]);
                min = init; max = init;
                for (int i = 1; i < num; i++) {
                    int tmp = Integer.parseInt(strArr[i]);
                    if(tmp > max){
                        max = tmp;
                    }
                    if(tmp < min){
                        min = tmp;
                    }
                }
                break;
            }
        }
        bw.write(String.valueOf(min) + " " + String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
}
