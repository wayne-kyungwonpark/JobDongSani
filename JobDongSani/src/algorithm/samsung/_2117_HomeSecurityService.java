package algorithm.samsung;

import java.io.*;

public class _2117_HomeSecurityService {
    private static int N = 0, M = 0, totalNumHouse = 0;
    private static int[][] city = null;

    private static int findMaxHouse(){
        int maxHouse = 0;
        int maxK = limitK();
        for (int k = 1; k <= maxK; k++) {
            int maxHouseForK = 0;
            int start = (k - 1) / 2;
            int end = Math.max((N - 1) - start, start);
            int expenseK = (int)Math.pow(k, 2) + (int)Math.pow(k - 1, 2);
            for (int i = start; i <= end; i++) {
                for (int j = start; j <= end; j++) {
                    int numHouse = checkNumHouseInCoverage(i, j, k);
                    if(expenseK <= numHouse * M && maxHouseForK < numHouse){
                        maxHouseForK = numHouse;
                        if(maxHouseForK == totalNumHouse){
                            break;
                        }
                    }
                }
            }
            if(maxHouseForK > maxHouse){
                maxHouse = maxHouseForK;
                if(maxHouse == totalNumHouse){
                    break;
                }
            }
        }
        return maxHouse;
    }

    private static int checkNumHouseInCoverage(int centerR, int centerC, int k){
        int numHouse = 0;
        for (int i = 0; i <= k - 1; i++) {
            for (int j = 0; j <= (k - 1) - i; j++) {
                if(i == 0 && j == 0){
                    if(city[centerR][centerC] == 1){
                        numHouse++;
                    }
                }else if(i == 0 && j != 0){
                    if(centerC + j <= N - 1 && city[centerR][centerC + j] == 1){
                        numHouse++;
                    }
                    if(centerC - j >= 0 && city[centerR][centerC - j] == 1){
                        numHouse++;
                    }
                }else if(i != 0 && j == 0){
                    if(centerR + i <= N - 1 && city[centerR + i][centerC] == 1){
                        numHouse++;
                    }
                    if(centerR - i >= 0 && city[centerR - i][centerC] == 1){
                        numHouse++;
                    }
                }else{
                    if(centerR + i <= N - 1 && centerC + j <= N - 1 && city[centerR + i][centerC + j] == 1){
                        numHouse++;
                    }
                    if(centerR + i <= N - 1 && centerC - j >= 0 && city[centerR + i][centerC - j] == 1){
                        numHouse++;
                    }
                    if(centerR - i >= 0 && centerC + j <= N - 1 && city[centerR - i][centerC + j] == 1){
                        numHouse++;
                    }
                    if(centerR - i >= 0 && centerC - j >= 0 && city[centerR - i][centerC - j] == 1){
                        numHouse++;
                    }
                }
            }
        }
        return numHouse;
    }

    private static int limitK(){
        int maxK = 0;
        int maxIncome = M * totalNumHouse;
        if(totalNumHouse != 0){
            maxK = 1;
            int expense = 1;
            while(expense <= maxIncome){
                maxK++;
                expense = (int)Math.pow(maxK, 2) + (int)Math.pow(maxK - 1, 2);
            }
            maxK--;
        }
        return maxK;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int testNum = 0, testFreq = 0, nFreq = 0;
        while((str = br.readLine()) != null){
            if(testNum == 0){
                testNum = Integer.parseInt(str);
            }else{
                String[] strArr = str.split(" ");
                if(N == 0){
                    N = Integer.parseInt(strArr[0]);
                    M = Integer.parseInt(strArr[1]);
                    city = new int[N][N];
                }else{
                    for (int i = 0; i < N; i++) {
                        int house = Integer.parseInt(strArr[i]);
                        if(house != 0){
                            city[nFreq][i] = Integer.parseInt(strArr[i]);
                            totalNumHouse++;
                        }
                    }
                    nFreq++;
                    if(N == nFreq){
                        testFreq++;

                        int maxHouse = findMaxHouse();

                        bw.write("#" + String.valueOf(testFreq) + " " + String.valueOf(maxHouse));

                        N = 0; M = 0; nFreq = 0; totalNumHouse = 0;
                        city = null;

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
