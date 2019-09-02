package algorithm.baekjoon.stepwise.priorityqueue;

import java.io.*;

public class _11279_MaxHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        MaxHeap heap = new MaxHeap();
        String str;
        int N = 0, nFreq = 0;
        StringBuilder sb = new StringBuilder();
        while((str = br.readLine()) != null){
            if(N == 0){
                N = Integer.parseInt(str);
            }else{
                nFreq++;
                int num = Integer.parseInt(str);
                if(num == 0){
                    sb.append(heap.delete());
                }else{
                    heap.insert(num);
                }
                if(nFreq == N){
                    break;
                }else{
                    if(num == 0){
                        sb.append("\n");
                    }
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static class MaxHeap{
        int[] arr;
        int size;
        public MaxHeap(){
            arr = new int[100001];
            size = 0;
        }
        void insert(int num){
            arr[++size] = num;
            for (int i = size; i > 1; i /= 2) {
                if(arr[i / 2] < arr[i]){
                    swap(i / 2, i);
                }else{
                    break;
                }
            }
        }
        private void swap(int index1, int index2){
            int tmp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = tmp;
        }
        int delete(){
            if(size == 0){
                return 0;
            }
            int max = arr[1];
            swap(1, size);
            arr[size--] = 0;
            for (int i = 1; i * 2 <= size;) {
                if(arr[i] > arr[i * 2] && arr[i] > arr[i * 2 + 1]){
                    break;
                }else if(arr[i * 2] > arr[i * 2 + 1]){
                    swap(i, i * 2);
                    i *= 2;
                }else{
                    swap(i, i * 2 + 1);
                    i = i * 2 + 1;
                }
            }

            return max;
        }
    }
}
