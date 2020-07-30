package algorithm.baekjoon.stepwise.segmenttree;

import java.io.*;
import java.util.ArrayList;

public class _11505_RangeMultiplication {
    private static int N, M, K;
    private static long[] nums, segment, lazy;
    private static final int MOD = 1000000007; // 소수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NMK = br.readLine().split(" ");
        N = Integer.parseInt(NMK[0]);
        M = Integer.parseInt(NMK[1]);
        K = Integer.parseInt(NMK[2]);
        nums = new long[N + 1];
        segment = new long[4 * N];
        lazy = new long[4 * N];
        for (int i = 0; i < lazy.length; i++) {
            lazy[i] = -1;
        }

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
                long value;
                if (nums[b] == 0) {
                    nums[b] = c;
                    segment = new long[4 * N];
                    lazy = new long[4 * N];
                    for (int j = 0; j < lazy.length; j++) {
                        lazy[j] = -1;
                    }
                    init(1, 1, N);
                }else{
                    value = (c * modInverse(nums[b], MOD)) % MOD;
                    update(1, 1, N, b, b, value);
                    nums[b] = c;
                }
            }else{
                sb.append(multiplication(1, 1, N, b, (int) c)).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static long init(int node, int start, int end){
        if(start == end){
            return segment[node] = nums[start] % MOD;
        }

        int mid = (start + end) / 2;
        return segment[node] = (init(node * 2, start, mid) * init(node * 2 + 1, mid + 1, end)) % MOD;
    }
    
    private static void update(int node, int start, int end, int i, int j, long value){
        if(lazy[node] >= 0){
            segment[node] = (segment[node] * modExp(lazy[node], end - start + 1)) % MOD;
            if(start != end){
                if(lazy[node * 2] == -1){
                    lazy[node * 2] = 1;
                }
                if(lazy[node * 2 + 1] == -1){
                    lazy[node * 2 + 1] = 1;
                }
                lazy[node * 2] = (lazy[node * 2] * lazy[node]) % MOD;
                lazy[node * 2 + 1] = (lazy[node * 2 + 1] * lazy[node]) % MOD;
            }
            lazy[node] = -1;
        }

        if(j < start || end < i){
            return;
        }

        if(i <= start && end <= j){
            segment[node] = (segment[node] * modExp(value, end - start + 1)) % MOD;
            if(start != end){
                if(lazy[node * 2] == -1){
                    lazy[node * 2] = 1;
                }
                if(lazy[node * 2 + 1] == -1){
                    lazy[node * 2 + 1] = 1;
                }
                lazy[node * 2] = (lazy[node * 2] * value) % MOD;
                lazy[node * 2 + 1] = (lazy[node * 2 + 1] * value) % MOD;
            }
            return;
        }

        int mid = (start + end) / 2;
        update(node * 2, start, mid, i, j, value);
        update(node * 2 + 1, mid + 1, end, i, j, value);

        segment[node] = (segment[node * 2] * segment[node * 2 + 1]) % MOD;
    }

    private static long multiplication(int node, int start, int end, int i, int j){
        if(lazy[node] >= 0){
            segment[node] = (segment[node] * modExp(lazy[node], end - start + 1)) % MOD;
            if(start != end){
                if(lazy[node * 2] == -1){
                    lazy[node * 2] = 1;
                }
                if(lazy[node * 2 + 1] == -1){
                    lazy[node * 2 + 1] = 1;
                }
                lazy[node * 2] = (lazy[node * 2] * lazy[node]) % MOD;
                lazy[node * 2 + 1] = (lazy[node * 2 + 1] * lazy[node]) % MOD;
            }
            lazy[node] = -1;
        }

        if(j < start || end < i){
            return 1l;
        }

        if(i <= start && end <= j){
            return segment[node];
        }

        int mid = (start + end) / 2;
        return (multiplication(node * 2, start, mid, i, j) * multiplication(node * 2 + 1, mid + 1, end, i, j)) % MOD;
    }

    // a에 대한 mod 1000000007의 역원을 찾기 위한 용도 (a * s = 1 (mod 1000000007) 인 s) (확장 유클리드 호제법 사용)
    private static long modInverse(long a, long mod){
        ArrayList<Long> q = new ArrayList<>();
        ArrayList<Long> r = new ArrayList<>();
        ArrayList<Long> s = new ArrayList<>();
        ArrayList<Long> t = new ArrayList<>();
        s.add(1l); s.add(0l); t.add(0l); t.add(1l); r.add(a); r.add(mod);

        while(true){
            long r2 = r.get(r.size() - 2);
            long r1 = r.get(r.size() - 1);
            q.add(r2 / r1);
            r.add(r2 % r1);
            if(r.get(r.size() - 1) == 0){
                break;
            }
            long s2 = s.get(s.size() - 2);
            long s1 = s.get(s.size() - 1);
            long t2 = t.get(t.size() - 2);
            long t1 = t.get(t.size() - 1);
            long q1 = q.get(q.size() - 1);
            s.add(s2 - s1 * q1);
            t.add(t2 - t1 * q1);
        }

        long ans = s.get(s.size() - 1);
        while(ans < 0){
            ans += mod;
        }
        return ans;
    }

    // a ^ exp 에 대한 mod 1000000007의 값을 찾기 위한 용도 (Fast Modular Exponentiation 사용)
    private static long modExp(long a, int exp){
        if(a == 0){
            return 0;
        }
        String binExp = Integer.toBinaryString(exp);
        long[] mods = new long[binExp.length()];
        mods[0] = a % MOD;
        if(binExp.length() > 1){
            mods[1] = (a * a) % MOD;
        }
        for (int i = 2; i < mods.length; i++) {
            mods[i] = (mods[i / 2] * mods[i - (i / 2)]) & MOD;
        }

        long answer = 1;
        char[] chBinExp = binExp.toCharArray();
        for (int i = 0; i < binExp.length(); i++) {
            if(chBinExp[i] == '1'){
                answer = (answer * mods[mods.length - 1 - i]) % MOD;
            }
        }
        return answer;
    }
}
