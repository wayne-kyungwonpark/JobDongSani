package brandi.firstround;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B {
    private static int[][] dis = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] house = new int[N][N];
        int spaces = 0;
        for (int i = 0; i < N; i++) {
            String[] strArr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                house[i][j] = Integer.parseInt(strArr[j]);
                if(house[i][j] == 0){
                    spaces++;
                }
            }
        }

        int max = safety(house, N, spaces);
        if(dist(0, 0, N - 1, N - 1, house, N) == Integer.MAX_VALUE){
            System.out.println(max);
            return;
        }

        for (int i = N; i <= 2 * (N - 1) - 1; i++) {
            for (int j = i - (N - 1); j < N; j++) {
                if(house[j][i - j] == 1){
                    continue;
                }
                int waterDist = dist(0, 0, j, i - j, house, N);
                int personDist = dist(N - 1, N - 1, j, i - j, house, N);
                if((waterDist == Integer.MAX_VALUE && personDist != Integer.MAX_VALUE) || waterDist > personDist){
                    house[j][i - j] = 1;
                    max = Math.max(max, safety(house, N, spaces - 1));
                    house[j][i - j] = 0;
                }
            }
        }
        System.out.println(max);
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

    private static int safety(int[][] house, int N, int spaces){
        int water = 1;
        boolean[][] visit = new boolean[N][N];
        Queue<Integer> rowQ = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();
        rowQ.offer(0);
        colQ.offer(0);
        visit[0][0] = true;
        while(!rowQ.isEmpty()){
            int row = rowQ.poll();
            int col = colQ.poll();
            for (int i = 0; i < dis.length; i++) {
                int rowTmp = row + dis[i][0];
                int colTmp = col + dis[i][1];
                if(rowTmp < 0 || rowTmp >= N || colTmp < 0 || colTmp >= N){
                    continue;
                }
                if(house[rowTmp][colTmp] == 0 && !visit[rowTmp][colTmp]){
                    rowQ.offer(rowTmp);
                    colQ.offer(colTmp);
                    water++;
                    visit[rowTmp][colTmp] = true;
                }
            }
        }
        return spaces - water;
    }
}
