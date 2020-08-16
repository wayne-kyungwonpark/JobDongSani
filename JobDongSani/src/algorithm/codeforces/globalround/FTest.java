package algorithm.codeforces.globalround;

import java.io.FileWriter;
import java.io.IOException;

public class FTest {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("ftest.txt");
        StringBuilder sb = new StringBuilder();
        int n = 1000000;
        sb.append(n).append("\n");
        long num = 1;
        while(n > 0){
            sb.append(num).append(" ");
            n--;
            num += (n - 1);
        }
        fw.write(sb.toString());
        fw.flush();
        fw.close();
    }
}
