package programmers.blindtest2021;

public class D {
    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(solution(n, s, a, b, fares));
    }

    private static int[][] dist = null;
    private static final int MAX = 987654321;

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;

        dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = MAX;
            }
        }

        for (int i = 0; i < fares.length; i++) {
            int node1 = fares[i][0];
            int node2 = fares[i][1];
            int cost = fares[i][2];
            dist[node1][node2] = cost;
            dist[node2][node1] = cost;
        }

        floyd(n);
        answer = findAnswer(n, s, a, b);

        return answer;
    }

    private static void floyd(int n){
        for (int i = 1; i <= n; i++) {
            dist[i][i] = 0;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j] , dist[i][k] + dist[k][j]);
                    dist[j][i] = dist[i][j];
                }
            }
        }
    }

    private static int findAnswer(int n, int s, int a, int b) {
        int answer = 987654321;
        for (int i = 1; i <= n; i++) {
            if(dist[s][i] != MAX && (dist[i][a] != MAX && dist[i][b] != MAX)){
                answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
            }
        }

        return answer;
    }
}
