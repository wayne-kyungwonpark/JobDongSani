package brandi.secondround;

import java.io.*;

public class CTest {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ctest.txt")));
        int N = 300000;
        int num = 1000000;
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = num;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(N).append(" ").append(1).append("\n");
        for (int i = 0; i < N; i++) {
            sb.append(nums[i]).append(" ");
        }
        sb.append("\n");
        sb.append(1).append(" ").append(N);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
