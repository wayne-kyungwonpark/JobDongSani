package algorithm.baekjoon.stepwise.graphdfsbfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/baekjoon/stepwise/graphdfsbfs/_10451_PermutationCycle.java
 *
 * Baekjoon > 문제 > 단계별로 풀어보기 > 그래프 (DFS, BFS) > 단지번호붙이기
 * 0. BFS를 통해 풀이
 * 1. 지도를 저장할 2차원 boolean 배열: map
 * 2. 체크했는지 여부를 저장할 boolean 배열: check
 * 3. 단지수 저장할 Integer 리스트: complex
 * 4. for문 행 i, 열 j 로 돌면서 check[i][j] == false이면서 map[i][j] == true인 i, j 에 대해 BFS 돌림
 * 5. BFS 돌리면서 체크한 map[l][j]에 대해서는 check[l][j] = true 지정
 * 6. 체크할 때마다 숫자 체크 (로컬 변수: num)
 * 7. BFS 과정 끝나면 complex에 num 추가
 * 8. complex 에 대해 for 문 돌면서 오름차순 정렬
 */
public class _2667_ComplexNum {

    private static int returnComplexNum(int i, int j, boolean[][] map, boolean[][] check){
        int num = 1;
        LinkedList<Integer> rowQueue = new LinkedList<>();
        LinkedList<Integer> colQueue = new LinkedList<>();
        rowQueue.offer(i);
        colQueue.offer(j);
        while(!rowQueue.isEmpty() && !colQueue.isEmpty()){
            int rowNode = rowQueue.pop();
            int colNode = colQueue.pop();
            if(rowNode != 0 && map[rowNode - 1][colNode] && !check[rowNode - 1][colNode]){ // 위
                check[rowNode - 1][colNode] = true;
                rowQueue.offer(rowNode - 1);
                colQueue.offer(colNode);
                num++;
            }
            if(colNode != map.length - 1 && map[rowNode][colNode + 1] && !check[rowNode][colNode + 1]){ // 오른쪽
                check[rowNode][colNode + 1] = true;
                rowQueue.offer(rowNode);
                colQueue.offer(colNode + 1);
                num++;
            }
            if(rowNode != map.length - 1 && map[rowNode + 1][colNode] && !check[rowNode + 1][colNode]){ // 아래
                check[rowNode + 1][colNode] = true;
                rowQueue.offer(rowNode + 1);
                colQueue.offer(colNode);
                num++;
            }
            if(colNode != 0 && map[rowNode][colNode - 1] && !check[rowNode][colNode - 1]){ // 왼쪽
                check[rowNode][colNode - 1] = true;
                rowQueue.offer(rowNode);
                colQueue.offer(colNode - 1);
                num++;
            }
        }
        return num;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int mapSize = 0, freq = 0;
        boolean[][] map = null;
        while((str = br.readLine()) != null){
            if(mapSize == 0){
                mapSize = Integer.parseInt(str);
                map = new boolean[mapSize][mapSize];
            }else{
                char[] chArr = str.toCharArray();
                for (int i = 0; i < mapSize; i++) {
                    if(chArr[i] == '1'){
                        map[freq][i] = true;
                    }
                }
                freq++;
                if(mapSize == freq){
                    break;
                }
            }
        }

        boolean[][] check = new boolean[mapSize][mapSize];
        LinkedList<Integer> complex = new LinkedList<>();
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if(map[i][j] && !check[i][j]){
                    check[i][j] = true;
                    int num = returnComplexNum(i, j, map, check);
                    if(num != 0){
                        complex.push(num);
                    }
                }
            }
        }

        int[] complexArr = new int[complex.size()];
        for (int i = 0; i < complex.size(); i++) {
            complexArr[i] = complex.get(i);
        }
        Arrays.sort(complexArr);

        bw.write(String.valueOf(complexArr.length));
        for (int i = 0; i < complexArr.length; i++) {
            bw.newLine();
            bw.write(String.valueOf(complexArr[i]));
        }

//        // 제대로 변환했는지 체크
//        for (int i = 0; i < mapSize; i++) {
//            for (int j = 0; j < mapSize; j++) {
//                bw.write(String.valueOf(map[i][j]) + " ");
//            }
//            bw.newLine();
//        }

        bw.flush();
        bw.close();
        br.close();
    }
}
