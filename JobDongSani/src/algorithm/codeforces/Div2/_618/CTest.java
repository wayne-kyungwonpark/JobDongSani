package algorithm.codeforces.Div2._618;

public class CTest {
    public static void main(String[] args) {
        int[] arr = {100, 57, 35, 22, 10, 2, 0};
        int value = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            value = value | arr[i + 1] - arr[i + 1];
        }
        System.out.println(value);

        int[] arr1 = {100, 35, 57, 22, 10, 2, 0};
        int value1 = arr1[0];
        for (int i = 0; i < arr1.length - 1; i++) {
            value1 = (value1 | arr1[i + 1]) - arr1[i + 1];
        }
        System.out.println(value1);

        int[] arr2 = {100, 35, 22, 57, 10, 2, 0};
        int value2 = arr2[0];
        for (int i = 0; i < arr2.length - 1; i++) {
            value2 = (value2 | arr2[i + 1]) - arr2[i + 1];
        }
        System.out.println(value2);

        int[] arr3 = {100, 35, 22, 10, 57, 2, 0};
        int value3 = arr3[0];
        for (int i = 0; i < arr3.length - 1; i++) {
            value3 = (value3 | arr3[i + 1]) - arr3[i + 1];
        }
        System.out.println(value3);

        int[] arr4 = {100, 0, 10, 57, 22, 2, 35};
        int value4 = arr4[0];
        for (int i = 0; i < arr4.length - 1; i++) {
            value4 = (value4 | arr4[i + 1]) - arr4[i + 1];
        }
        System.out.println(value4);

        int[] arr5 = {100, 2, 0, 10, 57, 22, 35};
        int value5 = arr5[0];
        for (int i = 0; i < arr5.length - 1; i++) {
            value5 = (value5 | arr5[i + 1]) - arr5[i + 1];
        }
        System.out.println(value5);
    }
}
