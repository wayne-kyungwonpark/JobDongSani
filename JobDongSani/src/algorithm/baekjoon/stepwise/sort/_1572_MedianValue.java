package algorithm.baekjoon.stepwise.sort;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class _1572_MedianValue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] strArr = br.readLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int K = Integer.parseInt(strArr[1]);
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        long answer = 0l;

        int[] kArr = new int[K];
        for (int i = 0; i < K; i++) {
            kArr[i] = nums[i];
        }
        Arrays.sort(kArr);

        int median = kArr[(kArr.length + 1) / 2 - 1];
        answer += median;
        for (int i = K; i < N; i++) {
            int prev = nums[i - K];
            int next = nums[i];
            LinkedList<Integer> tmp = new LinkedList<>();
            boolean isRemoved = false;
            for (int j = 0; j < kArr.length; j++) {
                if(!isRemoved && kArr[j] == prev){
                    isRemoved = true;
                }else{
                    tmp.add(kArr[j]);
                }
            }
            boolean isAdded = false;
            if(tmp.get(0) > next){
                tmp.addFirst(next);
                isAdded = true;
            }
            if(!isAdded){
                int index = 1;
                Iterator<Integer> iter = tmp.iterator();
                iter.next();
                while(iter.hasNext()){
                    if(iter.next() > next){
                        break;
                    }
                    index++;
                }
                tmp.add(index, next);
            }

            int index = 0;
            Iterator<Integer> iter = tmp.iterator();
            while(iter.hasNext()){
                kArr[index++] = iter.next();
            }

            answer += kArr[(kArr.length + 1) / 2 - 1];
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
