package algorithm.baekjoon.stepwise.dequeue;

import java.io.*;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/baekjoon/stepwise/dequeue/_5430_AC.java
 *
 * ## start와 end 및 direction 결정을 통한 문제 풀이
 * 1. 배열의 숫자를 strArr에 넣는다.
 * 2. D가 원소 수보다 많은 경우, error
 * 3. 길이 n 의 경우 start = 0, end = n - 1 로 시작
 * 4. R 명령 수행: direction 변경
 * 5. D 명령 수행: direction이 참일 경우 startEraseNum++, 거짓일 경우 endEraseNum++
 * 6. 최종적으로 start에 startEraseNum만큼 더하고, end에 endEraseNum만큼 뺀다.
 * 7. direction이 참인 경우 strArr[start]부터 strArr[end]까지 차례로 출력, 아닐 경우 반대로 출력
 */
public class _5430_AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int testNum = 0, testFreq = 0;
        int caseFreq = 0;
        char[] command = null;
        int arrLen = 0;
//        LinkedList<Integer> queue = new LinkedList<>();
        String[] strArr = null;
        int strArrLen = 0;
        StringBuilder output = new StringBuilder();
        while((str = br.readLine()) != null){
            if(testNum == 0){
                testNum = Integer.parseInt(str);
            }else{
                if(caseFreq == 0){
                    command = str.toCharArray();
                }else if(caseFreq == 1){
                    arrLen = Integer.parseInt(str);
                }else if(caseFreq == 2){
                    if(arrLen != 0){
//                        StringTokenizer strtok = new StringTokenizer(str.substring(1, str.length() - 1), ",");
//                        while(strtok.hasMoreTokens()){
//                            queue.add(Integer.parseInt(strtok.nextToken()));
//                        }
                        strArr = str.substring(1, str.length() - 1).split(",");
                        if(strArr != null){
                            strArrLen = strArr.length;
                        }
//                        for (String elem : strArr) {
//                            queue.add(Integer.parseInt(elem));
//                        }
                    }
                }
                caseFreq++;

                if(caseFreq == 3){
                    testFreq++;
                    // 케이스 계산 수행
                    int dCommandNum = 0;
                    boolean direction = true;
                    int start = 0, end = strArrLen - 1;
                    int startEraseNum = 0, endEraseNum = 0;
                    for(char elem : command){
                        if('R' == elem){
                            direction = !direction;
                        }else{
                            if(direction){
                                startEraseNum++;
                            }else{
                                endEraseNum++;
                            }
                            dCommandNum++;
                        }
                    }
                    start += startEraseNum;
                    end -= endEraseNum;

                    if(dCommandNum > strArrLen){
                        output.append("error");
                    }else{
                        if (strArrLen == 0) {
                            output.append("[]");
                        }else{
                            output.append("[");
                            if(direction){
                                for (int i = start; i <= end; i++) {
                                    output.append(strArr[i]);
                                    if(i != end){
                                        output.append(",");
                                    }
                                }
                            }else{
                                for (int i = end; i >= start; i--) {
                                    output.append(strArr[i]);
                                    if(i != start){
                                        output.append(",");
                                    }
                                }
                            }
                            output.append("]");
                        }
                    }

//                    // queue 체크
//                    for (int i = 0; i < queue.size(); i++) {
//                        bw.write(String.valueOf(queue.get(i)) + " ");
//                    }
//                    bw.newLine();

                    command = null;
                    arrLen = 0;
//                    queue = new LinkedList<>();
                    strArr = null;
                    strArrLen = 0;
                    caseFreq = 0;

                    if(testFreq == testNum){
                        break;
                    }else{
                        output.append("\n");
                    }
                }

            }
        }
        bw.write(output.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
