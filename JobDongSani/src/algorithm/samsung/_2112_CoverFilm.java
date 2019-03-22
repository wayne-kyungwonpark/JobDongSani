package algorithm.samsung;

import java.io.*;
import java.util.Arrays;

public class _2112_CoverFilm {
    private static int D = 0, W = 0, K = 0, dFreq = 0;
    private static int[][] cells = null;

    private static int findMinDrug(){
        int min = D;
        int all = (1 << D) - 1;
        for (int drugPosition = 0; drugPosition <= all ; drugPosition++) {
            int ones = findNumOnes(drugPosition);
            if(ones == 0){
                boolean isPossible = true;
                for (int i = 0; i < W; i++) {
                    int[] target = Arrays.copyOf(cells[i], D);
                    if(!kContinuous(target)){
                        isPossible = false;
                        break;
                    }
                }
                if(isPossible){
                    min = 0;
                    break;
                }
            }else{
                if(min > ones){
                    int abMax = (1 << ones) - 1;
                    boolean oneOfABIsPossible = false;
                    for (int ab = 0; ab <= abMax; ab++) {
                        boolean isPossible = true;
                        for (int i = 0; i < W; i++) {
                            int[] target = Arrays.copyOf(cells[i], D);
                            targetAfterDrugs(target, drugPosition, ones, ab);
                            if(!kContinuous(target)){
                                isPossible = false;
                                break;
                            }
                        }
                        if(isPossible){
                            oneOfABIsPossible = true;
                            break;
                        }
                    }
                    if(oneOfABIsPossible){
                        min = ones;
                        if(min == 1){
                            break;
                        }
                    }
                }
            }
        }
        return min;
    }

    private static void targetAfterDrugs(int[] target, int drugPosition, int ones, int ab){
        int abCheck = 1; // ones : 2; ab : 2 (=10); abCheck & ab : 10 & 01(첫째자리 체크) (= 00), 10 & 10(둘째자리 체크) (= 10)
        int compare = 1 << (D - 1);
        for (int i = 0; i < D; i++) {
            if(compare == (drugPosition & compare)){
                if(abCheck == (ab & abCheck)){
                    target[i] = 1;
                }else{
                    target[i] = 0;
                }
                abCheck = (abCheck << 1);
            }
            compare = compare >> 1;
        }
    }

    private static boolean kContinuous(int[] target){
        boolean isPossible = false;
        int continuous = 0; // 몇 번 연속인지
        int contiNum = 0; // 어떤 cell이 연속인지 (0, 1)
        for (int i = 0; i < D; i++) {
            if(continuous == 0){
                continuous++;
                contiNum = target[i];
                if(continuous >= K){
                    isPossible = true;
                    break;
                }
            }else{
                if(target[i] == contiNum){
                    continuous++;
                    if(continuous >= K){
                        isPossible = true;
                        break;
                    }
                }else{
                    continuous = 1;
                    contiNum = target[i];
                }
            }
        }
        return isPossible;
    }

    private static int findNumOnes(int drugPosition){
        int ones = 0;
        int compare = 1 << (D - 1);
        for (int i = 0; i < D; i++) {
            if((drugPosition & compare) == compare){
                ones++;
            }
            compare = (compare >> 1);
        }
        return ones;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int testNum = 0, testFreq = 0;
        while((str = br.readLine()) != null){
            if(testNum == 0){
                testNum = Integer.parseInt(str);
            }else{
                String[] strArr = str.split(" ");
                if(D == 0){
                    D = Integer.parseInt(strArr[0]);
                    W = Integer.parseInt(strArr[1]);
                    K = Integer.parseInt(strArr[2]);
                    cells = new int[W][D];
                }else{
                    for (int i = 0; i < W; i++) {
                        cells[i][dFreq] = Integer.parseInt(strArr[i]);
                    }
                    dFreq++;

                    if(dFreq == D){
                        testFreq++;

                        if(K == 1){
                            bw.write("#" + String.valueOf(testFreq) + " " + String.valueOf(0));
                        }else{
                            bw.write("#" + String.valueOf(testFreq) + " " + String.valueOf(findMinDrug()));
                        }

                        D = 0; W = 0; K = 0; dFreq = 0;
                        cells = null;

                        if(testNum == testFreq){
                            break;
                        }else{
                            bw.newLine();
                        }
                    }
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
