package algorithm.baekjoon.stepwise.segmenttree;

import java.io.*;

public class _11659_RangeSum4 {
    private static int N, M;
    private static int[] nums;
    private static long[] segment;
    private static long[] lazy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        nums = new int[N + 1];
        segment = new long[4 * N];
        lazy = new long[4 * N];
        String[] strArr = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(strArr[i - 1]);
        }

        init(1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            strArr = br.readLine().split(" ");
            sb.append(sum(1, 1, N, Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1])));
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static long init(int node, int start, int end){
        if(start == end){
            return segment[node] = nums[start];
        }

        int mid = (start + end) / 2;
        return segment[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
    }

    private static void update(int node, int start, int end, int i, int j, int value){
        if(lazy[node] != 0){
            segment[node] += (end - start + 1) * lazy[node];
            if(start != end){
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }

        if(j < start || end < i){
            return;
        }

        if(i <= start && end <= j){
            segment[node] += (end - start + 1) * value;
            if(start != end){
                lazy[node * 2] += value;
                lazy[node * 2 + 1] += value;
            }
            return;
        }

        int mid = (start + end) / 2;
        update(node * 2, start, mid, i, j, value);
        update(node * 2 + 1, mid + 1, end, i, j, value);

        segment[node] = segment[node * 2] + segment[node * 2 + 1];
    }

    private static long sum(int node, int start, int end, int i, int j){
        if(lazy[node] != 0){
            segment[node] += (end - start + 1) * lazy[node];
            if(start != end){
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }

        if(j < start || end < i){
            return 0;
        }

        if(i <= start && end <= j){
            return segment[node];
        }

        int mid = (start + end) / 2;
        return sum(node * 2, start, mid, i, j) + sum(node * 2 + 1, mid + 1, end, i, j);
    }
}
