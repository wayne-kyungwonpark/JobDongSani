package algorithm.codeforces.Div2._623;

import java.io.*;
import java.util.ArrayList;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] strArr = br.readLine().split(" ");
            int a = Integer.parseInt(strArr[0]);
            int b = Integer.parseInt(strArr[1]);
            int p = Integer.parseInt(strArr[2]);
            char[] stations = br.readLine().toCharArray();
            int index = findMinIndex(a, b, p, stations);
            sb.append(index).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int findMinIndex(int a, int b, int p, char[] stations) {
        int index = 0;
        char start = stations[index];
        ArrayList<Integer> startIndexList = new ArrayList<>();
        ArrayList<Integer> expenseList = new ArrayList<>();
        while(index < stations.length - 1){
            startIndexList.add(index);
            start = stations[index];
            expenseList.add(expense(start, a, b));
            while(stations[index] == start){
                index++;
                if(index > stations.length - 1){
                    break;
                }
            }
        }
        int i;
        for (i = startIndexList.size() - 1; i >= 0; i--) {
            if(p >= expenseList.get(i)){
                p -= expenseList.get(i);
            }else{
                break;
            }
        }

        if(i == startIndexList.size() - 1){
            return stations.length;
        }else{
            return startIndexList.get(i + 1) + 1;
        }
    }

    private static int expense(char station, int a, int b) {
        return (station == 'A')? a : b;
    }
}
