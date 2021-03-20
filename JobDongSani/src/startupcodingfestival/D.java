package startupcodingfestival;

import java.io.*;
import java.util.PriorityQueue;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Movie> queueForY = new PriorityQueue<>();
        PriorityQueue<Movie> queueForO = new PriorityQueue<>();
        float[] rates = new float[5];
        String[] strArr = br.readLine().split(" ");
        for (int i = 0; i < 5; i++) {
            rates[i] = Float.parseFloat(strArr[i]);
        }
        int N, M;
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        char[][] states = new char[N][M];
        char[][] genres = new char[N][M];
        for (int i = 0; i < N; i++) {
            states[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < N; i++) {
            genres[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(states[i][j] == 'Y'){
                    queueForY.offer(new Movie(i, j, genres[i][j], rates[genres[i][j] - 'A']));
                }else if(states[i][j] == 'O'){
                    queueForO.offer(new Movie(i, j, genres[i][j], rates[genres[i][j] - 'A']));
                }
            }
        }

        while(!queueForY.isEmpty()){
            sb.append(queueForY.poll().toString()).append("\n");
        }
        while(!queueForO.isEmpty()){
            sb.append(queueForO.poll().toString()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static class Movie implements Comparable<Movie> {
        int r, c;
        char genre;
        float rate;

        public Movie(int r, int c, char genre, float rate) {
            this.r = r;
            this.c = c;
            this.genre = genre;
            this.rate = rate;
        }


        @Override
        public int compareTo(Movie o) {
            if(this.rate < o.rate){
                return 1;
            }else if(this.rate > o.rate){
                return -1;
            }else{
                if(this.r < o.r){
                    return -1;
                }else if(this.r > o.r){
                    return 1;
                }
                if(this.c < o.c){
                    return -1;
                }else if(this.c > o.c){
                    return 1;
                }
                return 0;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            return sb.append(this.genre).append(" ").append(this.rate).append(" ").append(r).append(" ").append(c).toString();
        }
    }
}
