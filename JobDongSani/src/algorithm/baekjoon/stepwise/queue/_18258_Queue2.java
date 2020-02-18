package algorithm.baekjoon.stepwise.queue;

import java.io.*;
import java.util.LinkedList;

public class _18258_Queue2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String[] strArr = br.readLine().split(" ");
            if(strArr.length == 2){
                int num = Integer.parseInt(strArr[1]);
                queue.add(num);
            }else{
                String command = strArr[0];
                switch(command){
                    case "pop":
                        if(queue.isEmpty()){
                            sb.append(-1);
                        }else{
                            sb.append(queue.removeFirst());
                        }
                        break;
                    case "size":
                        sb.append(queue.size());
                        break;
                    case "empty":
                        if(queue.isEmpty()){
                            sb.append(1);
                        }else{
                            sb.append(0);
                        }
                        break;
                    case "front":
                        if(queue.isEmpty()){
                            sb.append(-1);
                        }else{
                            sb.append(queue.getFirst());
                        }
                        break;
                    case "back":
                        if(queue.isEmpty()){
                            sb.append(-1);
                        }else{
                            sb.append(queue.getLast());
                        }
                        break;
                    default:
                        break;
                }
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
