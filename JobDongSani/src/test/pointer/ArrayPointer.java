package test.pointer;

public class ArrayPointer {

	private static void change(int[] arr) {
		int ret = arr[2];
		ret = 2;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[5];
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
		change(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
