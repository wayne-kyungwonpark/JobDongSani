package algorithm.baekjoon.stepwise.segmenttree;

import java.io.*;

public class _2042_RangeSum {
    private static int N, M, K;
    private static long[] nums, segments, lazy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NMK = br.readLine().split(" ");
        N = Integer.parseInt(NMK[0]);
        M = Integer.parseInt(NMK[1]);
        K = Integer.parseInt(NMK[2]);
        nums = new long[N + 1];
        segments = new long[4 * N];
        lazy = new long[4 * N];
        for (int i = 1; i <= N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }

        init(1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            String[] strArr = br.readLine().split(" ");
            int a = Integer.parseInt(strArr[0]);
            int b = Integer.parseInt(strArr[1]);
            long c = Long.parseLong(strArr[2]);
            if(a == 1){
                update(1, 1, N, b, b, c - nums[b]);
                nums[b] = c;
            }else{
                sb.append(sum(1, 1, N, b, (int) c)).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static long init(int node, int start, int end){
        if(start == end){
            return segments[node] = nums[start];
        }

        int mid = (start + end) / 2;
        return segments[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
    }

    private static void update(int node, int start, int end, int i, int j, long value){
        if(lazy[node] != 0){
            segments[node] += (end - start + 1) * lazy[node];
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
            segments[node] += (end - start + 1) * value;
            if(start != end){
                lazy[node * 2] += value;
                lazy[node * 2 + 1] += value;
            }
            return;
        }

        int mid = (start + end) / 2;
        update(node * 2, start, mid, i, j, value);
        update(node * 2 + 1, mid + 1, end, i, j, value);
        segments[node] = segments[node * 2] + segments[node * 2 + 1];
    }

    private static long sum(int node, int start, int end, int i, int j){
        if(lazy[node] != 0){
            segments[node] += (end - start + 1) * lazy[node];
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
            return segments[node];
        }

        int mid = (start + end) / 2;
        return sum(node * 2, start, mid, i, j) + sum(node * 2 + 1, mid + 1, end, i, j);
    }
}
