package algorithm.baekjoon.stepwise.queue;

import java.io.*;
import java.util.LinkedList;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/baekjoon/stepwise/queue/Queue.java
 *
 * Baekjoon > 문제 > 단계별로 풀어보기 > 큐 > 큐
 * 1. cmdNum: 총 명령 갯수, cmdFreq: 명령 갯수를 세기 위한 파라미터
 * 2. split 메소드 사용하여 " "를 기준으로 명령어 + 숫자 or 명령어로 바꾼다.
 * 3. 명령어에 따른 처리를 수행한다.
 */
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
