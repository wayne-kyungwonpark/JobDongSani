package algorithm.baekjoon.stepwise.priorityqueue;

import java.io.*;

public class _1655_SayMiddle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = 0, nFreq = 0;
        String str;
        StringBuilder sb = new StringBuilder();
        MaxMinHeaps struct = new MaxMinHeaps();
        while((str = br.readLine()) != null){
            if(N == 0){
                N = Integer.parseInt(str);
            }else{
                sb.append(struct.insert(Integer.parseInt(str)));
                nFreq++;
                if(N == nFreq){
                    break;
                }else{
                    sb.append("\n");
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 왼쪽에 MaxHeap, 오른쪽에 MinHeap을 두고 두 heap의 size는 동일하게 맞춘다.
    // size가 홀수일 경우, MaxMinHeaps.root가 가운데 값,
    // size가 짝수일 경우, 두 heap의 root 중 작은 값이 가운데 값이다.
    private static class MaxMinHeaps{
        int root;
        int size;
        MaxHeap left;
        MinHeap right;
        public MaxMinHeaps(){
            root = 0;
            size = 0;
            left = new MaxHeap();
            right = new MinHeap();
        }
        int insert(int num){
           int mid = 0;
           if(size == 0){
               root = num;
               size++;
               return root;
           }
           if(size % 2 == 0){ // root가 비워져 있을 경우 root를 채운다.
               // num이 left의 root보다 크고, right의 root보다 작을 경우, MaxMinHeaps.root에 num을 지정한다.
               if(num > left.getRoot() && num < right.getRoot()){
                   root = num;
               }else{
                   // num이 left의 root보다 크지만, right의 root보다도 크거나 같을 경우,
                   // num을 right에 넣어 정렬시킨 뒤, right의 root를 빼내어 MaxMinHeaps.root에 넣는다.
                   if(num > left.getRoot()){
                       right.insert(num);
                       root = right.delete();
                   }else{ // num이 right의 root보다 작지만, left의 root보다도 작거나 같을 경우
                       left.insert(num);
                       root = left.delete();
                   }
               }
               mid = root;
           }else{ // MaxMinHeaps.root에 값 채워져 있을 경우, MaxMinHeaps.root를 없애고 left와 right의 균형을 맞춘다.
               if(num < root){
                   left.insert(num);
                   right.insert(root);
               }else{
                   left.insert(root);
                   right.insert(num);
               }
               root = 0;
               mid = left.getRoot();
           }
           size++;
           return mid;
        }
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
                if(arr[i] < arr[i / 2]){
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
        int getRoot(){
            if(size == 0){
                return 0;
            }
            return arr[1];
        }
        int delete(){
            if(size == 0){
                return 0;
            }
            int max = arr[1];
            swap(1, size);
            arr[size--] = 0;
            for (int i = 1; i * 2 <= size;) {
                if(arr[i] > arr[i * 2] && ((i * 2 + 1 <= size && arr[i] > arr[i * 2 + 1]) || (i * 2 + 1 > size))){
                    break;
                }else if((i * 2 + 1 <= size && arr[i * 2] > arr[i * 2 + 1]) || (i * 2 + 1 > size)){
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

    private static class MinHeap{
        int[] arr;
        int size;
        public MinHeap(){
            arr = new int[100001];
            size = 0;
        }
        void insert(int num){
            arr[++size] = num;
            for (int i = size; i > 1; i /= 2) {
                if(arr[i] > arr[i / 2]){
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
        int getRoot(){
            if(size == 0){
                return 0;
            }
            return arr[1];
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
