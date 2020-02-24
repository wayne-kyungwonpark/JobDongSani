package algorithm.codeforces.Div2._622;

import java.io.*;

public class C {
    private static int n = 0;
    private static int[] mArr = null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        mArr = new int[n];
        String[] strArr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            mArr[i] = Integer.parseInt(strArr[i]);
        }
        int[] optimum = findMax();
        for (int i = 0; i < n; i++) {
            sb.append(optimum[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] findMax() {
        long maxSum = 0;
        int realMaxIndex = 0;
        for (int maxIndex = 0; maxIndex < n; maxIndex++) {
            long sum = mArr[maxIndex];
            int standard = mArr[maxIndex];
            for (int i = maxIndex - 1; i >= 0; i--) {
                standard = Math.min(standard, mArr[i]);
                sum += standard;
            }
            standard = mArr[maxIndex];
            for (int i = maxIndex + 1; i < n; i++) {
                standard = Math.min(standard, mArr[i]);
                sum += standard;
            }
            if(maxSum < sum){
                maxSum = sum;
                realMaxIndex = maxIndex;
            }
        }

        int[] candidate = new int[n];
        candidate[realMaxIndex] = mArr[realMaxIndex];
        for (int i = realMaxIndex - 1; i >= 0; i--) {
            candidate[i] = Math.min(candidate[i + 1], mArr[i]);
        }
        for (int i = realMaxIndex + 1; i < n; i++) {
            candidate[i] = Math.min(candidate[i - 1], mArr[i]);
        }
        return candidate;
    }
}
