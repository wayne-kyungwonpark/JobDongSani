package algorithm.codeforces.Div2._619;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class B {
    private static int n = 0;
    private static int[] arr = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            String[] strArr = br.readLine().split(" ");
            sb.append(findMandK(strArr)).append("\n");
            n = 0;
            arr = null;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static String findMandK(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int maxAbsDiff = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == -1){
                if(i > 0 && arr[i - 1] != -1){
                    minValue = Math.min(minValue, arr[i - 1]);
                    maxValue = Math.max(maxValue, arr[i - 1]);
                }
                while(i < arr.length && arr[i] == -1){
                    i++;
                }
                if(i < arr.length){
                    minValue = Math.min(minValue, arr[i]);
                    maxValue = Math.max(maxValue, arr[i]);
                }else{
                    break;
                }
            }else{
                if(i > 0 && arr[i - 1] != -1){
                    maxAbsDiff = Math.max(maxAbsDiff, Math.abs(arr[i] - arr[i - 1]));
                }
            }
        }

        if(minValue == Integer.MAX_VALUE){
            return "0 0";
        }

        int absDiffCandidate = (int) Math.ceil((maxValue - minValue) * 0.5);
        int minMaxAbsDiff = Math.max(maxAbsDiff, absDiffCandidate);

        return minMaxAbsDiff + " " + (minValue + absDiffCandidate);
    }
}
