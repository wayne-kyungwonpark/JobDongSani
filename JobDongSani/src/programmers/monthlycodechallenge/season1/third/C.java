package programmers.monthlycodechallenge.season1.third;

import java.util.Arrays;

public class C {

    public static void main(String[] args) {
//        int[] a = {0};
//        int[] a = {5,2,3,3,5,3};
        int[] a = {0,3,3,0,7,2,0,2,2,0};
        System.out.println(solution(a));
//        System.out.println(solution(a));
    }
    private static int[] freqs = null;

    public static int solution(int[] a) {
        if(a.length < 2){
            return 0;
        }
        int answer = -1;
        freqs = new int[a.length];
        int prev = -1;
        for (int i = 0; i < a.length; i++) {
            if(prev == a[i]){
//                if(i != a.length - 1 && a[i + 1] != a[i]){
//                    freqs[a[i]]++;
//                }
            }else{
                prev = a[i];
                freqs[a[i]]++;
            }
        }

        Arrays.sort(freqs);
        int index = freqs.length - 1;
        while(a.length / 2 < freqs[index]){
            index--;
        }

        return freqs[index] * 2;
    }
}
