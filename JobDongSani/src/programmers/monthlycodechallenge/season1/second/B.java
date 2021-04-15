package programmers.monthlycodechallenge.season1.second;

public class B {
    public static void main(String[] args) {
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        int[] answer = solution(arr);
        System.out.println(answer[0] + " " + answer[1]);
    }

    public static int[] solution(int[][] arr) {
        int[] answer = new int[2];

        int length = arr.length;
        int size = 2;
        int[][] prevComp = new int[length][length];
        for (int i = 0; i < prevComp.length; i++) {
            for (int j = 0; j < prevComp.length; j++) {
                prevComp[i][j] = arr[i][j];
            }
        }
        while(size <= length){
            int[][] newComp = new int[prevComp.length / 2][prevComp.length / 2];
            int loop = length / size;
            for (int i = 0; i < loop; i++) {
                for (int j = 0; j < loop; j++) {
                    boolean prevCheck = true;
                    int[] check = new int[2];
                    for (int k = i * 2; k < (i + 1) * 2; k++) {
                        for (int l = j * 2; l < (j + 1) * 2; l++) {
                            if(prevComp[k][l] == -1){
                                prevCheck = false;
                            }else{
                                check[prevComp[k][l]]++;
                            }
                        }
                    }
                    if(!prevCheck){
                        newComp[i][j] = -1;
                        answer[0] += check[0];
                        answer[1] += check[1];
                        continue;
                    }
                    if(check[0] == 0){
                        newComp[i][j] = 1;
                    }else if(check[1] == 0){
                        newComp[i][j] = 0;
                    }else{
                        answer[0] += check[0];
                        answer[1] += check[1];
                        newComp[i][j] = -1;
                    }
                }
            }

            size *= 2;
            prevComp = newComp;
        }

        for (int i = 0; i < prevComp.length; i++) {
            for (int j = 0; j < prevComp.length; j++) {
                if(prevComp[i][j] != -1){
                    answer[prevComp[i][j]]++;
                }
            }
        }

        return answer;
    }
}
