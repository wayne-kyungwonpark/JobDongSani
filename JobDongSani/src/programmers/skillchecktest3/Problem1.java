package programmers.skillchecktest3;

public class Problem1 {
    public long solution(int n, int[] works) {
        long answer = 0;
        int[] tmps = new int[works.length];
        merge(works, tmps, 0, works.length - 1);
        for (int i = 0; i < n; i++) {
            if(works[works.length - 1] == 0){
                break;
            }else{
                boolean changed = false;
                for (int j = works.length - 1; j >= 0; j--) {
                    if(works[j] != works[works.length - 1]){
                        works[j + 1]--;
                        changed = true;
                        break;
                    }
                }
                if(!changed){
                    works[0]--;
                }
            }
        }
        for (int i = 0; i < works.length; i++) {
            answer += (works[i] * works[i]);
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
