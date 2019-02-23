package test;

public class TestCaseMake1021 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 25; i >= 1; i--) {
            sb.append(i).append(" ").append(i + 25).append(" ");
        }
        System.out.println(sb.toString());
    }
}
