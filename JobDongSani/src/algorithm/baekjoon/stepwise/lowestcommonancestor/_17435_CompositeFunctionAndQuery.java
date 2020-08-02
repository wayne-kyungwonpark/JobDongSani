package algorithm.baekjoon.stepwise.lowestcommonancestor;

import java.io.*;
import java.util.ArrayList;

public class _17435_CompositeFunctionAndQuery {
    private static int m, Q;
    private static int[] f, groupNumbers, orderInGroup;
    private static ArrayList<ArrayList<Integer>> group;
    private static int groupNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        m = Integer.parseInt(br.readLine());
        f = new int[m + 1];
        String[] strArr = br.readLine().split(" ");
        for (int i = 1; i <= m; i++) {
            f[i] = Integer.parseInt(strArr[i - 1]);
        }

        groupNumbers = new int[m + 1];
        orderInGroup = new int[m + 1];
        group = new ArrayList<>();
        group.add(new ArrayList<>()); // 0 번 그룹을 피하기 위함
        groupNumber = 1;
        makeGroup();
        Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            strArr = br.readLine().split(" ");
            int n = Integer.parseInt(strArr[0]);
            int x = Integer.parseInt(strArr[1]);
            sb.append(group.get(groupNumbers[x]).get((n + orderInGroup[x]) % group.get(groupNumbers[x]).size())).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void makeGroup(){
        for (int i = 1; i <= m; i++) {
            if(groupNumbers[i] == 0){
                group.add(new ArrayList<>());
                int next = i;
                int order = 0;
                while(groupNumbers[next] == 0){
                    group.get(groupNumber).add(next);
                    groupNumbers[next] = groupNumber;
                    orderInGroup[next] = order++;
                    next = f[next];
                }
                groupNumber++;
            }
        }
    }
}
