package algorithm.baekjoon;

import java.io.*;
import java.util.LinkedList;

public class _12100_2048 {
    private static int N = 0;
    private static int[][] board = null;
    private static int theoreticalMax = 0;

    private static int findMaxValue(){
        int max = 0;
        LinkedList<int[][]> queue = new LinkedList<>();
        queue.addLast(findNextBoard(board, 1));
        queue.addLast(findNextBoard(board, 2));
        queue.addLast(findNextBoard(board, 3));
        queue.addLast(findNextBoard(board, 4));
        int level = 1, levelIndex = 4, index = 0;
        while(!queue.isEmpty()){
            int[][] tmpBoard = queue.pop();
            index++;
            for (int direction = 1; direction <= 4; direction++) {
                queue.addLast(findNextBoard(tmpBoard, direction));
            }
            if(index == levelIndex){
                level++;
                if(level == 5){
                    break;
                }
                levelIndex *= 4;
                index = 0;
            }
        }
        for (int[][] tmpBoard : queue) {
            int tmpMax = maxNumInBoard(tmpBoard);
            if(max < tmpMax){
                max = tmpMax;
                if(max == theoreticalMax){
                    break;
                }
            }
        }
        return max;
    }

    private static int[][] findNextBoard(int[][] current, int direction){
        int[][] nextBoard = new int[N][N];
        if(direction == 1){
            for (int j = 0; j < N; j++) {
                int index = 0;
                int num = 0;
                for (int i = 0; i < N; i++) {
                    if(num == 0){
                        if(current[i][j] != 0){
                            num = current[i][j];
                        }
                    }else{
                        if(current[i][j] != 0){
                            if(num == current[i][j]){
                                nextBoard[index++][j] = num * 2;
                                num = 0;
                            }else{
                                nextBoard[index++][j] = num;
                                num = current[i][j];
                            }
                        }
                    }
                }
                if(num != 0){
                    nextBoard[index++][j] = num;
                }
            }
        }else if(direction == 2){
            for (int j = 0; j < N; j++) {
                int index = N - 1;
                int num = 0;
                for (int i = N - 1; i >= 0; i--) {
                    if(num == 0){
                        if(current[i][j] != 0){
                            num = current[i][j];
                        }
                    }else{
                        if(current[i][j] != 0){
                            if(num == current[i][j]){
                                nextBoard[index--][j] = num * 2;
                                num = 0;
                            }else{
                                nextBoard[index--][j] = num;
                                num = current[i][j];
                            }
                        }
                    }
                }
                if(num != 0){
                    nextBoard[index--][j] = num;
                }
            }
        }else if(direction == 3){
            for (int i = 0; i < N; i++) {
                int index = 0;
                int num = 0;
                for (int j = 0; j < N; j++) {
                    if(num == 0){
                        if(current[i][j] != 0){
                            num = current[i][j];
                        }
                    }else{
                        if(current[i][j] != 0){
                            if(num == current[i][j]){
                                nextBoard[i][index++] = num * 2;
                                num = 0;
                            }else{
                                nextBoard[i][index++] = num;
                                num = current[i][j];
                            }
                        }
                    }
                }
                if(num != 0){
                    nextBoard[i][index++] = num;
                }
            }
        }else{
            for (int i = 0; i < N; i++) {
                int index = N - 1;
                int num = 0;
                for (int j = N - 1; j >= 0; j--) {
                    if(num == 0){
                        if(current[i][j] != 0){
                            num = current[i][j];
                        }
                    }else{
                        if(current[i][j] != 0){
                            if(num == current[i][j]){
                                nextBoard[i][index--] = num * 2;
                                num = 0;
                            }else{
                                nextBoard[i][index--] = num;
                                num = current[i][j];
                            }
                        }
                    }
                }
                if(num != 0){
                    nextBoard[i][index--] = num;
                }
            }
        }
        return nextBoard;
    }

    private static int maxNumInBoard(int[][] tmpBoard){
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(max < tmpBoard[i][j]){
                    max = tmpBoard[i][j];
                    if(max == theoreticalMax){
                        break;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int nFreq = 0;
        while((str = br.readLine()) != null){
            if(N == 0){
                N = Integer.parseInt(str);
                board = new int[N][N];
            }else{
                String[] strArr = str.split(" ");
                for (int i = 0; i < N; i++) {
                    int num = Integer.parseInt(strArr[i]);
                    theoreticalMax += num;
                    board[nFreq][i] = num;
                }
                nFreq++;
                if(nFreq == N){
                    bw.write(String.valueOf(findMaxValue()));
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
