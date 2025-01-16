import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] arr = new int[N];
		int locate = 0;
		int count = 0;
		
		while(true) {
			count++;
			if(++arr[locate]==M) {
				break;
			}
						
			if(arr[locate]%2!=0) {
				locate = locate + L;
				if(locate >= N) {
					locate = locate - N;
				}
			} else if(arr[locate]%2==0) {
				locate = locate - L;
				if(locate < 0) {
					locate = N + locate;
				}
			}
		}
		
		System.out.println(count-1);
		
	}

}
