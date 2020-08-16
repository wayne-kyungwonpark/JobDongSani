package algorithm.codeforces.globalround;

import java.io.*;

public class D {
    private static int n, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            char[] chArr = br.readLine().toCharArray();
            find(chArr, 0, 0);
            sb.append(max);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void find(char[] chArr, int current, int index) {
        if(index >= n){
            max = Math.max(current, max);
        }
        if(chArr[index] == 'R'){
            if(chArr[(index + 1) % n] == 'R' && chArr[(index + 2) % n] == 'R'){
                chArr[(index + 1) % n] = 'L';
                find(chArr, current + 1, index + 1);
                chArr[(index + 1) % n] = 'R';
                chArr[(index + 2) % n] = 'L';
                find(chArr, current + 1, index + 2);
                chArr[(index + 2) % n] = 'R';
            }else{
                find(chArr, current, index + 1);
            }
        }else{
            if(chArr[(index + 1) % n] == 'L' && chArr[(index + 2) % n] == 'L'){
                chArr[(index + 1) % n] = 'L';
                find(chArr, current + 1, index + 1);
                chArr[(index + 1) % n] = 'R';
                chArr[(index + 2) % n] = 'L';
                find(chArr, current + 1, index + 2);
                chArr[(index + 2) % n] = 'R';
            }
        }
    }
}
