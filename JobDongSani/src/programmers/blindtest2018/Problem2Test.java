package programmers.blindtest2018;

public class Problem2Test {
    public static void main(String[] args) {
        Problem2 pr2 = new Problem2();
        int N = 5;
        int[] stages = {2,1,2,6,2,4,3,3};
//        int N = 4;
//        int[] stages = {4,4,4,4,4};
//        int N = 4;
//        int[] stages = {1, 1, 1, 1, 1};
        int[] ans = pr2.solution(N, stages);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

//        double[][] test = {{1.0, 0.125}, {2.0, 0.42}, {3.0, 0.5}, {4.0, 0.5}, {5.0, 0.0}};
//        double[][] tmps = new double[test.length][2];
//        pr2.merge(tmps, test, 0, test.length - 1, 1);
//        System.out.println();
    }
}
