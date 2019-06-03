package algorithm.samsung;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class _7733_CheeseThief {
    private static int testNum = 0;
    private static int N = 0;
    private static int maxDay = 0;
    private static StringBuilder sb = new StringBuilder();
    private static int[][] cheese = null;
    private static int maxChunkNum = 1;

    private static void findMaxChunkNum(){
        boolean[][] eaten = new boolean[N][N];
        for (int i = 1; i <= maxDay; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(cheese[j][k] == i){
                        eaten[j][k] = true;
                    }
                }
            }
            int chunkNum = findChunkNum(eaten);
            if(maxChunkNum < chunkNum){
                maxChunkNum = chunkNum;
            }
        }
    }

    private static int findChunkNum(boolean[][] eaten){
        boolean[][] chunkGroupCheck = new boolean[N][N];
        int chunkGroupNum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!eaten[i][j] && !chunkGroupCheck[i][j]){
                    LinkedList<Integer> row = new LinkedList<>(), col = new LinkedList<>();
                    row.add(i); col.add(j);
                    chunkGroupCheck[i][j] = true;
                    while(!row.isEmpty()){
                        int rowNum = row.removeFirst(), colNum = col.removeFirst();
                        if(rowNum != N - 1 && !eaten[rowNum + 1][colNum] && !chunkGroupCheck[rowNum + 1][colNum]){
                            row.add(rowNum + 1); col.add(colNum);
                            chunkGroupCheck[rowNum + 1][colNum] = true;
                        }
                        if(rowNum != 0 && !eaten[rowNum - 1][colNum] && !chunkGroupCheck[rowNum - 1][colNum]){
                            row.add(rowNum - 1); col.add(colNum);
                            chunkGroupCheck[rowNum - 1][colNum] = true;
                        }
                        if(colNum != N - 1 && !eaten[rowNum][colNum + 1] && !chunkGroupCheck[rowNum][colNum + 1]){
                            row.add(rowNum); col.add(colNum + 1);
                            chunkGroupCheck[rowNum][colNum + 1] = true;
                        }
                        if(colNum != 0 && !eaten[rowNum][colNum - 1] && !chunkGroupCheck[rowNum][colNum - 1]){
                            row.add(rowNum); col.add(colNum - 1);
                            chunkGroupCheck[rowNum][colNum - 1] = true;
                        }
                    }
                    chunkGroupNum++;
                }
            }
        }
        return chunkGroupNum;
    }

    public static void main(String[] args) throws IOException {
//        N = 3;
//        boolean[][] test = {{true, true, false}, {false, false, false}, {false, true, true}};
//        System.out.println(findChunkNum(test));
        Scanner scn = new Scanner(System.in);
        testNum = Integer.parseInt(scn.nextLine());
        for (int i = 0; i < testNum; i++) {
            N = Integer.parseInt(scn.nextLine());
            cheese = new int[N][N];
            for (int j = 0; j < N; j++) {
                String[] strArr = scn.nextLine().split(" ");
                for (int k = 0; k < N; k++) {
                    int day = Integer.parseInt(strArr[k]);
                    cheese[j][k] = day;
                    if(day > maxDay){
                        maxDay = day;
                    }
                }
            }
            findMaxChunkNum();
            sb.append("#").append(i + 1).append(" ").append(maxChunkNum).append("\n");
            N = 0; maxDay = 0; cheese = null; maxChunkNum = 1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        scn.close();
    }
}
