package brandi.secondexercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GeunMukJaHeuk {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        String[] strArr = br.readLine().split(" ");
        int[] nums = new int[N];
        int min = N;
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(strArr[i]);
            min = Math.min(min, nums[i]);
        }
        int left = 0;
        int right = 0;
        boolean find = false;
        for (int i = 0; i < N; i++) {
            if(!find){
                if(nums[i] == min){
                    find = true;
                }else{
                    left++;
                }
            }else{
                right++;
            }
        }
        int minFreq = Integer.MAX_VALUE;
        for (int i = 0; i < K - 1; i++) {
            if(i == 0){
                int leftFreq = left / (K - 1);
                if(left != 0 && left % (K - 1) != 0){
                    leftFreq++;
                }
                int rightFreq = right / (K - 1);
                if(right != 0 && right % (K - 1) != 0){
                    rightFreq++;
                }
                minFreq = Math.min(minFreq, leftFreq + rightFreq);
            }else{
                int tmpLeft = left - i;
                int tmpRight = right - (K - 1 - i);
                int tmpLeftFreq = tmpLeft / (K - 1);
                if(tmpLeft != 0 && tmpLeft % (K - 1) != 0){
                    tmpLeftFreq++;
                }
                int tmpRightFreq = tmpRight / (K - 1);
                if(tmpRight != 0 && tmpRight % (K - 1) != 0){
                    tmpRightFreq++;
                }
                minFreq = Math.min(minFreq, 1 + tmpLeftFreq + tmpRightFreq);
            }
        }
        System.out.println(minFreq);
    }
}
