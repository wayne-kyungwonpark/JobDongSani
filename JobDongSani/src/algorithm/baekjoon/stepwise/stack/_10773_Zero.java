package algorithm.baekjoon.stepwise.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10773_Zero {
    private static int N = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int nFreq = 0;
        Stack stack = null;
        while((str = br.readLine()) != null){
            if(N == 0){
                N = Integer.parseInt(str);
                stack = new Stack(N);
            }else{
                int num = Integer.parseInt(str);
                if(num != 0){
                    stack.push(num);
                }else{
                    stack.pop();
                }
                nFreq++;
                if(nFreq == N){
                    break;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < stack.length; i++) {
            result += stack.arr[i];
        }
        System.out.println(result);
    }

    private static class Stack{
        int length;
        int[] arr;
        Stack(int n){
            length = 0;
            arr = new int[n + 1];
        }

        void push(int num){
            arr[length++] = num;
        }

        int pop(){
           return arr[--length];
        }
    }
}
