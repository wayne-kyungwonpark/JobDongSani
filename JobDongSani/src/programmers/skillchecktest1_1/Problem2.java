package programmers.skillchecktest1_1;

import java.util.ArrayList;

public class Problem2 {
    public int solution(int n) {
        int answer = 1;
        int sqrtN = (int) Math.sqrt(n) + 1;
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
        ArrayList<Integer> factors = new ArrayList<>();
        ArrayList<Integer> exps = new ArrayList<>();
        for (int i = 0; i < primes.size(); i++) {
            boolean isIn = false;
            int factor = primes.get(i);
            int exp = 0;
            while(n % primes.get(i) == 0){
                isIn = true;
                exp++;
                n /= primes.get(i);
                if(n == 1){
                    break;
                }
            }
            if(isIn){
                factors.add(factor);
                exps.add(exp);
            }
            if(n == 1){
                break;
            }
        }
        if(n != 1){
            factors.add(n);
            exps.add(1);
        }

        for (int i = 0; i < factors.size(); i++) {
            answer *= ((Math.pow(factors.get(i), exps.get(i) + 1) - 1) / (factors.get(i) - 1));
        }

        return answer;
    }
}
