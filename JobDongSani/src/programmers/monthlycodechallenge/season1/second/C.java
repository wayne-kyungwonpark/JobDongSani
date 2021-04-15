package programmers.monthlycodechallenge.season1.second;

import java.util.Arrays;

// floyd
public class C {
    public static void main(String[] args) {
//        int n = 5;
//        int[][] edges = {{1,5},{2,5},{3,5},{4,5}};
        int n = 4;
        int[][] edges = {{1,2},{2,3},{3,4}};
        System.out.println(solution(n, edges));
    }

    public static int solution(int n, int[][] edges) {
        int answer = 0;

        int[][] d = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i != j){
                    d[i][j] = 987654321;
                }
            }
        }

        for (int i = 0; i < edges.length; i++) {
            d[edges[i][0]][edges[i][1]] = 1;
            d[edges[i][1]][edges[i][0]] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(d[i][k] + d[k][j] < d[i][j]){
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }

        for (int root = 1; root <= n; root++) {
            int[] arr = d[root];
            Arrays.sort(arr);
            if(answer == 0 || answer < arr[arr.length - 2]){
                answer = arr[arr.length - 2];
            }
        }

        return answer;
    }
}
