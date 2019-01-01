package algorithm.baekjoon.stepwise.queue;

import java.io.*;
import java.util.LinkedList;

public class Queue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int cmdNum = 0;
        int cmdFreq = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        while ((str = br.readLine()) != null) {
            if(cmdNum == 0){
                cmdNum = Integer.parseInt(str);
            }else{
                String[] strArr = str.split(" ");
                if("push".equals(strArr[0])){
                    queue.add(Integer.parseInt(strArr[1]));
                }else if("front".equals(strArr[0])){
                    if(queue.isEmpty()){
                        bw.write("-1");
                    }else{
                        bw.write(String.valueOf(queue.getFirst()));
                    }
                    bw.newLine();
                }else if("back".equals(strArr[0])){
                    if(queue.isEmpty()){
                        bw.write("-1");
                    }else{
                        bw.write(String.valueOf(queue.getLast()));
                    }
                    bw.newLine();
                }else if("size".equals(strArr[0])){
                    if(queue.isEmpty()){
                        bw.write("0");
                    }else{
                        bw.write(String.valueOf(queue.size()));
                    }
                    bw.newLine();
                }else if("empty".equals(strArr[0])){
                    if(queue.isEmpty()){
                        bw.write("1");
                    }else{
                        bw.write("0");
                    }
                    bw.newLine();
                }else if("pop".equals(strArr[0])){
                    if(queue.isEmpty()){
                        bw.write("-1");
                    }else{
                        bw.write(String.valueOf(queue.getFirst()));
                        queue.removeFirst();
                    }
                    bw.newLine();
                }
                cmdFreq++;
            }
            if(cmdFreq == cmdNum){
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
