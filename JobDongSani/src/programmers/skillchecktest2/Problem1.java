package programmers.skillchecktest2;

public class Problem1 {
    public int solution(int []A, int []B) {
        int answer = 0;
        int[] tmps = new int[A.length];
        merge(A, tmps, 0, A.length - 1);
        tmps = new int[B.length];
        merge(B, tmps, 0, B.length - 1);

        for (int i = 0; i < A.length; i++) {
            answer += (A[i] * B[A.length - 1 - i]);
        }

        return answer;
    }

    public void merge(int[] arr, int[] tmps, int start, int end){
        if(start >= end){
            return;
        }
        if(start + 1 == end){
            if(arr[start] > arr[end]){
                int tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
                return;
            }
        }
        int mid = (start + end) / 2;
        merge(arr, tmps, start, mid);
        merge(arr, tmps,mid + 1, end);
        // 합치기
        int left = start, right = mid + 1, index = start;
        while(left <= mid && right <= end){
            if(arr[left] < arr[right]){
                tmps[index++] = arr[left++];
            }else{
                tmps[index++] = arr[right++];
            }
        }
        if(left > mid){
            for (int i = right; i <= end; i++) {
                tmps[index++] = arr[right++];
            }
        }else{
            for (int i = left; i <= mid; i++) {
                tmps[index++] = arr[left++];
            }
        }
        for (int i = start; i <= end; i++) {
            arr[i] = tmps[i];
        }
    }
}
