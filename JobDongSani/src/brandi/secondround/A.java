package brandi.secondround;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    private static char[][] cases = {{'R', 'G', 'B'}, {'R', 'B', 'G'}, {'G', 'R', 'B'}, {'G', 'B', 'R'}, {'B', 'G', 'R'}, {'B', 'R', 'G'}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int[] prices = new int[strArr.length]; // r, g, b prices
        for (int i = 0; i < strArr.length; i++) {
            prices[i] = Integer.parseInt(strArr[i]);
        }

        char[] flowers = br.readLine().toCharArray();
        int minFreq = flowers.length;
        int minPrice = Integer.MAX_VALUE;
        for (int j = 0; j < cases.length; j++) {
            int freq = 0;
            int price = 0;
            int[] needs = new int[3]; // r, g, b needs
            int[] rest = new int[3]; // r, g, b rest
            for (int i = 0; i < flowers.length; i++) {
                if(flowers[i] != cases[j][i % 3]){
                    if(flowers[i] == 'R'){
                        rest[0]++;
                    }else if(flowers[i] == 'G'){
                        rest[1]++;
                    }else{
                        rest[2]++;
                    }
                    if(cases[j][i % 3] == 'R'){
                        needs[0]++;
                    }else if(cases[j][i % 3] == 'G'){
                        needs[1]++;
                    }else{
                        needs[2]++;
                    }
                    freq++;
                }
            }
            for (int i = 0; i < 3; i++) {
                if(needs[i] > rest[i]){
                    price += (prices[i] * (needs[i] - rest[i]));
                }
            }
            if(minPrice > price){
                minPrice = price;
                minFreq = freq;
            }else if(minPrice == price){
                minFreq = Math.min(minFreq, freq);
            }
        }
        System.out.println(minPrice + " " + minFreq);
    }
}
