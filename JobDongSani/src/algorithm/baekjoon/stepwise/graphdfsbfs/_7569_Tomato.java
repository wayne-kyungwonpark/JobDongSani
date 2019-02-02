package algorithm.baekjoon.stepwise.graphdfsbfs;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/baekjoon/stepwise/graphdfsbfs/_7569_Tomato.java
 *
 * 1. 입력 차원으로 a, b, c를 받는다고 하자. 이 때 들어오는 입력의 배열은 다음과 같다.
 * 	[ [ [ㅇ ㅇ ㅇ … (a 만큼 반복) … ㅇ ㅇ]  … (b만큼 반복)… [ㅇ ㅇ ㅇ … ㅇ ㅇ] ]
 * 	          … ( c만큼 반복) …
 * 	  [ [ㅇ ㅇ ㅇ … (a 만큼 반복) … ㅇ ㅇ]  … (b만큼 반복)… [ㅇ ㅇ ㅇ … ㅇ ㅇ] ] ]
 * 2. 토마토 표기할 3차원 정수 배열: int[][][] tomato = new int[c+2][b+2][a+2]
 * 3. 2씩 더한 이유는 양 끝을 -1로 넣어 for문 내 예외처리를 하지 않기 위함
 * 4. tomato 배열을 차례로 채운다. 끝의 경우는 무조건 -1로 채운다.
 * 5. 예를 들어 tomato[1][1][1] ~ tomato[1][1][a] 까지 한 줄에 채운다.
 * 6. 각각의 end를 체크할 변수: bCheck, cCheck (넣은 이후에 1씩 증가)
 * 7. cCheck가 c와 같아질 경우 break
 * 8. 모든 토마토가 익을 수 있는 상태인지를 체크 (tomato 배열을 1~c, 1~b, 1~c 까지 돌면서, tomato[i][j][k] == 0인 항목 기준으로 tomato[i+-1][j][k], tomato[i][j+-1][k], tomato[i][j][k+-1] 모두가 -1만 아니면 된다. for문 돌면서 하나라도 나오는 경우 -1 출력)
 * 9. 8.의 과정을 하면서, tomato[i][j][k] == 1인 i, j, k를 따로 저장한다.
 * 10. 따로 저장한 i, j, k 모두에서 동시에 bfs를 사용하여 0인 위치들을 탐색한다. 이 때 max depth를 체크한다. 이것이 바로 정답이다. (multi-source bfs)
 * (탐색한 노드를 체크하는 boolean 3차원 배열: check)
 * (depth체크를 할 int 1차원 배열: lastNodeInDepth[3])
 */
public class _7569_Tomato {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int a = 0, b = 0 , c = 0;
        int[][][] tomato = null;
        int bCheck = 0, cCheck = 0;
        //tomato[i][j][k] == 1 인 i, j, k를 넣을 리스트
        List<Integer> is = new ArrayList<>();
        List<Integer> js = new ArrayList<>();
        List<Integer> ks = new ArrayList<>();
        while((str = br.readLine()) != null){
            if(a == 0){
                String[] strArr = str.split(" ");
                a = Integer.parseInt(strArr[0]);
                b = Integer.parseInt(strArr[1]);
                c = Integer.parseInt(strArr[2]);
                tomato = new int[c + 2][b + 2][a + 2];
                for (int i = 0; i < c + 2; i++) {
                    for (int j = 0; j < b + 2; j++) {
                        tomato[i][j][0] = -1;
                        tomato[i][j][a + 1] = -1;
                    }
                }
                for (int i = 0; i < c + 2; i++) {
                    for (int k = 0; k < a + 2; k++) {
                        tomato[i][0][k] = -1;
                        tomato[i][b + 1][k] = -1;
                    }
                }
                for (int j = 0; j < b + 2; j++) {
                    for (int k = 0; k < a + 2; k++) {
                        tomato[0][j][k] = -1;
                        tomato[c + 1][j][k] = -1;
                    }
                }
            }else{
                String[] strArr = str.split(" ");
                for (int i = 1; i <= a; i++) {
                    int value = Integer.parseInt(strArr[i - 1]);
                    if(value == 1){
                        is.add(cCheck + 1);
                        js.add(bCheck + 1);
                        ks.add(i);
                    }
                    tomato[cCheck + 1][bCheck + 1][i] = value;
                }
                bCheck++;
                if(bCheck == b){
                    cCheck++;
                    if(cCheck == c){
                        break;
                    }
                    bCheck = 0;
                }
            }
        }
        //모든 토마토가 익을 수 있는 상태인지를 체크
        boolean isPossible = true;
        //모든 토마토가 익어있는지 상태 체크
        boolean isAlreadyRipen = true;
        for (int i = 1; i <=c ; i++) {
            for (int j = 1; j <=b ; j++) {
                for (int k = 1; k <=a ; k++) {
                    if(tomato[i][j][k] == 0){
                        if(tomato[i-1][j][k] == -1 && tomato[i+1][j][k] == -1
                                && tomato[i][j-1][k] == -1 && tomato[i][j+1][k] == -1
                                && tomato[i][j][k-1] == -1 && tomato[i][j][k+1] == -1){
                            isPossible = false;
                        }
                        isAlreadyRipen = false;
                    }
                }
            }
        }
        if(!isPossible){
            bw.write("-1");
        }else if(isAlreadyRipen){
            bw.write("0");
        }else{
            boolean[][][] check = new boolean[c + 2][b + 2][a + 2];
            LinkedList<Integer> iQueue = new LinkedList<>();
            LinkedList<Integer> jQueue = new LinkedList<>();
            LinkedList<Integer> kQueue = new LinkedList<>();
            int[] lastNodeInDepth = new int[3];
            for (int i = 0; i < is.size(); i++) {
                check[is.get(i)][js.get(i)][ks.get(i)] = true;
                iQueue.offer(is.get(i));
                jQueue.offer(js.get(i));
                kQueue.offer(ks.get(i));
                if(i == is.size() - 1){
                    lastNodeInDepth[0] = is.get(i);
                    lastNodeInDepth[1] = js.get(i);
                    lastNodeInDepth[2] = ks.get(i);
                }
            }
            int maxDepth = 0;
            while(!iQueue.isEmpty()){
                int iNode = iQueue.pop();
                int jNode = jQueue.pop();
                int kNode = kQueue.pop();
                if(tomato[iNode-1][jNode][kNode] == 0 && !check[iNode-1][jNode][kNode]){//위
                    iQueue.offer(iNode - 1);
                    jQueue.offer(jNode);
                    kQueue.offer(kNode);
                    check[iNode-1][jNode][kNode] = true;
                }
                if(tomato[iNode+1][jNode][kNode] == 0 && !check[iNode+1][jNode][kNode]){//아래
                    iQueue.offer(iNode + 1);
                    jQueue.offer(jNode);
                    kQueue.offer(kNode);
                    check[iNode+1][jNode][kNode] = true;
                }
                if(tomato[iNode][jNode-1][kNode] == 0 && !check[iNode][jNode-1][kNode]){//앞
                    iQueue.offer(iNode);
                    jQueue.offer(jNode - 1);
                    kQueue.offer(kNode);
                    check[iNode][jNode-1][kNode] = true;
                }
                if(tomato[iNode][jNode+1][kNode] == 0 && !check[iNode][jNode+1][kNode]){//뒤
                    iQueue.offer(iNode);
                    jQueue.offer(jNode + 1);
                    kQueue.offer(kNode);
                    check[iNode][jNode+1][kNode] = true;
                }
                if(tomato[iNode][jNode][kNode-1] == 0 && !check[iNode][jNode][kNode-1]){//왼
                    iQueue.offer(iNode);
                    jQueue.offer(jNode);
                    kQueue.offer(kNode - 1);
                    check[iNode][jNode][kNode-1] = true;
                }
                if(tomato[iNode][jNode][kNode+1] == 0 && !check[iNode][jNode][kNode+1]){//오른
                    iQueue.offer(iNode);
                    jQueue.offer(jNode);
                    kQueue.offer(kNode + 1);
                    check[iNode][jNode][kNode+1] = true;
                }
                if(iNode == lastNodeInDepth[0] && jNode == lastNodeInDepth[1] && kNode == lastNodeInDepth[2]){
                    if(!iQueue.isEmpty()){
                        maxDepth++;
                        lastNodeInDepth[0] = iQueue.get(iQueue.size() - 1);
                        lastNodeInDepth[1] = jQueue.get(jQueue.size() - 1);
                        lastNodeInDepth[2] = kQueue.get(kQueue.size() - 1);
                    }
                }
            }
            bw.write(String.valueOf(maxDepth));
        }

//        // tomato 배열이 제대로 채워졌는지 확인
//        for (int i = 0; i < c + 2; i++) {
//            for (int j = 0; j < b + 2; j++) {
//                for (int k = 0; k < a + 2; k++) {
//                    bw.write(String.valueOf(tomato[i][j][k]) + " ");
//                }
//                bw.newLine();
//            }
//            bw.newLine();
//        }
        bw.flush();
        bw.close();
        br.close();
    }
}
