package algorithm.baekjoon.stepwise.sort;

import java.io.*;

public class _10814_AgeOrder {
    private static int N = 0;
    private static String[][] coordinates = null;
    private static String[][] tmp = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int nFreq = 0;
        while((str = br.readLine()) != null){
            if(N == 0){
                N = Integer.parseInt(str);
                coordinates = new String[N][2];
                tmp = new String[N][2];
            }else{
                String[] strArr = str.split(" ");
                coordinates[nFreq][0] = strArr[0]; coordinates[nFreq][1] = strArr[1];
                nFreq++;
                if(N == nFreq){
                    break;
                }
            }
        }

        merge(0, N - 1, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(coordinates[i][0]).append(" ").append(coordinates[i][1]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void merge(int start, int end, int index){
        if(start >= end){
            return;
        }
        if(start == end - 1){
            if(Integer.parseInt(coordinates[start][index]) > Integer.parseInt(coordinates[end][index])){
                String tmpIndex = coordinates[start][index], tmpNonIndex = coordinates[start][1 - index];
                coordinates[start][index] = coordinates[end][index];
                coordinates[start][1 - index] = coordinates[end][1 - index];
                coordinates[end][index] = tmpIndex;
                coordinates[end][1 - index] = tmpNonIndex;
            }
            return;
        }
        int mid = (start + end) / 2;
        merge(start, mid, index);
        merge(mid + 1, end, index);
        int left = start, right = mid + 1, k = start;
        while(left <= mid && right <= end){
            if(Integer.parseInt(coordinates[left][index]) <= Integer.parseInt(coordinates[right][index])){
                tmp[k][index] = coordinates[left][index];
                tmp[k][1 - index] = coordinates[left][1 - index];
                left++;
            }else{
                tmp[k][index] = coordinates[right][index];
                tmp[k][1 - index] = coordinates[right][1 - index];
                right++;
            }
            k++;
        }
        if(left > mid){
            for (int i = right; i <= end; i++) {
                tmp[k][index] = coordinates[i][index];
                tmp[k][1 - index] = coordinates[i][1 - index];
                k++;
            }
        }else{
            for (int i = left; i <= mid; i++) {
                tmp[k][index] = coordinates[i][index];
                tmp[k][1 - index] = coordinates[i][1 - index];
                k++;
            }
        }
        for (int i = start; i <= end; i++) {
            coordinates[i][index] = tmp[i][index];
            coordinates[i][1 - index] = tmp[i][1 - index];
        }
    }
}
