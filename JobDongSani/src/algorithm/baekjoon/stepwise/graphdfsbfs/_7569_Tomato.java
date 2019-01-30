package algorithm.baekjoon.stepwise.graphdfsbfs;

import java.io.*;

public class _7569_Tomato {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int a = 0, b = 0 , c = 0;
        int[][][] tomato = null;
        int bCheck = 0, cCheck = 0;
        while((str = br.readLine()) != null){
            if(a == 0){
                String[] strArr = str.split(" ");
                a = Integer.parseInt(strArr[0]);
                b = Integer.parseInt(strArr[1]);
                c = Integer.parseInt(strArr[2]);
                tomato = new int[c + 2][b + 2][a + 2];
                for (int i = 0; i < c + 2; i++) {
                    for (int j = 0; j < b + 2; j++) {
                        tomato[i][j][0] = -1;
                        tomato[i][j][a + 1] = -1;
                    }
                }
                for (int i = 0; i < c + 2; i++) {
                    for (int k = 0; k < a + 2; k++) {
                        tomato[i][0][k] = -1;
                        tomato[i][b + 1][k] = -1;
                    }
                }
                for (int j = 0; j < b + 2; j++) {
                    for (int k = 0; k < a + 2; k++) {
                        tomato[0][j][k] = -1;
                        tomato[c + 1][j][k] = -1;
                    }
                }
            }else{
                String[] strArr = str.split(" ");
                for (int i = 1; i <= a; i++) {
                    tomato[cCheck + 1][bCheck + 1][i] = Integer.parseInt(strArr[i - 1]);
                }
                bCheck++;
                if(bCheck == b){
                    cCheck++;
                    if(cCheck == c){
                        break;
                    }
                    bCheck = 0;
                }
            }
        }
        for (int i = 0; i < c + 2; i++) {
            for (int j = 0; j < b + 2; j++) {
                for (int k = 0; k < a + 2; k++) {
                    bw.write(String.valueOf(tomato[i][j][k]) + " ");
                }
                bw.newLine();
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
