package algorithm.baekjoon.stepwise.binarysearch;

import java.io.*;

public class _10815_NumberCard {
    private static int N = 0, M = 0;
    private static int[] taken = null, guess = null, newArr = null;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while((str = br.readLine()) != null){
            if(N == 0){
                N = Integer.parseInt(str);
            }else{
                if(taken == null){
                    taken = new int[N];
                    newArr = new int[N];
                    String[] strArr = str.split(" ");
                    for (int i = 0; i < N; i++) {
                        taken[i] = Integer.parseInt(strArr[i]);
                    }
                }else{
                    if(M == 0){
                        M = Integer.parseInt(str);
                    }else{
                        guess = new int[M];
                        String[] strArr = str.split(" ");
                        for (int i = 0; i < M; i++) {
                            guess[i] = Integer.parseInt(strArr[i]);
                        }
                        break;
                    }
                }
            }
        }

        // taken 정렬
        merge(0, N - 1);
        // guess의 element 각각에 대해 bineary search로 있는지 여부 확인
        for (int i = 0; i < M; i++) {
            if(binarySearch(guess[i], 0, N - 1)){
                sb.append(1);
            }else{
                sb.append(0);
            }
            if(i != M - 1){
                sb.append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean binarySearch(int guessNumber, int start, int end) {
        if(start > end){
            return false;
        }
        if(start == end){
            if(guessNumber == taken[start]){
                return true;
            }else{
                return false;
            }
        }
        int mid = (start + end) / 2;
        if(taken[mid] > guessNumber){
            return binarySearch(guessNumber, start, mid - 1);
        }else if(taken[mid] == guessNumber){
            return true;
        }else{
            return binarySearch(guessNumber, mid + 1, end);
        }
    }

    private static void merge(int start, int end) {
        // 좌, 우로 쪼개기
        if(start >= end){
            return;
        }
        if(start + 1 == end){
            if(taken[start] > taken[end]){
                int tmp = taken[start];
                taken[start] = taken[end];
                taken[end] = tmp;
                return;
            }
        }
        int mid = (start + end) / 2;
        merge(start, mid);
        merge(mid + 1, end);
        // 합치기
        int left = start, right = mid + 1, index = start;
        while(left <= mid && right <= end){
            if(taken[left] < taken[right]){
                newArr[index++] = taken[left++];
            }else{
                newArr[index++] = taken[right++];
            }
        }
        if(left > mid){
            for (int i = right; i <= end; i++) {
                newArr[index++] = taken[right++];
            }
        }else{
            for (int i = left; i <= mid; i++) {
                newArr[index++] = taken[left++];
            }
        }
        for (int i = start; i <= end; i++) {
            taken[i] = newArr[i];
        }
    }
}
