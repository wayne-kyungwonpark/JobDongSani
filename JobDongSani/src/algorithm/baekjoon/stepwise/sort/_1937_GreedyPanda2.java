package algorithm.baekjoon.stepwise.sort;
import java.util.Scanner;

public class _1937_GreedyPanda2 {
    private static int n;
    private static int[][] forest;

    private static int K = 1;

    // 왼 위 오 아
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        forest = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                forest[i][j] = sc.nextInt();
            }
        }

        int[][] visit = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                K = Math.max(K,solution(visit, i, j));
            }
        }

        System.out.println(K);

        sc.close();
    }

    private static int solution(int[][] visit, int curX, int curY) {
        int nextM = curX;
        int nextN = curY;

        if(visit[curX][curY] != 0) {
            return visit[curX][curY];
        }

        visit[curX][curY] = 1;
        // visit[curX][curY] == 0
        for(int i = 0; i < 4; i++) {
            nextM += dx[i];
            nextN += dy[i];

            if(nextM >= n || nextN >= n || nextM < 0 || nextN < 0) {
                nextM -= dx[i];
                nextN -= dy[i];
                continue;
            }

            if(forest[curX][curY] < forest[nextM][nextN]) {
                visit[curX][curY] = Math.max(visit[curX][curY], solution(visit, nextM, nextN)+1);

            }
            nextM -= dx[i];
            nextN -= dy[i];
        }

        return visit[curX][curY];
    }

}