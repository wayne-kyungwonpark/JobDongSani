package algorithm.baekjoon.stepwise.dequeue;

import java.io.*;
import java.util.LinkedList;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/baekjoon/stepwise/dequeue/_10866_Dequeue.java
 *
 * LinkedList 를 통한 구현
 * 1. 덱의 앞 (숫자 낮음), 뒤 (숫자 높음)으로 가정한다.
 * 2. LinkedList<Integer> dequeue
 *
 * * 깨달은 점...
 * 	* java LinkedList의 pop()과 poll()은 기능적으로 같은 명령을 수행한다.
 * 	* 하지만 리스트가 비어있을 경우, pop()은 NoSuchElementException을, poll()은 null을 리턴한다.
 */
public class _10866_Dequeue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int testNum = 0, testFreq = 0;
        LinkedList<Integer> dequeue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while((str = br.readLine()) != null){
            if(testNum == 0){
                testNum = Integer.parseInt(str);
            }else{
                String[] strArr = str.split(" ");
                if("push_front".equals(strArr[0])){
                    dequeue.push(Integer.parseInt(strArr[1]));
                }else if("push_back".equals(strArr[0])){
                    dequeue.offer(Integer.parseInt(strArr[1]));
                }else if("pop_front".equals(strArr[0])){
                    if(dequeue.isEmpty()){
                        sb.append("-1").append("\n");
                    }else{
                        sb.append(dequeue.pop()).append("\n");
                    }
                }else if("pop_back".equals(strArr[0])){
                    if(dequeue.isEmpty()){
                        sb.append("-1").append("\n");
                    }else{
                        sb.append(dequeue.removeLast()).append("\n");
                    }
                }else if("size".equals(strArr[0])){
                    sb.append(dequeue.size()).append("\n");
                }else if("empty".equals(strArr[0])){
                    if(dequeue.isEmpty()){
                        sb.append("1").append("\n");
                    }else{
                        sb.append("0").append("\n");
                    }
                }else if("front".equals(strArr[0])){
                    if(dequeue.isEmpty()){
                        sb.append("-1").append("\n");
                    }else{
                        sb.append(dequeue.peek()).append("\n");
                    }
                }else if("back".equals(strArr[0])){
                    if(dequeue.isEmpty()){
                        sb.append("-1").append("\n");
                    }else{
                        sb.append(dequeue.peekLast()).append("\n");
                    }
                }

                testFreq++;
                if(testFreq == testNum){
                    break;
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
