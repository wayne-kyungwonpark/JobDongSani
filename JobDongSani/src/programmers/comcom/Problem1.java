package programmers.comcom;

import java.util.Arrays;
import java.util.LinkedList;

public class Problem1 {
    public int solution(int[][] board, int c) {
        int answer = 0;
        int[] robot = new int[2];
        int[] target = new int[2];
        findRobotAndTarget(board, robot, target);
        boolean[][] checks = new boolean[board.length][board[0].length];
        int[][] costs = new int[board.length][board[0].length];
        bfs(board, c, robot[0], robot[1], checks, 0, costs);
        return costs[target[0]][target[1]];
    }

    public void bfs(int[][] board, int c, int row, int col, boolean[][] checks, int cost, int[][] costs){
        LinkedList<Integer> rows = new LinkedList<>();
        LinkedList<Integer> cols = new LinkedList<>();
        rows.add(row);
        cols.add(col);
        while(!rows.isEmpty()){
            int tmpRow = rows.removeFirst();
            int tmpCol = cols.removeFirst();
            if(tmpRow != 0){
                int nextCost = costs[tmpRow][tmpCol] + 1;
                if(board[tmpRow - 1][tmpCol] == 1){
                    nextCost += c;
                }
                if(!checks[tmpRow - 1][tmpCol]){
                    rows.add(tmpRow - 1);
                    cols.add(tmpCol);
                    costs[tmpRow - 1][tmpCol] = nextCost;
                    checks[tmpRow - 1][tmpCol] = true;
                }else{
                    if(costs[tmpRow - 1][tmpCol] > nextCost){
                        rows.add(tmpRow - 1);
                        cols.add(tmpCol);
                        costs[tmpRow - 1][tmpCol] = nextCost;
                    }
                }
            }
            if(tmpRow != board.length - 1){
                int nextCost = costs[tmpRow][tmpCol] + 1;
                if(board[tmpRow + 1][tmpCol] == 1){
                    nextCost += c;
                }
                if(!checks[tmpRow + 1][tmpCol]){
                    rows.add(tmpRow + 1);
                    cols.add(tmpCol);
                    costs[tmpRow + 1][tmpCol] = nextCost;
                    checks[tmpRow + 1][tmpCol] = true;
                }else{
                    if(costs[tmpRow + 1][tmpCol] > nextCost){
                        rows.add(tmpRow + 1);
                        cols.add(tmpCol);
                        costs[tmpRow + 1][tmpCol] = nextCost;
                    }
                }
            }
            if(tmpCol != 0){
                int nextCost = costs[tmpRow][tmpCol] + 1;
                if(board[tmpRow][tmpCol - 1] == 1){
                    nextCost += c;
                }
                if(!checks[tmpRow][tmpCol - 1]){
                    rows.add(tmpRow);
                    cols.add(tmpCol - 1);
                    costs[tmpRow][tmpCol - 1] = nextCost;
                    checks[tmpRow][tmpCol - 1] = true;
                }else{
                    if(costs[tmpRow][tmpCol - 1] > nextCost){
                        rows.add(tmpRow);
                        cols.add(tmpCol - 1);
                        costs[tmpRow][tmpCol - 1] = nextCost;
                    }
                }
            }
            if(tmpCol != board[0].length - 1){
                int nextCost = costs[tmpRow][tmpCol] + 1;
                if(board[tmpRow][tmpCol + 1] == 1){
                    nextCost += c;
                }
                if(!checks[tmpRow][tmpCol + 1]){
                    rows.add(tmpRow);
                    cols.add(tmpCol + 1);
                    costs[tmpRow][tmpCol + 1] = nextCost;
                    checks[tmpRow][tmpCol + 1] = true;
                }else{
                    if(costs[tmpRow][tmpCol + 1] > nextCost){
                        rows.add(tmpRow);
                        cols.add(tmpCol + 1);
                        costs[tmpRow][tmpCol + 1] = nextCost;
                    }
                }
            }
        }
    }

    public void findRobotAndTarget(int[][] board, int[] robot, int[] target){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 2){
                    robot[0] = i;
                    robot[1] = j;
                }
                if(board[i][j] == 3){
                    target[0] = i;
                    target[1] = j;
                }
            }
        }
    }
}
