package brandi.secondround;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("ctest.txt")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] Nk = br.readLine().split(" ");
        int N = Integer.parseInt(Nk[0]);
        int k = Integer.parseInt(Nk[1]);
        int[] strengths = new int[N];
        Map<Integer, Integer>[] freqs = new HashMap[N];
        for (int i = 0; i < N; i++) {
            freqs[i] = new HashMap<>();
        }

        String[] strArr = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            strengths[i] = Integer.parseInt(strArr[i]);
            if(i != 0){
                for(int key : freqs[i - 1].keySet()){
                    freqs[i].put(key, freqs[i - 1].get(key));
                }
            }
            freqs[i].put(strengths[i], freqs[i].getOrDefault(strengths[i], 0) + 1);
        }

        for (int i = 0; i < k; i++) {
            String[] lr = br.readLine().split(" ");
            sb.append(find(Integer.parseInt(lr[0]) - 1, Integer.parseInt(lr[1]) - 1, freqs, strengths));
            if(i != k - 1){
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static long find(int l, int r, Map<Integer, Integer>[] freqs, int[] strengths) {
        long answer = 0;
        for (int i = l; i <= r; i++) {
            if(l >= 1){
                answer += ((long) strengths[i] * (freqs[i].getOrDefault(strengths[i],  0) - freqs[l - 1].getOrDefault(strengths[i], 0)));
            }else{
                answer += ((long) strengths[i] * freqs[i].get(strengths[i]));
            }
        }
        return answer;
    }
}
