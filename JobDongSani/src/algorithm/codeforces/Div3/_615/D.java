package algorithm.codeforces.Div3._615;

import java.io.*;

/**
 * x에 대한 modulo 결과를 x길이의 array에 넣음
 * 1. query가 들어올 때마다 해당 숫자의 x에 대한 modulo 결과에 대한 array 값을 증가시킴
 *   ex. x = 3, query = 0, 1, 2, 2, 0, 0, 10 일 경우, array 변화
 *   [1, 0, 0] -> [1, 1, 0] -> [1, 1, 1] -> [1, 1, 2] -> [2, 1, 2] -> [3, 1, 2] -> [3, 2, 2]
 * 2. array가 업데이트 될 때마다 다음을 체크한다.
 *    - 현재의 mex에 대한 index 갱신 여부
 *      - 갱신되지 않았다면 현재의 mex를 그대로 쓴다.
 *      - 갱신되었다면 다음 mex에 대한 index를 찾는다.
 */
public class D {
    private static int min = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] strArr = br.readLine().split(" ");
        int q = Integer.parseInt(strArr[0]);
        int x = Integer.parseInt(strArr[1]);
        int[] modulo = new int[x];
        int index = 0;
        int minOfOverCount = 1;
        for (int i = 0; i < q; i++) {
            int query = Integer.parseInt(br.readLine());
            int queryModX = query % x;
            modulo[queryModX]++;
            while(modulo[index] >= minOfOverCount){
                index++;
                if(index == x){
                    index = 0;
                    minOfOverCount++;
                }
            }
            sb.append(index + x * (minOfOverCount - 1)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
