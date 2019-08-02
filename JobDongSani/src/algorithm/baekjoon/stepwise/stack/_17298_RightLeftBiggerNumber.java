package algorithm.baekjoon.stepwise.stack;

import java.io.*;

public class _17298_RightLeftBiggerNumber {
    private static int N = 0;
    private static int[] nums = null;
    private static int[] rlbNums = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while((str = br.readLine()) != null){
            if(N == 0){
                N = Integer.parseInt(str);
                nums = new int[N];
                rlbNums = new int[N];
            }else{
                String[] strArr = str.split(" ");
                for (int i = N - 1; i >= 0; i--) {
                    nums[i] = Integer.parseInt(strArr[i]);
                    rlbNums[i] = -1;
                }
                break;
            }
        }
        Stack stack = new Stack(N);
        Stack indexStack = new Stack(N);
        stack.push(nums[0]);
        indexStack.push(0);
        for (int i = 1; i < N; i++) {
            while (stack.length != 0 && nums[i] > stack.peek()) {
                rlbNums[indexStack.pop()] = nums[i];
                stack.pop();
            }
            stack.push(nums[i]);
            indexStack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(rlbNums[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Stack{
        int length;
        int[] arr;
        Stack(int n){
            length = 0;
            arr = new int[n + 1];
        }
        void push(int num){
            arr[length++] = num;
        }
        int peek(){
            return arr[length - 1];
        }
        int pop(){
            return arr[--length];
        }
    }
}
