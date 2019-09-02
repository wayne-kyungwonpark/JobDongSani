package programmers.skillchecktest1_1;

public class Problem1 {
    public int[] solution(int []arr) {
        int[] answer = {};

        int[][] arr2d = new int[arr.length][2];
        int[][] tmp = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            arr2d[i][0] = i;
            arr2d[i][1] = arr[i];
        }
        // arr에 순서를 주고, 숫자 크기대로 따로 정렬
        merge(arr2d, tmp, 0, arr.length - 1, 1);
        // 중복되는 숫자 제거
        tmp = new int[arr.length][2];
        int nums = 1;
        int prevNum = arr2d[0][1];
        tmp[0][0] = arr2d[0][0];
        tmp[0][1] = arr2d[0][1];
        for (int i = 1; i < arr.length; i++) {
            if(arr2d[i][1] != prevNum){

            }
        }

        return answer;
    }

    private static void merge(int[][] arr, int[][] tmp, int start, int end, int index){
        if(start >= end){
            return;
        }
        if(start == end - 1){
            if(arr[start][index] > arr[end][index]){
                int tmpIndex = arr[start][index], tmpNonIndex = arr[start][1 - index];
                arr[start][index] = arr[end][index];
                arr[start][1 - index] = arr[end][1 - index];
                arr[end][index] = tmpIndex;
                arr[end][1 - index] = tmpNonIndex;
            }
            return;
        }
        int mid = (start + end) / 2;
        merge(arr, tmp, start, mid, index);
        merge(arr, tmp, mid + 1, end, index);
        int left = start, right = mid + 1, k = start;
        while(left <= mid && right <= end){
            if(arr[left][index] < arr[right][index]){
                tmp[k][index] = arr[left][index];
                tmp[k][1 - index] = arr[left][1 - index];
                left++;
            }else{
                tmp[k][index] = arr[right][index];
                tmp[k][1 - index] = arr[right][1 - index];
                right++;
            }
            k++;
        }
        if(left > mid){
            for (int i = right; i <= end; i++) {
                tmp[k][index] = arr[i][index];
                tmp[k][1 - index] = arr[i][1 - index];
                k++;
            }
        }else{
            for (int i = left; i <= mid; i++) {
                tmp[k][index] = arr[i][index];
                tmp[k][1 - index] = arr[i][1 - index];
                k++;
            }
        }
        for (int i = start; i <= end; i++) {
            arr[i][index] = tmp[i][index];
            arr[i][1 - index] = tmp[i][1 - index];
        }
    }
}
