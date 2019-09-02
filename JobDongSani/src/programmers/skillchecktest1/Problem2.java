package programmers.skillchecktest1;

public class Problem2 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[] check = new boolean[n];
        boolean[] borrowedOrLost = new boolean[n];
        int[] tmps = new int[lost.length];
        merge(lost, tmps, 0, lost.length - 1);
        tmps = new int[reserve.length];
        merge(reserve, tmps, 0, reserve.length - 1);
        for (int i = 0; i < n; i++) {
            boolean isAnswerChanged = false;
            if(binarySearch(lost, i, 0, lost.length - 1)) {
                if(!borrowedOrLost[i] && binarySearch(reserve, i, 0, reserve.length - 1)){
                    borrowedOrLost[i] = true;
                    answer++;
                    isAnswerChanged = true;
                }else if(!isAnswerChanged && binarySearch(reserve, i - 1, 0, reserve.length - 1)
                        && (!borrowedOrLost[i - 1] && !binarySearch(lost, i - 1, 0, lost.length - 1))){
                    borrowedOrLost[i - 1] = true;
                    answer++;
                    isAnswerChanged = true;
                }else if(!isAnswerChanged && i != n - 1 && binarySearch(reserve, i + 1, 0, reserve.length - 1)
                        && (!borrowedOrLost[i + 1])){
                    borrowedOrLost[i + 1] = true;
                    answer++;
                }
            }else{
                answer++;
            }
        }
        return answer;
    }

    public boolean binarySearch(int[] arr, int guessNumber, int start, int end) {
        if(start > end){
            return false;
        }
        if(start == end){
            if(guessNumber == arr[start]){
                return true;
            }else{
                return false;
            }
        }
        int mid = (start + end) / 2;
        if(arr[mid] > guessNumber){
            return binarySearch(arr, guessNumber, start, mid - 1);
        }else if(arr[mid] == guessNumber){
            return true;
        }else{
            return binarySearch(arr, guessNumber, mid + 1, end);
        }
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
