package test;

import java.util.StringTokenizer;

public class TokenizerTest {
    public static void main(String[] args) {
        String str = "[1,2,3,4,5]";
        StringTokenizer strtok = new StringTokenizer(str.substring(1, str.length() - 1), ",");
        while(strtok.hasMoreTokens()){
            System.out.println(strtok.nextToken());
        }
    }
}
