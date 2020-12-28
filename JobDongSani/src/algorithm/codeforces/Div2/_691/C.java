package algorithm.codeforces.Div2._691;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        long[] a = new long[n];
        long[] b = new long[m];
        String[] as = br.readLine().split(" ");
        String[] bs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(as[i]);
        }
        for (int i = 0; i < m; i++) {
            b[i] = Long.parseLong(bs[i]);
        }
        Arrays.sort(a);
        Map<Long, Long> result = new HashMap<>();

        for (int i = 0; i < m; i++) {
            long answer = 0;
            if(result.containsKey(b[i])){
                sb.append(result.get(b[i]));
                sb.append(" ");
                continue;
            }
            long first = a[0] + b[i];
            for (int j = 1; j < n; j++) {
                long compare = a[j] + b[i];
                long gcd = calcGCD(first, compare);
                if(gcd == 1){
                    first = 1;
                    break;
                }
                first = gcd;
            }
            result.put(b[i], first);
            sb.append(first);
            sb.append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static long calcGCD(long n1, long n2){
        long max = n1;
        long min = n2;
        if(min > max){
            max = n2;
            min = n1;
        }

        if(max % min == 0){
            return min;
        } else {
            return calcGCD(min, max % min);
        }
    }
}
