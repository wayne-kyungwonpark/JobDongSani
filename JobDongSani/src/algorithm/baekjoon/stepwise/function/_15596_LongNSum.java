package algorithm.baekjoon.stepwise.function;

public class _15596_LongNSum {
    long sum(int[] a){
        long ans = 0;
        for (int i = 0; i < a.length; i++) {
            ans += (long) a[i];
        }
        return ans;
    }
}
