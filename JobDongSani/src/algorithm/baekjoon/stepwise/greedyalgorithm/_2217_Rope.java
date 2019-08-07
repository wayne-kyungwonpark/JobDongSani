package algorithm.baekjoon.stepwise.greedyalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2217_Rope {
    private static int N = 0;
    private static int[] weights = null;
    private static int[] tmps = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nFreq = 0;
        String str;
        while((str = br.readLine()) != null){
            if(N == 0){
                N = Integer.parseInt(str);
                weights = new int[N];
                tmps = new int[N];
            }else{
                weights[nFreq] = Integer.parseInt(str);
                nFreq++;
                if(nFreq == N){
                    break;
                }
            }
        }
        merge(0, N - 1);
        int maxWeight = 0;
        for (int i = N - 1; i >= 0; i--) {
            int weight = weights[i] * (N - i);
            if(weight > maxWeight){
                maxWeight = weight;
            }
        }
        System.out.println(maxWeight);
    }

    private static void merge(int start, int end) {
        if(start >= end){
            return;
        }
        if(start == end - 1){
            if(weights[start] > weights[end]){
                int tmp = weights[start];
                weights[start] = weights[end];
                weights[end] = tmp;
            }
            return;
        }
        int mid = (start + end) / 2;
        merge(start, mid);
        merge(mid + 1, end);
        int left = start, right = mid + 1, index = start;
        while(left <= mid && right <= end){
            if(weights[left] <= weights[right]){
                tmps[index++] = weights[left++];
            }else{
                tmps[index++] = weights[right++];
            }
        }
        if(left > mid){
            for (int i = right; i <= end; i++) {
                tmps[index++] = weights[i];
            }
        }else {
            for (int i = left; i <= mid; i++) {
                tmps[index++] = weights[i];
            }
        }
        for (int i = start; i <= end; i++) {
            weights[i] = tmps[i];
        }
    }
}
