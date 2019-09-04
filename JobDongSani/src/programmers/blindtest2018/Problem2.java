package programmers.blindtest2018;

import java.util.Arrays;

public class Problem2 {
//    5	[2,1,2,6,2,4,3,3] [3,4,2,1,5]
//    4	[4,4,4,4,4]	[4,1,2,3]
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        Arrays.sort(stages);
        // overs[i] : stage i를 넘은 사람 수
        // overs[i - 1] - overs[i] : stage i에 머물러 있는 사람 수 (i - 1을 넘었으나 i를 넘지 못한)
        int[] overs = new int[N + 1];
        int index = 0;
        for (int i = 0; i < stages.length; i++) {
            if(stages[i] > index) {
                overs[index] = stages.length - i;
                for (int j = index + 1; j < stages[i]; j++) {
                    overs[j] = overs[index];
                }
                index = stages[i];
            }
        }
        // failratePerUser[i][0]: stage 번호 (j)
        // failratePerUser[i][0]: stage j의 실패율
        double[][] failratePerUser = new double[N][2];
        for (int i = 0; i < N; i++) {
            failratePerUser[i][0] = i + 1;
            if(overs[i] == 0){
                failratePerUser[i][1] = 0.0;
            }else{
                failratePerUser[i][1] = ((double) (overs[i] - overs[i + 1])) / overs[i];
            }
        }
        double[][] tmps = new double[N][2];
        // 실패율 기준으로 오름차순 정렬
        merge(tmps, failratePerUser, 0, N - 1, 1);
        // 실패율 기준으로 내림차순 정렬
        double[][] failratePerUserMax = new double[N][2];
        for (int i = 0; i < N; i++) {
            failratePerUserMax[i][0] = failratePerUser[N - 1 - i][0];
            failratePerUserMax[i][1] = failratePerUser[N - 1 - i][1];
        }
        // 실패율이 내림차순으로 정렬된 상태에서 실패율이 동일할 경우, stage 번호 기준으로 오름차순 정렬
        double failrate = failratePerUserMax[0][1];
        int sameIndex = 0;
        for (int i = 0; i < N; i++) {
            if(Double.compare(failrate, failratePerUserMax[i][1]) != 0){
                merge(tmps, failratePerUserMax, sameIndex, i - 1, 0);
                failrate = failratePerUserMax[i][1];
                sameIndex = i;
            }
        }
        if(sameIndex < N - 1){
            merge(tmps, failratePerUserMax, sameIndex, N - 1, 0);
        }
        // failratePerUserMax[i][0] 을 answer에 담음
        answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int) failratePerUserMax[i][0];
        }

        return answer;
    }

    public void merge(double[][] tmps, double[][] ori, int start, int end, int index){
        if(start >= end){
            return;
        }
        if(start == end - 1){
            if(Double.compare(ori[start][index], ori[end][index]) > 0){
                double tmp1 = ori[start][1 - index], tmp2 = ori[start][index];
                ori[start][1 - index] = ori[end][1 - index];
                ori[start][index] = ori[end][index];
                ori[end][1 - index] = tmp1;
                ori[end][index] = tmp2;
            }
            return;
        }
        int mid = (start + end) / 2;
        merge(tmps, ori, start, mid, index);
        merge(tmps, ori, mid + 1, end, index);
        int left = start, right = mid + 1, k = start;
        while(left <= mid && right <= end){
            if(Double.compare(ori[left][index], ori[right][index]) < 0){
                tmps[k][0] = ori[left][0];
                tmps[k][1] = ori[left][1];
                left++;
            }else{
                tmps[k][0] = ori[right][0];
                tmps[k][1] = ori[right][1];
                right++;
            }
            k++;
        }
        if(left > mid){
            for (int i = k; i <= end; i++) {
                tmps[i][0] = ori[right][0];
                tmps[i][1] = ori[right][1];
                right++;
            }
        }else{
            for (int i = k; i <= end; i++) {
                tmps[i][0] = ori[left][0];
                tmps[i][1] = ori[left][1];
                left++;
            }
        }
        for (int i = start; i <= end; i++) {
            ori[i][0] = tmps[i][0];
            ori[i][1] = tmps[i][1];
        }
    }
}
