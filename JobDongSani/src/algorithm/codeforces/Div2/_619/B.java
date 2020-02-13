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
        List<Integer> kCandidates = new ArrayList<>();
        int prevNonMinusOne = -1;
        // k가 될 수 있느 후보군을 모음
        for (int i = 0; i < strArr.length; i++) {
            if(i == 0){
                if(arr[i] != -1){
                    prevNonMinusOne = arr[i];
                }
            }else if(i == strArr.length - 1){
                if(prevNonMinusOne == -1){
                    if(arr[i] == -1){
                        kCandidates.add(0);
                    }else{
                        kCandidates.add(arr[i]);
                    }
                }else{
                    if(arr[i] == -1){
                        kCandidates.add(prevNonMinusOne);
                    }else{
                        int sum = prevNonMinusOne + arr[i];
                        if(sum % 2 != 0){
                            kCandidates.add(sum / 2 + 1);
                        }
                        kCandidates.add(sum / 2);
                    }
                }
            }else{
                if(arr[i] != -1){
                    if(prevNonMinusOne == -1){
                        prevNonMinusOne = arr[i];
                        kCandidates.add(arr[i]);
                    }else{
                        int sum = prevNonMinusOne + arr[i];
                        if(sum % 2 != 0){
                            kCandidates.add(sum / 2 + 1);
                        }
                        kCandidates.add(sum / 2);
                        prevNonMinusOne = arr[i];
                    }
                }
            }
        }

        // k후보군 별로 maxAbsDiff를 찾으며, 그 중 min 값을 뽑는다.
        int minMaxAbsDiff = Integer.MAX_VALUE;
        int k = 0;
        for (int i = 0; i < kCandidates.size(); i++) {
            int kCandidate = kCandidates.get(i);
            int maxAbsDiff = -1;
            for (int j = 1; j < strArr.length; j++) {
                int tmp1 = (arr[j] == -1)? kCandidate : arr[j];
                int tmp2 = (arr[j - 1] == -1)? kCandidate : arr[j - 1];
                int absDiff = Math.abs(tmp1 - tmp2);
                if(absDiff > maxAbsDiff){
                    maxAbsDiff = absDiff;
                }
            }
            if(minMaxAbsDiff > maxAbsDiff){
                minMaxAbsDiff = maxAbsDiff;
                k = kCandidate;
            }
        }
        return minMaxAbsDiff + " " + k;
    }
}
