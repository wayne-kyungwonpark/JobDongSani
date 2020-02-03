package algorithm.codeforces;

import java.io.InputStreamReader;
import java.util.Scanner;

public class _977_A {
    public static void main(String[] args) {
        Scanner scn = new Scanner(new InputStreamReader(System.in));
        int n = scn.nextInt();
        int k = scn.nextInt();

        for (int i = 0; i < k; i++) {
            if(n % 10 != 0){
                n--;
            }else{
                n /= 10;
            }
        }
        System.out.println(n);
    }
}
