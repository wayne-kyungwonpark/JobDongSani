package algorithm.baekjoon.stepwise.greedyalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1931_AssignMeetingRoom {
    private static int N = 0;
    private static int[][] times = null;
    private static int[][] tmp = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nFreq = 0;
        String str;
        while((str = br.readLine()) != null){
            if(N == 0){
                N = Integer.parseInt(str);
                times = new int[N][2];
                tmp = new int[N][2];
            }else{
                String[] strArr = str.split(" ");
                times[nFreq][0] = Integer.parseInt(strArr[0]);
                times[nFreq][1] = Integer.parseInt(strArr[1]);
                nFreq++;
                if(nFreq == N){
                    break;
                }
            }
        }
        merge(0, N - 1, 1);
        int start = 0;
        int x = times[0][1];
        for (int i = 1; i < N; i++) {
            if(x != times[i][1]){
                merge(start, i - 1, 0);
                start = i;
                x = times[i][1];
            }else{
                if(i == N - 1 && start < N){
                    merge(start, N - 1, 0);
                }
            }
        }
//        int maxMeetingNums = 0;
//        for (int i = 0; i < N; i++) {
//            int meetingNums = 1;
//            int end = times[i][1];
//            for (int j = i + 1; j < N; j++) {
//                if(times[j][0] >= end){
//                    end = times[j][1];
//                    meetingNums++;
//                }
//            }
//            if(maxMeetingNums < meetingNums){
//                maxMeetingNums = meetingNums;
//            }
//        }
        int maxMeetingNums = 1;
        int end = times[0][1];
        for (int i = 1; i < N; i++) {
            if(times[i][0] >= end){
                end = times[i][1];
                maxMeetingNums++;
            }
        }
        System.out.println(maxMeetingNums);
    }

    private static void merge(int start, int end, int index){
        if(start >= end){
            return;
        }
        if(start == end - 1){
            if(times[start][index] > times[end][index]){
                int tmpIndex = times[start][index], tmpNonIndex = times[start][1 - index];
                times[start][index] = times[end][index];
                times[start][1 - index] = times[end][1 - index];
                times[end][index] = tmpIndex;
                times[end][1 - index] = tmpNonIndex;
            }
            return;
        }
        int mid = (start + end) / 2;
        merge(start, mid, index);
        merge(mid + 1, end, index);
        int left = start, right = mid + 1, k = start;
        while(left <= mid && right <= end){
            if(times[left][index] < times[right][index]){
                tmp[k][index] = times[left][index];
                tmp[k][1 - index] = times[left][1 - index];
                left++;
            }else{
                tmp[k][index] = times[right][index];
                tmp[k][1 - index] = times[right][1 - index];
                right++;
            }
            k++;
        }
        if(left > mid){
            for (int i = right; i <= end; i++) {
                tmp[k][index] = times[i][index];
                tmp[k][1 - index] = times[i][1 - index];
                k++;
            }
        }else{
            for (int i = left; i <= mid; i++) {
                tmp[k][index] = times[i][index];
                tmp[k][1 - index] = times[i][1 - index];
                k++;
            }
        }
        for (int i = start; i <= end; i++) {
            times[i][index] = tmp[i][index];
            times[i][1 - index] = tmp[i][1 - index];
        }
    }
}
