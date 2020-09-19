package programmers.blindtest2020_mock;

import java.util.*;

public class BlockMoving {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};
        System.out.println(solution(board));
    }

    private static int[][][] diff = {
        {{-1, 0}, {-1, 0}},
        {{1, 0}, {1, 0}},
        {{0, -1}, {0, -1}},
        {{0, 1}, {0, 1}}
    };

    // first, second diff, first 기준 board 값을 체크해봐야 할 상대거리
    private static int[][][] rotate1 = { // 수평 -> 수직
            {{0, 0}, {-1, -1}, {-1, 1}},
            {{-1, 1}, {0, 0}, {-1, 0}},
            {{0, 0}, {1, -1}, {1, 1}},
            {{1, 1}, {0, 0}, {1, 0}}
    };

    private static int[][][] rotate2 = { // 수직 -> 수평
            {{0, 0}, {-1, -1}, {1, -1}},
            {{1, -1}, {0, 0}, {0, -1}},
            {{0, 0}, {-1, 1}, {1, 1}},
            {{1, 1}, {0, 0}, {0, 1}}
    };

    public static int solution(int[][] board) {
        int answer = 0;
        int N = board.length;
        CoordinatePair start = new CoordinatePair(new Coordinate(0, 0), new Coordinate(0, 1));
        CoordinatePair end1 = new CoordinatePair(new Coordinate(N - 1, N - 2), new Coordinate(N - 1, N - 1));
        CoordinatePair end2 = new CoordinatePair(new Coordinate(N - 2, N - 1), new Coordinate(N - 1, N - 1));

        Queue<CoordinatePair> queue = new LinkedList<>();
        queue.offer(start);
        Set<CoordinatePair> visit = new HashSet<>();
        visit.add(start);
        boolean find = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                CoordinatePair cur = queue.poll();
                if(cur.equals(end1) || cur.equals(end2)){
                    find = true;
                    break;
                }
                Coordinate first = cur.first;
                Coordinate second = cur.second;
                for(int[][] unit : diff){
                    int fx = first.x + unit[0][0];
                    int fy = first.y + unit[0][1];
                    int sx = second.x + unit[1][0];
                    int sy = second.y + unit[1][1];
                    if(fx < 0 || fy < 0 || sx < 0 || sy < 0 || fx > N - 1 || fy > N - 1 || sx > N - 1 || sy > N - 1){
                        continue;
                    }
                    if(board[fx][fy] == 1 || board[sx][sy] == 1){
                        continue;
                    }
                    CoordinatePair next = new CoordinatePair(new Coordinate(fx, fy), new Coordinate(sx, sy));
                    if(visit.contains(next)){
                       continue;
                    }
                    queue.offer(next);
                    visit.add(next);
                }

                int[][][] rotate = null;
                if(first.x == second.x){ // 수평
                    rotate = rotate1;
                }else{ // 수직
                    rotate = rotate2;
                }
                for(int[][] unit : rotate){
                    int fx = first.x + unit[0][0];
                    int fy = first.y + unit[0][1];
                    int sx = second.x + unit[1][0];
                    int sy = second.y + unit[1][1];
                    int checkx = first.x + unit[2][0];
                    int checky = first.y + unit[2][1];
                    if(fx < 0 || fy < 0 || sx < 0 || sy < 0 || fx > N - 1 || fy > N - 1 || sx > N - 1 || sy > N - 1
                        || checkx < 0 || checky < 0 || checkx > N - 1 || checky > N - 1){
                        continue;
                    }
                    if(board[fx][fy] == 1 || board[sx][sy] == 1){
                        continue;
                    }
                    if(board[checkx][checky] == 1){
                        continue;
                    }
                    CoordinatePair next = new CoordinatePair(new Coordinate(fx, fy), new Coordinate(sx, sy));
                    if(visit.contains(next)){
                        continue;
                    }
                    queue.offer(next);
                    visit.add(next);
                }
            }
            if(find){
                break;
            }
            answer++;
        }

        return answer;
    }

    private static class CoordinatePair{
        Coordinate first;
        Coordinate second;

        public CoordinatePair(Coordinate first, Coordinate second) {
            if(first.x + first.y > second.x + second.y){
                this.first = second;
                this.second = first;
            }else{
                this.first = first;
                this.second = second;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CoordinatePair that = (CoordinatePair) o;
            return (Objects.equals(first, that.first) &&
                    Objects.equals(second, that.second));
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    private static class Coordinate{
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
