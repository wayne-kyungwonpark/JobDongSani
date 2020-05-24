package algorithm.baekjoon.stepwise.sort;

import java.io.*;

public class _2751_NumberSort2 {
    private static int N = 0;
    private static int[] nums = null;
    private static int[] tmps = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int nFreq = 0;
        while((str = br.readLine()) != null){
            if(N == 0){
                N = Integer.parseInt(str);
                nums = new int[N];
                tmps = new int[N];
            }else{
                nums[nFreq] = Integer.parseInt(str);
                nFreq++;
                if(nFreq == N){
                    break;
                }
            }
        }
        merge(0, N - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(nums[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void merge(int start, int end){
        if(start >= end){
            return;
        }
        if(start == end - 1){
            if(nums[start] > nums[end]){
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
            }
            return;
        }
        int mid = (start + end) / 2;
        merge(start, mid);
        merge(mid + 1, end);
        int index = start, left = start, right = mid + 1;
        while(left <= mid && right <= end){
            if(nums[left] <= nums[right]){
                tmps[index++] = nums[left++];
            }else{
                tmps[index++] = nums[right++];
            }
        }
        if(left > mid){
            for (int i = right; i <= end; i++) {
                tmps[index++] = nums[i];
            }
        }else{
            for (int i = left; i <= mid; i++) {
                tmps[index++] = nums[i];
            }
        }
        for (int i = start; i <= end; i++) {
            nums[i] = tmps[i];
        }
    }
}
