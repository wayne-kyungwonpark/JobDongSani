package startupcodingfestival;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] route = br.readLine().toCharArray();
        long first = 0, second = 0;
        if(route[0] == '1'){
            first = 1;
        }
        if(route[1] == '1'){
            second = 1;
        }
        for (int i = 2; i < N; i++) {
            if(route[i] == '1'){
                long tmp = first;
                first = second;
                second = tmp + second;
            }else{
                first = second;
                second = 0;
            }
        }
        System.out.println(second);
    }
}
