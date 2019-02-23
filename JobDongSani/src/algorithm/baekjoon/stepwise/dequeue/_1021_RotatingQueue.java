package algorithm.baekjoon.stepwise.dequeue;

import java.io.*;
import java.util.LinkedList;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/baekjoon/stepwise/dequeue/_1021_RotatingQueue.java
 *
 * ## LinkedList로 dequeue 표현 후 계산
 * 1. N 크기의 dequeue를 linkedlist로 표현
 * 2. 2. 3. 연산의 값: value
 * 3. M만큼 for문을 돌며 양방향으로 뽑아내려고 하는 숫자를 찾는다.
 * 4. 빠른 쪽으로 value만큼 더해준다.
 * 5. 최악의 케이스 (계속 양방향의 중간 정도의 위치에 뽑아내려는 숫자가 있는 경우)
 * 	1. (N/2) + ((N-1)/2) + ((N-2)/2) + … + ((N-M+1)/2) 만큼의 연산 필요
 * 	2. 즉, O(MN) 만큼의 시간복잡도 필요
 */
public class _1021_RotatingQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int n = 0, m = 0;
        LinkedList<Integer> dequeue = new LinkedList<>();
        int[] wanted = null;
        while((str = br.readLine()) != null){
            String[] strArr = str.split(" ");
            if(n == 0){
                n = Integer.parseInt(strArr[0]);
                m = Integer.parseInt(strArr[1]);
                wanted = new int[n];
                for (int i = 1; i <= n; i++) {
                    dequeue.add(i);
                }
            }else {
                for (int i = 0; i < m; i++) {
                    wanted[i] = Integer.parseInt(strArr[i]);
                }
                break;
            }
        }

        int pointer = 0;
        int value = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < dequeue.size(); j++) {
                int clockwise = (pointer + j >= dequeue.size())? pointer + j - dequeue.size() : pointer + j;
                int counterClockwise = (pointer - j < 0)? pointer - j + dequeue.size() : pointer - j;
                if(dequeue.get(clockwise) == wanted[i]){
                    dequeue.remove(clockwise);
                    pointer = (clockwise >= dequeue.size())? clockwise - dequeue.size() : clockwise;
                    value += j;
                    break;
                }else if(dequeue.get(counterClockwise) == wanted[i]){
                    dequeue.remove(counterClockwise);
                    pointer = (counterClockwise >= dequeue.size())? counterClockwise - dequeue.size() : counterClockwise;
                    value += j;
                    break;
                }
            }
        }

        bw.write(String.valueOf(value));

//        // dequeue, wanted 확인
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < dequeue.size(); i++) {
//            sb.append(dequeue.get(i)).append(" ");
//        }
//        sb.append("\n");
//        for (int i = 0; i < wanted.length; i++) {
//            sb.append(wanted[i]).append(" ");
//        }
//        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
