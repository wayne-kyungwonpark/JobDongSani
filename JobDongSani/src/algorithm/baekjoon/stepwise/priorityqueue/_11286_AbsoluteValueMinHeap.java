package algorithm.baekjoon.stepwise.priorityqueue;

import java.io.*;

public class _11286_AbsoluteValueMinHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        AbsoluteValueMinHeap heap = new AbsoluteValueMinHeap();
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

    private static class AbsoluteValueMinHeap{
        int[] arr;
        int size;
        public AbsoluteValueMinHeap(){
            arr = new int[100001];
            size = 0;
        }
        void insert(int num){
            arr[++size] = num;
            for (int i = size; i > 1; i /= 2) {
                int abs = Math.abs(arr[i]);
                int absParent = Math.abs(arr[i / 2]);
                if(abs > absParent){
                    break;
                }else if((abs == absParent) && (arr[i] > arr[i / 2])){
                    break;
                }else{
                    swap(i, i / 2);
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
            int absMin = arr[1];
            swap(1, size);
            arr[size--] = 0;
            for (int i = 1; i * 2 <= size; ) {
                int abs = Math.abs(arr[i]);
                int absLeftChild = Math.abs(arr[i * 2]);
                int absRightChild = Math.abs(arr[i * 2 + 1]);
                boolean leftOk = false, rightOk = false;
                if(abs < absLeftChild || (abs == absLeftChild && arr[i] < arr[i * 2])){
                    leftOk = true;
                }
                if(i * 2 + 1 > size || (i * 2 + 1 <= size && (abs < absRightChild || (abs == absRightChild && arr[i] < arr[i * 2 + 1])))){
                    rightOk = true;
                }
                if(leftOk && rightOk){
                    break;
                }else if(leftOk && !rightOk){
                    swap(i, i * 2 + 1);
                    i = i * 2 + 1;
                }else if(!leftOk && rightOk){
                    swap(i, i * 2);
                    i = i * 2;
                }else{
                    if(absLeftChild < absRightChild){
                        swap(i, i * 2);
                        i = i * 2;
                    }else if(absLeftChild > absRightChild){
                        swap(i, i * 2 + 1);
                        i = i * 2 + 1;
                    }else{
                        if(arr[i * 2] < arr[i * 2 + 1]){
                            swap(i, i * 2);
                            i = i * 2;
                        }else{
                            swap(i, i * 2 + 1);
                            i = i * 2 + 1;
                        }
                    }
                }
            }
            return absMin;
        }
    }
}
