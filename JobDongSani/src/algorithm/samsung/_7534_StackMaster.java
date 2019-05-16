package algorithm.samsung;

import java.io.*;

public class _7534_StackMaster {
    private static int N = 0;
    private static int[] wanted = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testNum = 0;
        int testFreq = 0;
        String str;
        while((str = br.readLine()) != null){
            if(testNum == 0){
                testNum = Integer.parseInt(str);
            }else{
                if(N == 0){
                    N = Integer.parseInt(str);
                    wanted = new int[N];
                }else{
                    String[] strArr = str.split(" ");
                    for (int i = 0; i < strArr.length; i++) {
                        wanted[i] = Integer.parseInt(strArr[i]);
                    }
                    testFreq++;
                    // doSomething
                    StringBuilder sb = new StringBuilder();
                    sb.append("#").append(testFreq).append(" ").append(doSomething());
                    bw.write(sb.toString());
                    // initialization
                    N = 0; wanted = null;
                    if(testFreq == testNum){
                        break;
                    }else{
                        bw.newLine();
                    }
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static String doSomething(){
        StringBuilder sb = new StringBuilder();
        Stack stack = new Stack();
        int pushNum = 1;
        for (int i = 0; i < wanted.length; i++) {
            if(stack.isEmpty() || stack.peek() <= wanted[i]){
                while(pushNum <= wanted[i]){
                    stack.push(pushNum++);
                    sb.append("+");
                }
                stack.pop();
                sb.append("-");
            }else{
                return "NO";
            }
        }
        return sb.toString();
    }

    private static class Stack {
        public int size;
        private int[] array;
        public Stack(){
            size = 0;
            array = new int[10];
        }
        public void push(int target){
            if(size == array.length - 1){
                int[] newStack = new int[array.length * 2];
                for (int i = 0; i < array.length; i++) {
                    newStack[i] = array[i];
                }
                array = newStack;
            }
            array[size++] = target;
        }
        public int pop(){
            if(!isEmpty()){
                return array[--size];
            }else{
                throw new IndexOutOfBoundsException();
            }
        }
        public int peek(){
            if(!isEmpty()){
                return array[size - 1];
            }else{
                throw new IndexOutOfBoundsException();
            }
        }
        public boolean isEmpty(){
            if(size == 0){
                return true;
            }
            return false;
        }
    }

}
