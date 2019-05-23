package algorithm.baekjoon.nm;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class _15663_NM9 {

    private static int total = 0;

    private static void permutation(int N, int M, LinkedList<Integer> rCom, int[] nums, int[] check, StringBuilder sb){
        if(rCom.size() == M){
            for(int i: rCom){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            total++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if(((i == 0 || nums[i - 1] != nums[i]) && check[i] == 0)
                    || (i != 0 && nums[i - 1] == nums[i] && check[i - 1] == 1 && check[i] == 0)){
//            if(check[i] == 0){
                check[i] = 1;
                rCom.add(nums[i]);
                permutation(N, M, rCom, nums, check, sb);
                check[i] = 0;
                rCom.removeLast();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int N = 0, M = 0;
        int[] nums = null;
        while((str = br.readLine()) != null){
            String[] strArr = str.split(" ");
            if(N == 0){
                N = Integer.parseInt(strArr[0]);
                M = Integer.parseInt(strArr[1]);
                nums = new int[N];
            }else{
                for (int i = 0; i < N; i++) {
                    nums[i] = Integer.parseInt(strArr[i]);
                }
                break;
            }
        }
        Arrays.sort(nums);
        int[] check = new int[N];
        LinkedList<Integer> rCom = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        permutation(N, M, rCom, nums, check, sb);
        bw.write(String.valueOf(total));
        bw.newLine();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
