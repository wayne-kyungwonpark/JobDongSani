package programmers.blindtest2018;

public class Problem4Test {
    public static void main(String[] args) {
        Problem4 pr4 = new Problem4();
//        int[] food_times = {3, 1, 2};
//        long k = 5;
//        int[] food_times = {3,1,1,1,2,4,3};
//        long k = 12;
//        int[] food_times = {4,3,5,6,2};
//        long k = 7;
//        int[] food_times = {4,1,1,5};
//        long k = 7;
//        int[] food_times = {4,4,4,4,5};
//        long k = 1;
//        int[] food_times = {1,2,3,4,5};
//        long k = 14;

//        int[] food_times = new int[5];
//        for (int i = 0; i < food_times.length; i++) {
//            food_times[i] = 4;
//        }
        int[] food_times = {5, 5, 5, 5, 5, 5, 1, 1, 1, 1, 2, 3, 4, 2, 2, 1};
        long k = 47;
        Problem4Eff pr4Eff = new Problem4Eff();
//        System.out.println(pr4.solution(food_times, k));
//        long k = 1l;
//        for (int i = 1; i <= 50; i++) {
//            k++;
//            if(k == 28){
//                System.out.println("start");
//            }
//            System.out.print(pr4Eff.solution(food_times, k) + " ");
//        }
        System.out.println(pr4Eff.solution(food_times, k));
    }
}
