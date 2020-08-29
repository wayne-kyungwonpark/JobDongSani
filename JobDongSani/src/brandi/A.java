package brandi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    private static int maxHeartRate = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] answer = new int[6];
        int N = Integer.parseInt(br.readLine());
        maxHeartRate = 220 - N;
        String str = null;
        while((str = br.readLine()) != null){
            try {
                answer[exercise(Integer.parseInt(str))]++;
            }catch(Exception e){
                break;
            }
        }
        for (int i = 0; i < 6; i++) {
            System.out.print(answer[i]);
            if(i != 5){
                System.out.print(" ");
            }
        }
    }

    private static int exercise(int heartRate){
        double percent = 100 * ((double) heartRate / (double) maxHeartRate);
        if(Double.compare(percent, 90) >= 0){
            return 0;
        }else if(Double.compare(percent, 80) >= 0){
            return 1;
        }else if(Double.compare(percent, 75) >= 0){
            return 2;
        }else if(Double.compare(percent, 68) >= 0){
            return 3;
        }else if(Double.compare(percent, 60) >= 0){
            return 4;
        }else{
            return 5;
        }
    }
}
