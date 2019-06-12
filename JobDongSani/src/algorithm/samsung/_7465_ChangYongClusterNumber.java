package algorithm.samsung;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;

public class _7465_ChangYongClusterNumber {
    private static int N = 0, M = 0;
    private static short[][] connections = null;
    private static boolean[] checks = null;
    private static int clusterNum = 0;
    private static boolean[] isClusterCheked = null;

    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int testNum = Integer.parseInt(scn.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= testNum; i++) {
            N = scn.nextInt(); M = scn.nextInt(); scn.nextLine();
            connections = new short[M][2]; checks = new boolean[M];
            isClusterCheked = new boolean[N + 1];
            for (int j = 0; j < M; j++) {
                String[] strArr = scn.nextLine().split(" ");
                connections[j][0] = Short.parseShort(strArr[0]);
                if(strArr.length == 2){
                    connections[j][1] = Short.parseShort(strArr[1]);
                }
//                connections[j][0] = scn.nextShort(); connections[j][1] = scn.nextShort(); scn.nextLine();
            }

            doSomething();

            sb.append("#").append(i).append(" ").append(clusterNum);
            if(i != testNum){
                sb.append("\n");
            }

            N = 0; M = 0;
            connections = null; checks = null;
            clusterNum = 0;
            isClusterCheked = null;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        scn.close();
    }

    private static void doSomething() {
        for (int i = 0; i < M; i++) {
            if(!checks[i]){
                clusterNum++;
                checks[i] = true;
//                if(connections[i][1] != 0){
                    HashSet<Short> set = new HashSet<>();
                    set.add(connections[i][0]);
                    if(connections[i][1] != 0){
                        set.add(connections[i][1]);
                    }
                    boolean isAdded = false;
                    do{
                        isAdded = false;
                        for (int j = 0; j < M; j++) {
                            if(!checks[j]){
                                for (short elem : set) {
                                    if(elem == connections[j][0]){
                                        checks[j] = true;
                                        if(connections[j][1] != 0){
                                            set.add(connections[j][1]);
                                            isAdded = true;
                                            break;
                                        }
                                    }else if(elem == connections[j][1]){
                                        checks[j] = true;
                                        set.add(connections[j][0]);
                                        isAdded = true;
                                        break;
                                    }
                                }
                                if(isAdded){
                                    break;
                                }
                            }
                        }
                    }while(isAdded);
                    for (short elem : set) {
                        isClusterCheked[elem] = true;
                    }
//                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if(!isClusterCheked[i]){
                clusterNum++;
            }
        }
    }
}
