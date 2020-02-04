package algorithm.codeforces.Div3._615;

import java.io.*;
import java.util.*;

/**
 * 소인수분해 결과를 Map에 넣음
 * "YES"인 경우
 * 1. 서로 다른 소인수가 3개 이상 (a, b, c)일 경우 -> a, b, 나머지
 * 2. 서로 다른 소인수가 1개일 경우, 해당 소인수에 대한 차수가 6 이상 -> a, a^2, a^(차수-3)
 * 3. 서로 다른 소인수가 2개일 경우,
 *    소인수의 차수가 모두 2 이상 -> a, b, 나머지
 *    하나의 소인수라도 차수가 3 이상 -> a, b, b^(차수-1)
 */
public class C {
    private static int n = 0;
    private static Map<Integer, Integer> factorAndOrder = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            factorAndOrder = new HashMap<>();
            doFactorization();
            Iterator<Integer> factors = factorAndOrder.keySet().iterator();
            if(factorAndOrder.keySet().size() >= 3){
                sb.append("YES").append("\n");
                int a = factors.next();
                int b = factors.next();
                sb.append(a).append(" ").append(b).append(" ").append(n / a / b).append("\n");
            }else if(factorAndOrder.keySet().size() == 1){
                int a = factors.next();
                if(factorAndOrder.get(a) >= 6){
                    sb.append("YES").append("\n");
                    sb.append(a).append(" ").append(a * a).append(" ").append(n / a / a / a).append("\n");
                }else{
                    sb.append("NO").append("\n");
                }
            }else{
                int a = factors.next();
                int b = factors.next();
                int orderA = factorAndOrder.get(a);
                int orderB = factorAndOrder.get(b);
                if(orderA >= 2 && orderB >= 2){
                    sb.append("YES").append("\n");
                    sb.append(a).append(" ").append(b).append(" ").append(n / a / b).append("\n");
                }else if(orderA >= 3 && orderB == 1){
                    sb.append("YES").append("\n");
                    sb.append(a).append(" ").append(a * a).append(" ").append(n / a / a / a).append("\n");
                }else if(orderB >= 3 && orderA == 1){
                    sb.append("YES").append("\n");
                    sb.append(b).append(" ").append(b * b).append(" ").append(n / b / b / b).append("\n");
                }else{
                    sb.append("NO").append("\n");
                }
            }
            n = 0;
            factorAndOrder = null;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void doFactorization() {
        int rootN = (int) Math.sqrt(n);
        int tmp = n;
        while(tmp % 2 == 0){
            if(!factorAndOrder.containsKey(2)){
                factorAndOrder.put(2, 1);
            }else{
                factorAndOrder.put(2, factorAndOrder.get(2) + 1);
            }
            tmp /= 2;
        }
        for (int i = 3; i <= rootN; i+=2) {
            while(tmp % i == 0){
                if(!factorAndOrder.containsKey(i)){
                    factorAndOrder.put(i, 1);
                }else{
                    factorAndOrder.put(i, factorAndOrder.get(i) + 1);
                }
                tmp /= i;
            }
        }
        if(tmp != 1){
            factorAndOrder.put(tmp, 1);
        }
    }
}
