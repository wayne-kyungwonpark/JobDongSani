package algorithm.baekjoon.stepwise.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1037_Divisor {
    private static int N = 0;
    private static int[] divisors = null;
    private static int[] tmps = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            if(N == 0){
                N = Integer.parseInt(str);
                divisors = new int[N];
                tmps = new int[N];
            }else{
                String[] strArr = str.split(" ");
                for (int i = 0; i < N; i++) {
                    divisors[i] = Integer.parseInt(strArr[i]);
                }
                break;
            }
        }
        merge(0, N - 1);
        System.out.println(divisors[0] * divisors[N - 1]);
    }

    private static void merge(int start, int end) {
        if(start >= end){
            return;
        }
        if(start == end - 1){
            if(divisors[start] > divisors[end]){
                int tmp = divisors[start];
                divisors[start] = divisors[end];
                divisors[end] = tmp;
            }
            return;
        }
        int mid = (start + end) / 2;
        merge(start, mid);
        merge(mid + 1, end);
        int left = start, right = mid + 1, index = start;
        while(left <= mid && right <= end){
            if(divisors[left] <= divisors[right]){
                tmps[index++] = divisors[left++];
            }else{
                tmps[index++] = divisors[right++];
            }
        }
        if(left > mid){
            for (int i = right; i <= end; i++) {
                tmps[index++] = divisors[i];
            }
        }else {
            for (int i = left; i <= mid; i++) {
                tmps[index++] = divisors[i];
            }
        }
        for (int i = start; i <= end; i++) {
            divisors[i] = tmps[i];
        }
    }
}
