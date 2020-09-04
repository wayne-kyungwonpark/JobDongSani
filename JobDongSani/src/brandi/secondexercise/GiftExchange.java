package brandi.secondexercise;

import java.io.*;

public class GiftExchange {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] NM = br.readLine().split(" ");
            long N = Long.parseLong(NM[0]);
            long M = Long.parseLong(NM[1]);
            long answer = find(N, M);
            sb.append(answer);
            if(i != T - 1){
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static long find(long N, long M) {
        long season = N / 5;
        long normal = M / 7;

        if(season <= normal){
            return season;
        }

        long seasonRest = N % 5;
        long normalRest = M % 7;

        return normal + ((season - normal) * 5 + seasonRest + normalRest) / 12;
    }
}
