package kakao.demo;

public class DuplicatedNumberCheck {

	private static boolean solution(int[] arr) {
		boolean answer = true;
		int[] check = new int[arr.length + 1];
		for(int i=0;i<arr.length;i++) {
			int tmp = arr[i];
			if(tmp > arr.length || tmp <= 0) {
				answer = false;
				break;
			}else {
				if(check[tmp] == 0) {
					check[tmp] = 1;
				}else {
					answer = false;
					break;
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[100000];
		for(int i=0;i<arr.length;i++) {
			arr[i] = i + 1;
		}
		System.out.println(solution(arr));
	}
}
