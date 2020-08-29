package brandi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class D {
    private static int[][] dis = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int[][] dp = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Nd = br.readLine().split(" ");
        int N = Integer.parseInt(Nd[0]);
        int d = Integer.parseInt(Nd[1]);
        int[][] pond = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] strArr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                pond[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(pond[i][j] == 0){
                    max = Math.max(max, spread(pond, N, i, j, d));
                }
            }
        }
        System.out.println(max);
    }

    private static int spread(int[][] pond, int N, int startR, int startC, int d){
        int nums = 0;
        Queue<Integer> rowQ = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();
        boolean[][] visit = new boolean[N][N];
        rowQ.offer(startR);
        colQ.offer(startC);
        visit[startR][startC] = true;
        while(!rowQ.isEmpty()){
            nums++;
            int row = rowQ.poll();
            int col = colQ.poll();
            for (int i = 0; i < dis.length; i++) {
                int rowTmp = row + dis[i][0];
                int colTmp = col + dis[i][1];
                if(rowTmp < 0 || rowTmp >= N || colTmp < 0 || colTmp >= N){
                    continue;
                }
                if(Math.abs(startR - rowTmp) + Math.abs(startC - colTmp) > d){
                    continue;
                }
                if(dist(startR, startC, rowTmp, colTmp, pond, N) > d){
                    continue;
                }
                if(pond[rowTmp][colTmp] == 0 && !visit[rowTmp][colTmp]){
                    visit[rowTmp][colTmp] = true;
                    rowQ.offer(rowTmp);
                    colQ.offer(colTmp);
                }
            }
        }

        return nums;
    }

    private static int dist(int startR, int startC, int targetR, int targetC, int[][] house, int N){
        boolean[][] walked = new boolean[N][N];
        Queue<Integer> rowQ = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();
        rowQ.offer(startR);
        colQ.offer(startC);
        walked[startR][startC] = true;
        int level = 1;
        while(!rowQ.isEmpty()){
            int size = rowQ.size();
            for (int i = 0; i < size; i++) {
                int row = rowQ.poll();
                int col = colQ.poll();
                if(row == targetR && col == targetC){
                    return level - 1;
                }
                for (int d = 0; d < dis.length; d++) {
                    int rowTmp = row + dis[d][0];
                    int colTmp = col + dis[d][1];
                    if(rowTmp < 0 || rowTmp >= N || colTmp < 0 || colTmp >= N){
                        continue;
                    }
                    if(house[rowTmp][colTmp] == 0 && !walked[rowTmp][colTmp]){
                        rowQ.offer(rowTmp);
                        colQ.offer(colTmp);
                        walked[rowTmp][colTmp] = true;
                    }
                }
            }
            level++;
        }
        return Integer.MAX_VALUE;
    }

//    private static double distance(int x1, int y1, int x2, int y2){
//        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
//    }

}
