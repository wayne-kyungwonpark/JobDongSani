package algorithm.codeforces.Div2.Educational._82;

import java.io.*;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String[] strArr = br.readLine().split(" ");
            boolean[] boxes = new boolean[32];
            int n = Integer.parseInt(strArr[0]);
            int m = Integer.parseInt(strArr[1]);
            String[] strArr2 = br.readLine().split(" ");
            for (int j = 0; j < strArr2.length; j++) {
                checkOrder(boxes, Integer.parseInt(strArr2[j]));
            }
            char[] binN = Integer.toBinaryString(n).toCharArray();
            boolean isPossible = true;
            for (int j = 0; j < binN.length; j++) {
                if(binN[j] == '1'){
                    if(!boxes[binN.length - 1 - j]){
                        isPossible = false;
                        break;
                    }
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void checkOrder(boolean[] orders, int num){
        int order = 0;
        while(num > 1){
            num = num >> 1;
            order++;
        }
        int check = order;

        while(orders[check]){
            orders[check] = false;
            check++;
        }
        orders[check] = true;
    }
}
