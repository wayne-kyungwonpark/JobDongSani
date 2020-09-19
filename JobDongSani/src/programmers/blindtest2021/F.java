package programmers.blindtest2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class F {
    public static void main(String[] args) {
        int[][] board = {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
        int r = 1;
        int c = 0;
        System.out.println(solution(board, r, c));
    }

    private static int N = 4;
    private static int minValue = 987654321;
    private static int card = 0;
    private static Map<Integer, int[][]> cardLocation;
    private static boolean[] visit;

    public static int solution(int[][] board, int r, int c) {
        minValue = 987654321;
        card = 0;
        cardLocation = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] != 0){
                    card = Math.max(card, board[i][j]);
                    if(!cardLocation.containsKey(board[i][j])){
                        int[][] element = new int[2][2];
                        element[0][0] = i;
                        element[0][1] = j;
                        cardLocation.put(board[i][j], element);
                    }else{
                        int[][] element = cardLocation.get(board[i][j]);
                        element[1][0] = i;
                        element[1][1] = j;
                    }
                }
            }
        }

        visit = new boolean[card + 1];
        findAnswer(board, r, c, card, 0);

        return minValue;
    }

    private static void findAnswer(int[][] board, int r, int c, int rest, int cost) {
        if(rest == 0){
            minValue = Math.min(minValue, cost);
            return;
        }

        for (int i = 1; i <= card; i++) {
            if(visit[i]){
               continue;
            }
            visit[i] = true;

            int[][] location = cardLocation.get(i);
            int x1 = location[0][0];
            int y1 = location[0][1];
            int x2 = location[1][0];
            int y2 = location[1][1];

            // (r, c) -> (x1, y1) -> (x2, y2)
            int cost1to2 = 0;
            boolean[][] check = new boolean[N][N];
            check[r][c] = true;
            cost1to2 += findCost(board, r, c, x1, y1, 0, check);
            cost1to2++; // (x1, y1) 선택
            check = new boolean[N][N];
            check[x1][y1] = true;
            cost1to2 += findCost(board, x1, y1, x2, y2, 0, check);
            cost1to2++; // (x2, y2) 선택

            // (r, c) -> (x2, y2) -> (x1, y1)
            int cost2to1 = 0;
            check = new boolean[N][N];
            check[r][c] = true;
            cost2to1 += findCost(board, r, c, x2, y2, 0, check);
            cost2to1++; // (x2, y2) 선택
            check = new boolean[N][N];
            check[x2][y2] = true;
            cost2to1 += findCost(board, x2, y2, x1, y1, 0, check);
            cost2to1++; // (x1, y1) 선택


            findAnswer(board, x2, y2, rest - 1, cost + cost1to2);
            findAnswer(board, x1, y1, rest - 1, cost + cost2to1);
            visit[i] = false;
        }
    }

    private static int findCost(int[][] board, int x1, int y1, int x2, int y2, int prevCost, boolean[][] check) {
        // (x1, y1), (x2, y2) 로 만들 수 있는 직사각형 범위 내에서 visit해서 없는 카드를 제외하고 최단경로를 찾는다.
        // (x2, y2)에는 카드가 있음이 가정된다.

        // 1. 한 축에 있을 경우 (4 x 4 일 경우 직선으로 바로 가는 것이 돌아서 가는 것보다 무조건 cost가 작다)
        if(x1 == x2){
            if(y1 == y2){
                return prevCost;
            }else{
                int cost = prevCost;
                if(y1 < y2){
                    for (int i = y1 + 1; i < y2; i++) {
                        if(board[x1][i] != 0 && !visit[board[x1][i]]){
                            cost++;
                        }
                    }
                }else{
                    for (int i = y1 - 1; i > y2; i--) {
                        if(board[x1][i] != 0 && !visit[board[x1][i]]){
                            cost++;
                        }
                    }
                }
                return cost + 1;
            }
        }
        if(y1 == y2){
            if(x1 == x2){
                return 0;
            }else{
                int cost = 0;
                if(x1 < x2){
                    for (int i = x1 + 1; i < x2; i++) {
                        if(board[i][y1] != 0 && !visit[board[i][y1]]){
                            cost++;
                        }
                    }
                }else{
                    for (int i = x1 - 1; i > x2; i--) {
                        if(board[i][y1] != 0 && !visit[board[i][y1]]){
                            cost++;
                        }
                    }
                }
                return cost + 1;
            }
        }

        // 2. 다른 축에 있을 경우
        int cost = prevCost + Math.abs(x1 - x2) + Math.abs(y1 - y2);

        if(x1 < x2){
            int lastCardIndex = x1;
            int tmpCost = 0;
            for (int i = x1 + 1; i <= x2; i++) {
                if(board[i][y1] != 0 && !visit[board[i][y1]]){
                    if(!check[i][y1]){
                        check[i][y1] = true;
                        cost = Math.min(cost, findCost(board, i, y1, x2, y2, prevCost + tmpCost + 1, check));
                        lastCardIndex = i;
                        tmpCost++;
                        check[i][y1] = false;
                    }
                }else{
                    if(!check[i][y1]){
                        check[i][y1] = true;
                        cost = Math.min(cost, findCost(board, i, y1, x2, y2, prevCost + tmpCost + (i - lastCardIndex), check));
                        check[i][y1] = false;
                    }
                }
            }
            if(x1 != 0){
                lastCardIndex = x1;
                tmpCost = 0;
                for (int i = x1 - 1; i >= 0; i--) {
                    if(board[i][y1] != 0 && !visit[board[i][y1]]){
                        if(!check[i][y1]){
                            check[i][y1] = true;
                            cost = Math.min(cost, findCost(board, i, y1, x2, y2, prevCost + tmpCost + 1, check));
                            lastCardIndex = i;
                            tmpCost++;
                            check[i][y1] = false;
                        }
                    }else{
                        if(!check[i][y1]){
                            check[i][y1] = true;
                            cost = Math.min(cost, findCost(board, i, y1, x2, y2, prevCost + tmpCost + (lastCardIndex - i), check));
                            check[i][y1] = false;
                        }
                    }
                }
            }
        }else{
            int lastCardIndex = x1;
            int tmpCost = 0;
            for (int i = x1 - 1; i >= x2; i--) {
                if(board[i][y1] != 0 && !visit[board[i][y1]]){
                    if(!check[i][y1]){
                        check[i][y1] = true;
                        cost = Math.min(cost, findCost(board, i, y1, x2, y2, prevCost + tmpCost + 1, check));
                        lastCardIndex = i;
                        tmpCost++;
                        check[i][y1] = false;
                    }
                }else{
                    if(!check[i][y1]){
                        check[i][y1] = true;
                        cost = Math.min(cost, findCost(board, i, y1, x2, y2, prevCost + tmpCost + (lastCardIndex - i), check));
                        check[i][y1] = false;
                    }
                }
            }
            if(x1 != N - 1){
                lastCardIndex = x1;
                tmpCost = 0;
                for (int i = x1 + 1; i < N; i++) {
                    if(board[i][y1] != 0 && !visit[board[i][y1]]){
                        if(!check[i][y1]){
                            check[i][y1] = true;
                            cost = Math.min(cost, findCost(board, i, y1, x2, y2, prevCost + tmpCost + 1, check));
                            lastCardIndex = i;
                            tmpCost++;
                            check[i][y1] = false;
                        }
                    }else{
                        if(!check[i][y1]){
                            check[i][y1] = true;
                            cost = Math.min(cost, findCost(board, i, y1, x2, y2, prevCost + tmpCost + (i - lastCardIndex), check));
                            check[i][y1] = false;
                        }
                    }
                }
            }
        }

        if(y1 < y2){
            int lastCardIndex = y1;
            int tmpCost = 0;
            for (int i = y1 + 1; i <= y2; i++) {
                if(board[x1][i] != 0 && !visit[board[x1][i]]){
                    if(!check[x1][i]){
                        check[x1][i] = true;
                        cost = Math.min(cost, findCost(board, x1, i, x2, y2, prevCost + tmpCost + 1, check));
                        lastCardIndex = i;
                        tmpCost++;
                        check[x1][i] = false;
                    }
                }else{
                    if(!check[x1][i]){
                        check[x1][i] = true;
                        cost = Math.min(cost, findCost(board, x1, i, x2, y2, prevCost + tmpCost + (i - lastCardIndex), check));
                        check[x1][i] = false;
                    }
                }
            }
            if(y1 != 0){
                lastCardIndex = y1;
                tmpCost = 0;
                for (int i = y1 - 1; i >= 0; i--) {
                    if(board[x1][i] != 0 && !visit[board[x1][i]]){
                        if(!check[x1][i]){
                            check[x1][i] = true;
                            cost = Math.min(cost, findCost(board, x1, i, x2, y2, prevCost + tmpCost + 1, check));
                            lastCardIndex = i;
                            tmpCost++;
                            check[x1][i] = false;
                        }
                    }else{
                        if(!check[x1][i]){
                            check[x1][i] = true;
                            cost = Math.min(cost, findCost(board, x1, i, x2, y2, prevCost + tmpCost + (lastCardIndex - i), check));
                            check[x1][i] = false;
                        }
                    }
                }
            }
        }else{
            int lastCardIndex = y1;
            int tmpCost = 0;
            for (int i = y1 - 1; i >= y2; i--) {
                if(board[x1][i] != 0 && !visit[board[x1][i]]){
                    if(!check[x1][i]){
                        check[x1][i] = true;
                        cost = Math.min(cost, findCost(board, x1, i, x2, y2, prevCost + tmpCost + 1, check));
                        lastCardIndex = i;
                        tmpCost++;
                        check[x1][i] = false;
                    }
                }else{
                    if(!check[x1][i]){
                        check[x1][i] = true;
                        cost = Math.min(cost, findCost(board, x1, i, x2, y2, prevCost + tmpCost + (lastCardIndex - i), check));
                        check[x1][i] = false;
                    }
                }
            }
            if(y1 != N - 1){
                lastCardIndex = y1;
                tmpCost = 0;
                for (int i = y1 + 1; i < N; i++) {
                    if(board[x1][i] != 0 && !visit[board[x1][i]]){
                        if(!check[x1][i]){
                            check[x1][i] = true;
                            cost = Math.min(cost, findCost(board, x1, i, x2, y2, prevCost + tmpCost + 1, check));
                            lastCardIndex = i;
                            tmpCost++;
                            check[x1][i] = false;
                        }
                    }else{
                        if(!check[x1][i]){
                            check[x1][i] = true;
                            cost = Math.min(cost, findCost(board, x1, i, x2, y2, prevCost + tmpCost + (i - lastCardIndex), check));
                            check[x1][i] = false;
                        }
                    }
                }
            }
        }

        return cost;
    }
}
