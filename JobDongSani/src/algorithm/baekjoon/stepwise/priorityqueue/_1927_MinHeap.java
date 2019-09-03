package algorithm.baekjoon.stepwise.priorityqueue;

import java.io.*;

public class _1927_MinHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        MeanHeap heap = new MeanHeap();
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

    private static class MeanHeap{
        int[] arr;
        int size;
        public MeanHeap(){
            arr = new int[100001];
            size = 0;
        }
        void insert(int num){
            arr[++size] = num;
            for (int i = size; i > 1; i /= 2) {
                if(arr[i] < arr[i / 2]){
                    swap(i, i / 2);
                }else{
                    break;
                }
            }
        }
        private void swap(int index1, int index2){
            if(index1 <= size && index2 <= size){
                int tmp = arr[index1];
                arr[index1] = arr[index2];
                arr[index2] = tmp;
            }
        }
        int delete(){
            if(size == 0){
                return 0;
            }
            int min = arr[1];
            swap(1, size);
            arr[size--] = 0;
            // 자식 노드가 있을 경우에만 들어감
            for (int i = 1; i * 2 <= size;) {
                // 왼쪽 자식이 부모보다 크면서 오른쪽 자식이 없거나, 오른쪽 자식도 부모보다 클 때 break
                if(arr[i] < arr[i * 2] && ((i * 2 + 1 <= size && arr[i] < arr[i * 2 + 1]) || (i * 2 + 1 > size))){
                    break;
                // 오른쪽 자식이 없을 경우, 혹은 오른쪽 자식이 있는데 왼쪽 자식이 오른쪽 자식보다 작을 경우
                }else if((i * 2 + 1 <= size && arr[i * 2] < arr[i * 2 + 1]) || (i * 2 + 1 > size)){
                    swap(i, i * 2);
                    i = i * 2;
                }else{
                    swap(i, i * 2 + 1);
                    i = i * 2 + 1;
                }
            }
            return min;
        }
    }
}
