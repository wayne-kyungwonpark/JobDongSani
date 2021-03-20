package startupcodingfestival;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String start = null, end = null;

        for (int i = 0; i < N; i++) {
            String[] timeInterval = br.readLine().split(" ~ ");
            if(i == 0){
                start = timeInterval[0];
                end = timeInterval[1];
            }else{
                if(start.compareTo(timeInterval[0]) < 0){
                    start = timeInterval[0];
                }
                if(end.compareTo(timeInterval[1]) > 0){
                    end = timeInterval[1];
                }
            }
        }

        if(start.compareTo(end) < 0){
            System.out.println(start + " ~ " + end);
        }else{
            System.out.println(-1);
        }
    }
}
