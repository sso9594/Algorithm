import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[] arr;
	static int result;
	public static void main(String[] args){
		//--------------솔루션 코드를 작성하세요.--------------------------------
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		result = Integer.MIN_VALUE;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		comb(0, 0, new int[3]);
		System.out.println(result);
	}
	
	static void comb(int index, int depth, int[] sel) {
		if(depth == 3) {
			int sum = 0;
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}
			if(sum<=M) {
				result = Math.max(result, sum);
			}
			return;
		}
		
		if(index==N) {
			return;
		}
		
		sel[depth] = arr[index];
		comb(index+1, depth+1, sel);
		comb(index+1, depth, sel);
	}

}
