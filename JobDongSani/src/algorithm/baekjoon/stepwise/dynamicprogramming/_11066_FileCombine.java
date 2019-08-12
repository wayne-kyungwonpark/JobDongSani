package algorithm.baekjoon.stepwise.dynamicprogramming;

import java.io.*;

public class _11066_FileCombine {
    private static int N = 0;
    private static int[] files = null;
    private static int[] tmps = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int testNum = 0, testFreq = 0;
        StringBuilder sb = new StringBuilder();
        while((str = br.readLine()) != null){
            if(testNum == 0){
                testNum = Integer.parseInt(str);
            }else{
                if(N == 0){
                    N = Integer.parseInt(str);
                    files = new int[N];
                    tmps = new int[N];
                }else{
                    String[] strArr = str.split(" ");
                    for (int i = 0; i < N; i++) {
                        files[i] = Integer.parseInt(strArr[i]);
                    }
                    int minCost = doSomething();
                    sb.append(minCost);
                    testFreq++;
                    if(testNum == testFreq){
                        break;
                    }else{
                        N = 0;
                        files = null;
                        tmps = null;
                        sb.append("\n");
                    }
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int doSomething() {
        int minCost = 0;
        merge(0, N - 1);
        int[] sums = new int[N];
        int index = 0;
        while(index < N - 1){
            sums[index] = files[index] + files[index + 1];
            if(index != N - 2){
                for (int i = index + 2; i < N; i++) {
                    if(sums[index] <= files[i]){
                        int tmp = files[i - 1];
                        files[i - 1] = sums[index];
                        for (int j = index + 1; j < i - 1; j++) {
                            if(j == i - 2){
                                files[j] = tmp;
                            }else{
                                files[j] = files[j + 1];
                            }
                        }
                        break;
                    }
                    if(i == N - 1){
                        for (int j = index + 1; j < N; j++) {
                            if(j == N - 1){
                                files[j] = sums[index];
                            }else{
                                files[j] = files[j + 1];
                            }
                        }
                    }
                }
            }
            index++;
        }
        for (int i = 0; i < N - 1; i++) {
            minCost += sums[i];
        }
        return minCost;
    }

    private static void merge(int start, int end) {
        if(start >= end){
            return;
        }
        if(start == end - 1){
            if(files[start] > files[end]){
                int tmp = files[start];
                files[start] = files[end];
                files[end] = tmp;
            }
            return;
        }
        int mid = (start + end) / 2;
        merge(start, mid);
        merge(mid + 1, end);
        int left = start, right = mid + 1, index = start;
        while(left <= mid && right <= end){
            if(files[left] <= files[right]){
                tmps[index++] = files[left++];
            }else{
                tmps[index++] = files[right++];
            }
        }
        if(left > mid){
            for (int i = right; i <= end; i++) {
                tmps[index++] = files[i];
            }
        }else {
            for (int i = left; i <= mid; i++) {
                tmps[index++] = files[i];
            }
        }
        for (int i = start; i <= end; i++) {
            files[i] = tmps[i];
        }
    }
}
