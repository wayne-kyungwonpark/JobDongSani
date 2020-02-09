package algorithm.codeforces.Div2._618;

import java.io.*;

/**
 * 만약 이거 제출했는데 시간 초과로 안되었다면.. partialSum[j] - partialsum[i] 를 모두 기록해놓은 2차원 array를 만들어서 dp 사용해야 할 듯
 */
public class E {
    private static int n = 0;
    private static int[] arr = null;
    private static int[] partialSum = null;

    private static int startIndex = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        arr = new int[n];
        partialSum = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
            if(i != 0){
                partialSum[i] = arr[i] + partialSum[i - 1];
            }else{
                partialSum[i] = arr[i];
            }

        }

        double[] newArr = new double[n];

        sortLexicographically(newArr, startIndex);

        for (int i = 0; i < n; i++) {
            sb.append(String.format("%.9f", newArr[i])).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void sortLexicographically(double[] newArr, int startIndex) {
        double minMean = 0;
        int minus = 0;
        int index = n - 1;
        if(startIndex != 0){
            minus = partialSum[startIndex - 1];
        }
        for (int i = n - 1; i >= startIndex; i--) {
            double mean = (double) (partialSum[i] - minus) / (i - startIndex + 1);
            if(Double.compare(minMean, 0) == 0 || Double.compare(minMean, mean) > 0){
                minMean = mean;
                index = i;
            }
        }
        for (int i = startIndex; i <= index; i++) {
            newArr[i] = minMean;
        }
        if(index < n - 1){
            sortLexicographically(newArr, index + 1);
        }
    }
}
