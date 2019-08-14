package algorithm.baekjoon.stepwise.math;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class _9375_FashionKingShinHaeBin {
    private static int N = 0;
    private static HashMap<String, HashSet<String>> clothes = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int testNum = 0, testFreq = 0, nFreq = 0;
        StringBuilder sb = new StringBuilder();
        while((str = br.readLine()) != null){
            if(testNum == 0){
                testNum = Integer.parseInt(str);
            }else{
                if(N == 0){
                    N = Integer.parseInt(str);
                    clothes = new HashMap<>();
                    if(N == 0){
                        sb.append(numberOfCases());
                        sb.append("\n");
                        testFreq++;
                        if(testFreq == testNum){
                            break;
                        }
                    }
                }else{
                    String[] strArr = str.split(" ");
                    if(!clothes.containsKey(strArr[1])){
                        clothes.put(strArr[1], new HashSet<>());
                    }
                    clothes.get(strArr[1]).add(strArr[0]);
                    nFreq++;
                    if(N == nFreq){
                        sb.append(numberOfCases());
                        N = 0;
                        clothes = null;
                        testFreq++;
                        if(testFreq == testNum){
                            break;
                        }else{
                            sb.append("\n");
                            nFreq = 0;
                        }
                    }
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static long numberOfCases() {
        long nums = 1;
        for(String kindOfClothes : clothes.keySet()){
            nums *= (clothes.get(kindOfClothes).size() + 1);
        }
        return nums - 1;
    }
}
