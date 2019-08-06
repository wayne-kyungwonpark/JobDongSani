package algorithm.baekjoon.stepwise.greedyalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11399_ATM {
    private static int N = 0;
    private static int[] time = null;
    private static int[] tmps = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            if (N == 0) {
                N = Integer.parseInt(str);
                time = new int[N];
                tmps = new int[N];
            }else{
                String[] strArr = str.split(" ");
                for (int i = 0; i < N; i++) {
                    time[i] = Integer.parseInt(strArr[i]);
                }
                break;
            }
        }
        merge(0, N - 1);
        int minTime = 0;
        for (int i = N - 1; i >= 0; i--) {
            minTime += (time[i] * (N - i));
        }
        System.out.println(minTime);
    }

    private static void merge(int start, int end) {
        if(start >= end){
            return;
        }
        if(start == end - 1){
            if(time[start] > time[end]){
                int tmp = time[start];
                time[start] = time[end];
                time[end] = tmp;
            }
            return;
        }
        int mid = (start + end) / 2;
        merge(start, mid);
        merge(mid + 1, end);
        int left = start, right = mid + 1, index = start;
        while(left <= mid && right <= end){
            if(time[left] <= time[right]){
                tmps[index++] = time[left++];
            }else{
                tmps[index++] = time[right++];
            }
        }
        if(left > mid){
            for (int i = right; i <= end; i++) {
                tmps[index++] = time[i];
            }
        }else {
            for (int i = left; i <= mid; i++) {
                tmps[index++] = time[i];
            }
        }
        for (int i = start; i <= end; i++) {
            time[i] = tmps[i];
        }
    }
}
