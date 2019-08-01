package algorithm.baekjoon.stepwise.stack;

import java.io.*;

public class _4949_BalancedWorld {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        StringBuilder sb = new StringBuilder();
        while((str = br.readLine()) != null){
            if(".".equals(str)){
                break;
            }else{
                Stack stack = new Stack(str.length());
                char[] chArr = str.toCharArray();
                boolean isBalanced = true;
                for (int i = 0; i < chArr.length; i++) {
                    if(chArr[i] == '('){
                        stack.push(chArr[i]);
                    }else if(chArr[i] == '['){
                        stack.push(chArr[i]);
                    }else if(chArr[i] == ')'){
                        if(stack.length == 0 || stack.pop() != '('){
                            isBalanced = false;
                            break;
                        }
                    }else if(chArr[i] == ']'){
                        if(stack.length == 0 || stack.pop() != '['){
                            isBalanced = false;
                            break;
                        }
                    }
                }
                if(isBalanced && stack.length == 0){
                    sb.append("yes");
                }else{
                    sb.append("no");
                }
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Stack{
        int length;
        char[] arr;
        Stack(int n){
            length = 0;
            arr = new char[n + 1];
        }
        void push(char ch){
            arr[length++] = ch;
        }
        char pop(){
            return arr[--length];
        }
    }
}
