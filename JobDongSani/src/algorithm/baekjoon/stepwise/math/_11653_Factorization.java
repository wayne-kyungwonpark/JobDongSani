package algorithm.baekjoon.stepwise.math;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class _11653_Factorization {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = scn.nextInt();
        int sqrtN = (int) Math.sqrt(N) + 1;
        ArrayList<Integer> primes = new ArrayList<>();
        int start = 2;
        while(start <= sqrtN){
            if(primes.isEmpty()){
                primes.add(start);
            }else{
                boolean isPrime = true;
                for (int i = 0; i < primes.size(); i++) {
                    if(start % primes.get(i) == 0){
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime){
                    primes.add(start);
                }
            }
            start++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < primes.size(); i++) {
            while(N % primes.get(i) == 0){
                sb.append(primes.get(i)).append("\n");
                N /= primes.get(i);
                if(N == 1){
                    break;
                }
            }
            if(N == 1){
                break;
            }
        }
        if(N != 1){
            sb.append(N);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        scn.close();
    }
}
