package test;

public class DiagonalAccess {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 2}, {3, 4}};
        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
        int[] answer = diagonalAccess(matrix);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    private static int[] diagonalAccess(int[][] matrix){
        int[] answer = new int[matrix.length * matrix[0].length];

        int index = 0;

        int row = 0;
        int col = 0;
        boolean down = false;
        while(index < answer.length){
            answer[index++] = matrix[row][col];
            if(down){
                if(col == 0 || row == matrix.length - 1){
                    down = false;
                    if(row == matrix.length - 1){
                        col++;
                    }else{
                        row++;
                    }
                }else{
                    row++;
                    col--;
                }
            }else{ //up
                if(row == 0 || col == matrix[0].length - 1){
                    down = true;
                    if(col == matrix[0].length - 1){
                        row++;
                    }else{
                        col++;
                    }
                }else{
                    row--;
                    col++;
                }
            }
        }

        return answer;
    }
}
