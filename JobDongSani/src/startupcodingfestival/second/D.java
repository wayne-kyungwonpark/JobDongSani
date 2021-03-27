package startupcodingfestival.second;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class D {
    private static Map<String, Integer> dp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] indexs = new String[N];
        for (int i = 0; i < N; i++) {
            indexs[i] = br.readLine();
        }
        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int num = 0;
            String search = br.readLine();
            if(dp.containsKey(search)){
                sb.append(dp.get(search)).append("\n");
                continue;
            }
            for (int j = 0; j < N; j++) {
                if(indexs[j].contains(search)){
                    num++;
                }
            }
            dp.put(search, num);
            sb.append(num).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
