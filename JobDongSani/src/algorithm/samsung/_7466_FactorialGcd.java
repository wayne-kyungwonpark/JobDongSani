package algorithm.samsung;

import java.io.*;

public class _7466_FactorialGcd {
    private static int N = 0, K = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int testNum = 0, testFreq = 0;
        while((str = br.readLine()) != null){
            if(testNum == 0){
                testNum = Integer.parseInt(str);
            }else{
                String[] strArr = str.split(" ");
                N = Integer.parseInt(strArr[0]); K = Integer.parseInt(strArr[1]);
                testFreq++;
                // doSomething
                StringBuilder sb = new StringBuilder();
                sb.append("#").append(testFreq).append(" ").append(doSomething());
                bw.write(sb.toString());
                // initialization
                N = 0; K = 0;
                if(testFreq == testNum){
                    break;
                }else{
                    bw.newLine();
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int doSomething(){
        IntegerList primes = factorListLessThanSqrtK();
        IntegerList factors = new IntegerList();
        IntegerList factorExps = new IntegerList();
        factorization(factors, factorExps, primes);
        int gcd = 1;
        for (int i = 0; i < factors.size; i++) {
            // 해당 소인수에 대해 몇 거듭제곱까지 gcd에 속하는지 확인
            int numExp = findNumExpsInNFactorial(factors.get(i));
            gcd *= Math.pow(factors.get(i), Math.min(numExp, factorExps.get(i)));
        }
        return gcd;
    }

    // K에 대해 소인수 분해
    private static void factorization(IntegerList factors, IntegerList factorExps, IntegerList factorCandidates){
        int tmp = K;
        for (int i = 0; i < factorCandidates.size; i++) {
            int candidate = factorCandidates.get(i);
            if(tmp % candidate == 0) {
                factors.add(candidate);
                int factorExp = 0;
                while(tmp % candidate == 0){
                    tmp /= candidate;
                    factorExp++;
                }
                factorExps.add(factorExp);
            }
            if(tmp == 1){
                break;
            }
        }
        if(tmp >= Math.sqrt(K)){
            factors.add(tmp);
            factorExps.add(1);
        }
    }
    // sqrt(K) 보다 작거나 같은 소수 리스트 반환
    private static IntegerList factorListLessThanSqrtK(){
        IntegerList primes = new IntegerList();
        int sqrtK = (int) Math.sqrt(K) + 1;
        for (int i = 2; i <= sqrtK; i++) {
            boolean isPrime = true;
            for (int j = 0; j < primes.size; j++) {
                if(i % primes.get(j) == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                primes.add(i);
            }
        }
        return primes;
    }

    // N!에 해당 소인수가 몇 개나 있는지 확인
    private static int findNumExpsInNFactorial(int factor){
        int num = 0;
        int factorValue = factor;
        while(N >= factorValue){
            num += (N / factorValue);
            factorValue *= factor;
        }
        return num;
    }

    private static class IntegerList {
        public int size;
        private int[] array;
        public IntegerList(){
            size = 0;
            array = new int[10];
        }
        public void add(int target){
            if(size == array.length - 1){
                int[] newArray = new int[array.length * 2];
                for (int i = 0; i < array.length; i++) {
                    newArray[i] = array[i];
                }
                array = newArray;
            }
            array[size++] = target;
        }
        public int get(int index){
            if(index > size - 1 ||  index < 0){
                throw new IndexOutOfBoundsException();
            }else{
                return array[index];
            }
        }
        public boolean isEmpty(){
            if(size == 0){
                return true;
            }
            return false;
        }
    }
}
