package algorithm.samsung;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class _5650_PinballGame {
    private static int findMaxScore(int N, int[][] board, HashMap<Integer, int[]> warmHole,
                                    ArrayList<Integer> blackR, ArrayList<Integer> blackC, boolean doesBlackExist){
        int maxScore = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] == 0){
                    for (int k = 0; k < 4; k++) {
                        int score = findScore(N, board, warmHole, blackR, blackC, doesBlackExist, i, j, k);
                        if(maxScore == 0 || score > maxScore){
                            maxScore = score;
                        }
                    }
                }
            }
        }
        return maxScore;
    }

    private static int findScore(int N, int[][] board, HashMap<Integer, int[]> warmHole,
                                 ArrayList<Integer> blackR, ArrayList<Integer> blackC, boolean doesBlackExist,
                                 int initialR, int initialC, int direction){
        int score = 0;
        boolean go = true;
        int R = initialR, C = initialC;
        int cDirection = direction;
        boolean firstInitialCheck = true;
        while(go){
            if(R == initialR && C == initialC){
                if(!firstInitialCheck){
                    break;
                }else{
                    firstInitialCheck = false;
                }
            }
            if (cDirection == 0){
                if(R == 0){
                    cDirection = 1;
                    score++;
                }else{
                    for (int i = R - 1; i >= 0; i--) {
                        if(board[i][C] == -1){
                            go = false;
                            break;
                        }else if(board[i][C] >= 6){
                            int[] warmPosition = warmHole.get(board[i][C]);
                            if(warmPosition[0] == i && warmPosition[1] == C){
                                if(warmPosition[2] == 0){
                                    R = i;
                                    cDirection = 1;
                                    score++;
                                }else{
                                    R = warmPosition[2];
                                    C = warmPosition[3];
                                }
                            }else{
                                if(warmPosition[0] == 0){
                                    R = i;
                                    cDirection = 1;
                                    score++;
                                }else{
                                    R = warmPosition[0];
                                    C = warmPosition[1];
                                }
                            }
                            break;
                        }else if(board[i][C] >= 1 && board[i][C] <=5){
                            if((C == 0 && board[i][C] == 3) || (C == N - 1 && board[i][C] == 2)){
                                cDirection = 1;
                                score += 3;
                                R = i;
                            }else{
                                cDirection = findNextDirection(cDirection, board[i][C]);
                                score++;
                                R = i;
                            }
                            break;
                        }else if(i == initialR && C == initialC){
                            go = false;
                            break;
                        }
                        if(i == 0){
                            cDirection = 1;
                            R = i;
                            score++;
                            break;
                        }
                    }
                }
                continue;
            }else if(cDirection == 1){
                if(R == N - 1){
                    cDirection = 0;
                    score++;
                }else{
                    for (int i = R + 1; i < N; i++) {
                        if(board[i][C] == -1){
                            go = false;
                            break;
                        }else if(board[i][C] >= 6){
                            int[] warmPosition = warmHole.get(board[i][C]);
                            if(warmPosition[0] == i && warmPosition[1] == C){
                                if(warmPosition[2] == N - 1){
                                    R = i;
                                    cDirection = 0;
                                    score++;
                                }else{
                                    R = warmPosition[2];
                                    C = warmPosition[3];
                                }
                            }else{
                                if(warmPosition[0] == N - 1){
                                    R = i;
                                    cDirection = 0;
                                    score++;
                                }else{
                                    R = warmPosition[0];
                                    C = warmPosition[1];
                                }
                            }
                            break;
                        }else if(board[i][C] >= 1 && board[i][C] <= 5){
                            if((C == 0 && board[i][C] == 4) || (C == N - 1 && board[i][C] == 1)){
                                cDirection = 0;
                                score += 3;
                                R = i;
                            }else{
                                cDirection = findNextDirection(cDirection, board[i][C]);
                                score++;
                                R = i;
                            }
                            break;
                        }else if(i == initialR && C == initialC){
                            go = false;
                            break;
                        }
                        if(i == N - 1){
                            cDirection = 0;
                            R = i;
                            score++;
                            break;
                        }
                    }
                }
                continue;
            }else if(cDirection == 2){
                if(C == 0){
                    cDirection = 3;
                    score++;
                }else{
                    for (int i = C - 1; i >= 0; i--) {
                        if(board[R][i] == -1){
                            go = false;
                            break;
                        }else if(board[R][i] >= 6){
                            int[] warmPosition = warmHole.get(board[R][i]);
                            if(warmPosition[0] == R && warmPosition[1] == i){
                                if(warmPosition[3] == 0){
                                    C = i;
                                    cDirection = 3;
                                    score++;
                                }else{
                                    R = warmPosition[2];
                                    C = warmPosition[3];
                                }
                            }else{
                                if(warmPosition[1] == 0){
                                    C = i;
                                    cDirection = 3;
                                    score++;
                                }else{
                                    R = warmPosition[0];
                                    C = warmPosition[1];
                                }
                            }
                            break;
                        }else if(board[R][i] >= 1 && board[R][i] <= 5){
                            if((R == 0 && board[R][i] == 1) || (R == N - 1 && board[R][i] == 2)){
                                cDirection = 3;
                                score += 3;
                                C = i;
                            }else{
                                cDirection = findNextDirection(cDirection, board[R][i]);
                                score++;
                                C = i;
                            }
                            break;
                        }else if(R == initialR && i == initialC){
                            go = false;
                            break;
                        }
                        if(i == 0){
                            cDirection = 3;
                            C = i;
                            score++;
                            break;
                        }
                    }
                }
                continue;
            }else if(cDirection == 3){
                if(C == N - 1){
                    cDirection = 2;
                    score++;
                }else{
                    for (int i = C + 1; i <= N; i++) {
                        if(board[R][i] == -1){
                            go = false;
                            break;
                        }else if(board[R][i] >= 6){
                            int[] warmPosition = warmHole.get(board[R][i]);
                            if(warmPosition[0] == R && warmPosition[1] == i){
                                if(warmPosition[3] == N - 1){
                                    C = i;
                                    cDirection = 2;
                                    score++;
                                }else{
                                    R = warmPosition[2];
                                    C = warmPosition[3];
                                }
                            }else{
                                if(warmPosition[1] == N - 1){
                                    C = i;
                                    cDirection = 2;
                                    score++;
                                }else{
                                    R = warmPosition[0];
                                    C = warmPosition[1];
                                }
                            }
                            break;
                        }else if(board[R][i] >= 1 && board[R][i] <= 5){
                            if((R == 0 && board[R][i] == 4) || (R == N - 1 && board[R][i] == 3)){
                                cDirection = 2;
                                score += 3;
                                C = i;
                            }else{
                                cDirection = findNextDirection(cDirection, board[R][i]);
                                score++;
                                C = i;
                            }
                            break;
                        }else if(R == initialR && i == initialC){
                            go = false;
                            break;
                        }
                        if(i == N - 1){
                            cDirection = 2;
                            C = i;
                            score++;
                            break;
                        }
                    }
                }
                continue;
            }
        }
        return score;
    }

    private static int findNextDirection(int cDirection, int block){
        if(cDirection == 0){
            if (block == 1) {
                return 1;
            } else if (block == 2) {
                return 3;
            } else if (block == 3) {
                return 2;
            } else if (block == 4) {
                return 1;
            } else {
                return 1;
            }
        }else if(cDirection == 1){
            if (block == 1) {
                return 3;
            } else if (block == 2) {
                return 0;
            } else if (block == 3) {
                return 0;
            } else if (block == 4) {
                return 2;
            } else {
                return 0;
            }
        }else if(cDirection == 2){
            if (block == 1) {
                return 0;
            } else if (block == 2) {
                return 1;
            } else if (block == 3) {
                return 3;
            } else if (block == 4) {
                return 3;
            } else {
                return 3;
            }
        }else{
            if (block == 1) {
                return 2;
            } else if (block == 2) {
                return 2;
            } else if (block == 3) {
                return 1;
            } else if (block == 4) {
                return 0;
            } else {
                return 2;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int testNum = 0, testFreq = 0;
        int N = 0, NFreq = 0;
        int[][] board = null;
        HashMap<Integer, int[]> warmHole = null;
        ArrayList<Integer> blackR = null;
        ArrayList<Integer> blackC = null;
        boolean doesBlackExist = false;
        while((str = br.readLine()) != null){
            if(testNum == 0){
                testNum = Integer.parseInt(str);
            }else{
                if(N == 0){
                    N = Integer.parseInt(str);
                    board = new int[N][N];
                }else{
                    String[] strArr = str.split(" ");
                    for (int i = 0; i < N; i++) {
                        int boardNum = Integer.parseInt(strArr[i]);
                        if(boardNum == -1){
                            if(!doesBlackExist) {
                                blackR = new ArrayList<>();
                                blackC = new ArrayList<>();
                                doesBlackExist = true;
                            }
                            blackR.add(NFreq);
                            blackC.add(i);
                        }
                        if(boardNum >= 6){
                            if(warmHole == null){
                                warmHole = new HashMap<>();
                            }
                            if(!warmHole.containsKey(boardNum)){
                                warmHole.put(boardNum, new int[4]);
                                warmHole.get(boardNum)[0] = NFreq;
                                warmHole.get(boardNum)[1] = i;
                            }else{
                                warmHole.get(boardNum)[2] = NFreq;
                                warmHole.get(boardNum)[3] = i;
                            }
                        }
                        board[NFreq][i] = boardNum;
                    }
                    NFreq++;
                    if(N == NFreq){
                        testFreq++;
                        bw.write("#" + String.valueOf(testFreq) + " " + String.valueOf(findMaxScore(N, board, warmHole, blackR, blackC, doesBlackExist)));
                        N = 0;
                        NFreq = 0;
                        board = null;
                        warmHole = null;
                        blackR = null;
                        blackC = null;
                        doesBlackExist = false;
                        if(testNum == testFreq){
                            break;
                        }else{
                            bw.newLine();
                        }
                    }
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
