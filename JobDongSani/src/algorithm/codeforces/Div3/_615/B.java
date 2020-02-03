package algorithm.codeforces.Div3._615;

import java.io.*;

public class B {
    private static int n = 0;
    private static int[][] packages = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            packages = new int[n][2];
            for (int j = 0; j < n; j++) {
                String[] strArr = br.readLine().split(" ");
                packages[j][0] = Integer.parseInt(strArr[0]);
                packages[j][1] = Integer.parseInt(strArr[1]);
            }
            merge2D();
            String[] decide = decide();
            sb.append(decide[0]).append("\n");
            if("YES".equals(decide[0])){
                sb.append(decide[1]).append("\n");
            }
            n = 0;
            packages = null;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static String[] decide() {
        String[] strArr = new String[2];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < packages[0][0]; i++) {
            sb.append("R");
        }
        for (int i = 0; i < packages[0][1]; i++) {
            sb.append("U");
        }
        int leftIndex = 0;
        for (int i = 1; i < n; i++) {
            if(packages[leftIndex][0] != packages[i][0]){
                if(packages[leftIndex][1] > packages[i][1]) {
                    strArr[0] = "NO";
                    break;
                }
                for (int j = 0; j < packages[i][0] - packages[i - 1][0]; j++) {
                    sb.append("R");
                }
                for (int j = 0; j < packages[i][1] - packages[i - 1][1]; j++) {
                    sb.append("U");
                }
                leftIndex = i;
            }else{
                for (int j = 0; j < packages[i][1] - packages[i - 1][1]; j++) {
                    sb.append("U");
                }
            }
        }
        if(!"NO".equals(strArr[0])) {
            strArr[0] = "YES";
            strArr[1] = sb.toString();
        }
        return strArr;
    }

    private static void merge2D() {
        int[][] tmp = new int[n][2];
        merge1D(packages, tmp, 0, n - 1, 0);
        int leftIndex = 0;
        for (int i = 1; i < n; i++) {
            if(packages[leftIndex][0] != packages[i][0]){
                merge1D(packages, tmp, leftIndex, i - 1, 1);
                leftIndex = i;
            }
        }
    }

    private static void merge1D(int[][] original, int[][] tmp, int start, int end, int orderIndex) {
        if(start >= end){
            return;
        }
        if(start == end - 1){
            if(original[start][orderIndex] > original[end][orderIndex]){
                int tmp1 = original[start][orderIndex];
                int tmp2 = original[start][1 - orderIndex];
                original[start][orderIndex] = original[end][orderIndex];
                original[start][1 - orderIndex] = original[end][1 - orderIndex];
                original[end][orderIndex] = tmp1;
                original[end][1 - orderIndex] = tmp2;
            }
            return;
        }
        int mid = (start + end) / 2;
        merge1D(original, tmp, start, mid, orderIndex);
        merge1D(original, tmp, mid + 1, end, orderIndex);
        int left = start;
        int right = mid + 1;
        int index = start;
        while(left <= mid && right <= end){
            if(original[left][orderIndex] <= original[right][orderIndex]){
                tmp[index][orderIndex] = original[left][orderIndex];
                tmp[index][1 - orderIndex] = original[left][1 - orderIndex];
                left++;
            }else{
                tmp[index][orderIndex] = original[right][orderIndex];
                tmp[index][1 - orderIndex] = original[right][1 - orderIndex];
                right++;
            }
            index++;
        }
        if(left <= mid){
            while(index <= end){
                tmp[index][orderIndex] = original[left][orderIndex];
                tmp[index][1 - orderIndex] = original[left][1 - orderIndex];
                index++;
                left++;
            }
        }else{
            while(index <= end){
                tmp[index][orderIndex] = original[right][orderIndex];
                tmp[index][1 - orderIndex] = original[right][1 - orderIndex];
                index++;
                right++;
            }
        }
        for (int i = start; i <= end; i++) {
            original[i][orderIndex] = tmp[i][orderIndex];
            original[i][1 - orderIndex] = tmp[i][1 - orderIndex];
        }
    }
}
