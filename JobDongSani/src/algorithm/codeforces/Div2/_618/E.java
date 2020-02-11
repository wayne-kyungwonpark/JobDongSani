package algorithm.codeforces.Div2._618;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 현재 로직
 * 1. seq의 길이가 n일 경우, n - 1번째서부터 0까지 내려가며 다음 사항을 확인한다. (시작 index : 0)
 *    - seq의 처음 index부터 n - 1 번째까지의 원소 평균을 계산하여 minMean으로 지정한다. endIndex를 n - 1로 지정한다.
 *    - seq의 처음 index부터 j (< n - 1) 번째까지의 원소 평균을 계산하여 minMean보다 작다면 새로운 minMean으로 지정하고, endIndex를 j로 지정한다.
 * 2. endIndex + 1번째부터 n - 1번째까지의 subseq를 대상으로 1.을 반복한다.
 * -> Time Limit에 걸림 (예시: 1 2 3 4 5 ... ), 걸린 예시의 경우 1.의 로직이 n + (n - 1) + (n - 2) + ... 반복되므로 O(n^2)
 *
 * 오름차순(같아도 됨, ex. 1 1 2 2 2 3 ...)으로 있는 subseq에 대해서는 굳이 sortLexicographically() 로직을 태울 필요가 없음
 * 오름차순으로 되는 subseq의 index를 알고 있다가, 해당 부분이 아닌 부분에서만 로직 처리하면 될 듯
 * -> 반례가 있음.. 1 2 3 10 1 2 의 경우, 1 2 3 10 그대로 두고 그 이후인 1 2에서만 조절해봐야 의미가 없음
 *    정답은 1 2 3 4.3 4.3 4.3인데, 위의 로직대로 처리할 경우 1 2 3 10 1.5 1.5 가 나올 것
 *
 * 다른 로직:
 *   seq의 뒤에서부터 시작하여 평균값이 seq의 앞 원소보다 클 경우 stop
 *   -> 반례 존재: 1 10 3 10 1 2 의 경우, 위의 로직대로 처리할 경우 1 6.5 6.5 4.3 4.3 4.3
 */
public class E {
    private static int n = 0;
    private static int[] arr = null;
    private static long[] partialSum = null;

    private static int ascendingStart = 0;
    private static List<Integer> ascendingStarts = null;
    private static List<Integer> ascendingEnds = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        ascendingStarts = new ArrayList<>();
        ascendingEnds = new ArrayList<>();

        n = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        arr = new int[n];
        partialSum = new long[n];

        ascendingStart = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
//            if(i != 0 && arr[i - 1] > arr[i]){
//                if(ascendingStart != i)
//                ascendingStarts.add(ascendingStart);
//                ascendingEnds.add(i - 1);
//                ascendingStart = i;
//            }
            if(i != 0){
                partialSum[i] = (long) arr[i] + partialSum[i - 1];
            }else{
                partialSum[i] = arr[i];
            }

        }

        double[] newArr = new double[n];

        sortLexicographically(newArr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            sb.append(String.format("%.9f", newArr[i])).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void sortLexicographically(double[] newArr, int startIndex, int endIndex) {
        double minMean = 0;
        long minus = 0;
        int index = endIndex;
        if(startIndex != 0){
            minus = partialSum[startIndex - 1];
        }
        for (int i = endIndex; i >= startIndex; i--) {
            double mean = (double) (partialSum[i] - minus) / (i - startIndex + 1);
            if(Double.compare(minMean, 0) == 0 || Double.compare(minMean, mean) > 0){
                minMean = mean;
                index = i;
            }
        }
        for (int i = startIndex; i <= index; i++) {
            newArr[i] = minMean;
        }
        if(index < endIndex){
            sortLexicographically(newArr, index + 1, endIndex);
        }
    }
}
