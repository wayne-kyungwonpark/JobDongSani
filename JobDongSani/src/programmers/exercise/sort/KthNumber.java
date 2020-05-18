package programmers.exercise.sort;

public class KthNumber {
    public static void main(String[] args) {

//        int[] test = {2, 1, 5, 7, 3, 6, 3};
//        quicksort(test, 0, test.length - 1);
//        for (int i = 0; i < test.length; i++) {
//            System.out.print(test[i] + " ");
//        }
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = solution(array, commands);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] cutArr = new int[commands[i][1] - commands[i][0] + 1];
            for (int j = commands[i][0] - 1; j <= commands[i][1] - 1; j++) {
                cutArr[j - (commands[i][0] - 1)] = array[j];
            }
            quicksort(cutArr, 0, cutArr.length - 1);
            answer[i] = cutArr[commands[i][2] - 1];
        }
        return answer;
    }

    public static void quicksort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int pivot = arr[start];
        int left = start;
        int right = end + 1;
        do{
            do{
                left++;

            } while(left <= end && arr[left] < pivot);
            do{
                right--;
            } while(start <= right && arr[right] > pivot);

            if(left < right){
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        } while(left < right);

        arr[start] = arr[right];
        arr[right] = pivot;

        quicksort(arr, start, right - 1);
        quicksort(arr, right + 1, end);
    }
}
