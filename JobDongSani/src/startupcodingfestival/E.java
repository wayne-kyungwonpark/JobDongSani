package startupcodingfestival;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        char[][] screen = new char[M][N];
        for (int i = 0; i < M; i++) {
            screen[i] = br.readLine().toCharArray();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if(screen[0][i] != 'c'){
                continue;
            }

            boolean find = false;
            Queue<Integer> rows = new LinkedList<>();
            Queue<Integer> cols = new LinkedList<>();
            boolean[][] check = new boolean[M][N];
            int mov = 0;
            rows.offer(0);
            cols.offer(i);
            check[0][i] = true;
            while(!rows.isEmpty()){
                int size = rows.size();
                for (int j = 0; j < size; j++) {
                    int row = rows.poll();
                    int col = cols.poll();
                    if(row == M - 1){
                        find = true;
                        break;
                    }

                    if(col - 1 >= 0 && !check[row][col - 1] && screen[row][col - 1] == '.'){
                        rows.offer(row);
                        cols.offer(col - 1);
                        check[row][col - 1] = true;
                    }
                    if(col + 1 < N && !check[row][col + 1] && screen[row][col + 1] == '.'){
                        rows.offer(row);
                        cols.offer(col + 1);
                        check[row][col + 1] = true;
                    }
                    if(row + 1 < M && !check[row + 1][col] && screen[row + 1][col] == '.'){
                        rows.offer(row + 1);
                        cols.offer(col);
                        check[row + 1][col] = true;
                    }
                }
                if(find){
                    break;
                }
                mov++;
            }

            if(find){
                min = Math.min(mov - (M - 1), min);
            }
        }

        if(min != Integer.MAX_VALUE){
            System.out.println(min);
        }else{
            System.out.println(-1);
        }
    }
}
