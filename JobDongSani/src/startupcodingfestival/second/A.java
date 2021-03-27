package startupcodingfestival.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    private static int N = 0;
    private static int exerciseTime = 0;
    private static int[] playlist = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] given = br.readLine().split(" ");
        N = Integer.parseInt(given[0]);
        exerciseTime = timeToNum(given[1]);

        playlist = new int[N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            playlist[i] = timeToNum(str);
        }

        // sliding window
        // 연습시간을 초과할 때의 연습곡 숫자를 이전과 비교하여 연습곡 숫자가 이전보다 더 많으면 연습곡 숫자와 start 시점을 갱신
        int start = 0;
        int end = 0;
        int maxStart = 0;
        int len = 0;

        long sum = 0;
        while(end < N){
            sum += playlist[end];
            while(start <= end && sum >= exerciseTime){
                if(len < end - start + 1){
                    len = end - start + 1;
                    maxStart = start;
                }
                sum -= playlist[start++];
            }
            end++;
        }

        System.out.println(len + " " + (maxStart + 1));

    }

    private static int timeToNum(String time){
        int num = 0;
        String[] sibuncho = time.split(":");
        if(sibuncho.length == 3){
            num = Integer.parseInt(sibuncho[0]) * 3600 + Integer.parseInt(sibuncho[1]) * 60 + Integer.parseInt(sibuncho[2]);
        }else{
            num = Integer.parseInt(sibuncho[0]) * 60 + Integer.parseInt(sibuncho[1]);
        }

        return num;
    }
}
