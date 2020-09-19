package programmers.blindtest2020_mock;

public class LockAndKey {
    public static void main(String[] args) {
        int[][] key = {{0,0,0},{1,0,0},{0,1,1}};
        int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};
        System.out.println(solution(key, lock));
    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        // 0, 90, 180, 270
        for (int i = 0; i < 4; i++) {
            int[][] newKey = ninetyDegree(key);
            if(isPossible(newKey, lock)){
                answer = true;
                break;
            }
            key = newKey;
        }

        return answer;
    }

    private static boolean isPossible(int[][] key, int[][] lock){
        boolean answer = true;
        int M = key.length;
        int N = lock.length;
//        for (int i = 0; i < ; i++) {
//
//        }
        return answer;
    }

    private static int[][] ninetyDegree(int[][] key){
        int[][] newKey = new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                newKey[i][j] = key[key.length - 1 - j][i];
            }
        }
        return newKey;
    }
}
