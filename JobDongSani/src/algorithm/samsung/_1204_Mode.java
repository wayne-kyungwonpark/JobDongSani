package algorithm.samsung;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/samsung/_1204_Mode.java
 *
 * Samsung > 문제 > Mode
 * 1. 점수의 빈도를 기록할 크기 101짜리 1차원 정수 배열 생성:  mode
 * 2. 점수들을 for문 돌며 mode에 기록
 * 3. mode를 for문 돌며 최빈값을 업데이트
 * 4. 동시에 최빈값을 가지는 점수를 list에 넣음
 * 5. list를 array로 변환한 뒤, 오름차순으로 정렬
 * 6. 마지막 값 출력
 */
public class _1204_Mode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int testNum = 0;
        int caseNum = 0;
        int[] mode = null;
        while((str = br.readLine()) != null){
            if(testNum == 0){
                testNum = Integer.parseInt(str);
            }else{
                if(caseNum == 0){
                    caseNum = Integer.parseInt(str);
                    mode = new int[101];
                }else{
                    String[] strArr = str.split(" ");
                    for (int i = 0; i < 1000; i++) {
                        mode[Integer.parseInt(strArr[i])]++;
                    }
                    int max = 0;
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int i = 0; i < mode.length; i++) {
                        if(mode[i] > max){
                            max = mode[i];
                            list = new ArrayList<>();
                            list.add(i);
                        }else if(mode[i] == max){
                            list.add(i);
                        }
                    }
//                System.out.println(caseNum);
                    Object[] obArr = list.toArray();
                    Arrays.sort(obArr);
                    bw.write("#" + caseNum + " " + String.valueOf((int) obArr[obArr.length - 1]));
                    if(caseNum != 10){
                        bw.newLine();
                    }
                    if(caseNum == 10){
                        break;
                    }
                    caseNum = 0;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
