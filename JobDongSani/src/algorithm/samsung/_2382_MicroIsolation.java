package algorithm.samsung;

import java.io.*;
import java.util.LinkedList;

public class _2382_MicroIsolation {
    private static int N = 0, M = 0, K = 0;
    private static LinkedList<Integer> rows = null, columns = null
            , micros = null, directions = null;

    private static int numMicros(){
        int sum = 0;
        for (int i = 0; i < M; i++) {
            LinkedList<Integer> nextRows = new LinkedList<>(), nextColumns = new LinkedList<>()
                    , nextMicros = new LinkedList<>(), nextDirections = new LinkedList<>();
            int[][] maxMicros = new int[N][N];
            int[][] sumMicros = new int[N][N];
            int[][] indexInfoForSimultaneous = new int[N][N];
            for (int j = 0; j < micros.size(); j++) {
                int micro = micros.get(j);
                int direction = directions.get(j);
                int[] nRC = nextRC(rows.get(j), columns.get(j), direction);
                int nR = nRC[0];
                int nC = nRC[1];
                if(sumMicros[nR][nC] != 0){
                    int index = indexInfoForSimultaneous[nR][nC];
                    if(maxMicros[nR][nC] < micro){
                        maxMicros[nR][nC] = micro;
                        nextDirections.add(index, direction);
                        nextDirections.remove(index + 1);
                    }
                    sumMicros[nR][nC] += micro;
                }else if(nR == 0 || nR == N - 1 || nC == 0 || nC == N - 1){
                    if(micro != 1){
                        nextRows.add(nR); nextColumns.add(nC);
                        nextMicros.add(micro / 2); nextDirections.add(findOppositeDirection(direction));
                    }
                }else{
                    nextRows.add(nR); nextColumns.add(nC); nextMicros.add(micro); nextDirections.add(direction);
                    indexInfoForSimultaneous[nR][nC] = nextRows.size() - 1;
                    sumMicros[nR][nC] = micro;
                    maxMicros[nR][nC] = micro;
                }
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(sumMicros[j][k] != 0){
                        int index = indexInfoForSimultaneous[j][k];
                        nextMicros.add(index, sumMicros[j][k]);
                        nextMicros.remove(index + 1);
                    }
                }
            }
            rows = nextRows; columns = nextColumns; micros = nextMicros; directions = nextDirections;
        }
        for (int i = 0; i < micros.size(); i++) {
            sum += micros.get(i);
        }
        return sum;
    }

    private static int[] nextRC(int r, int c, int direction){
        int[] rc = {r, c};
        if(direction == 1){
            rc[0]--;
        }else if(direction == 2){
            rc[0]++;
        }else if(direction == 3){
            rc[1]--;
        }else{
            rc[1]++;
        }
        return rc;
    }

    private static int findOppositeDirection(int direction){
        if(direction == 1){
            return 2;
        }else if(direction == 2){
            return 1;
        }else if(direction == 3){
            return 4;
        }else{
            return 3;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int testNum = 0, testFreq = 0, kFreq = 0;
        while((str = br.readLine()) != null){
            if(testNum == 0){
                testNum = Integer.parseInt(str);
            }else{
                String[] strArr = str.split(" ");
                if(N == 0){
                    N = Integer.parseInt(strArr[0]);
                    M = Integer.parseInt(strArr[1]);
                    K = Integer.parseInt(strArr[2]);
                    rows = new LinkedList<>(); columns = new LinkedList<>(); micros = new LinkedList<>(); directions = new LinkedList<>();
                }else{
                    rows.add(Integer.parseInt(strArr[0]));
                    columns.add(Integer.parseInt(strArr[1]));
                    micros.add(Integer.parseInt(strArr[2]));
                    directions.add(Integer.parseInt(strArr[3]));
                    kFreq++;
                    if(K == kFreq){
                        testFreq++;

                        // 처리
                        bw.write("#" + String.valueOf(testFreq) + " " + String.valueOf(numMicros()));

                        N = 0; M = 0; K = 0; kFreq = 0;
                        rows = null; columns = null; micros = null; directions = null;

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
