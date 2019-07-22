package algorithm.baekjoon.stepwise.binarysearch;

import java.io.*;

public class _1920_FindNumber {
    private static int N = 0, M = 0;
    private static int[] nums = null;
    private static int[] tmp = null;
    private static int[] candidates = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while((str = br.readLine()) != null){
            if(N == 0){
                N = Integer.parseInt(str);
            }else{
                if(M == 0){
                    if(nums == null){
                        nums = new int[N];
                        tmp = new int[N];
                        String[] strArr = str.split(" ");
                        for (int i = 0; i < N; i++) {
                            nums[i] = Integer.parseInt(strArr[i]);
                        }
                    }else{
                        M = Integer.parseInt(str);
                    }
                }else{
                    String[] strArr = str.split(" ");
                    candidates = new int[M];
                    for (int i = 0; i < M; i++) {
                        candidates[i] = Integer.parseInt(strArr[i]);
                    }
                    break;
                }
            }
        }
        merge(0, N - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(isIncluded(candidates[i])).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int isIncluded(int candidate) {
        if(binarySearch(candidate, 0, N - 1)){
            return 1;
        }
        return 0;
    }

    private static boolean binarySearch(int candidate, int start, int end) {
        if(start > end){
            return false;
        }
        if(start == end){
            if(nums[start] == candidate){
                return true;
            }else{
                return false;
            }
        }
        int mid = (start + end) / 2;
        if(candidate > nums[mid]){
            return binarySearch(candidate, mid + 1, end);
        }else if(candidate == nums[mid]){
            return true;
        }else{
            return binarySearch(candidate, start, mid - 1);
        }
    }

    private static void merge(int start, int end) {
        if(start >= end){
            return;
        }
        if(start == end - 1){
            if(nums[start] > nums[end]){
                int tmpNum = nums[start];
                nums[start] = nums[end];
                nums[end] = tmpNum;
            }
            return;
        }
        int mid = (start + end) / 2;
        merge(start, mid);
        merge(mid + 1, end);
        int index = start;
        int left = start, right = mid + 1;
        while(left <= mid && right <= end){
            if(nums[left] <= nums[right]){
                tmp[index++] = nums[left++];
            }else{
                tmp[index++] = nums[right++];
            }
        }
        if(left > mid){
            for (int i = right; i <= end; i++) {
                tmp[index++] = nums[i];
            }
        }else{
            for (int i = left; i <= mid; i++) {
                tmp[index++] = nums[i];
            }
        }
        for (int i = start; i <= end; i++) {
            nums[i] = tmp[i];
        }
    }
}
