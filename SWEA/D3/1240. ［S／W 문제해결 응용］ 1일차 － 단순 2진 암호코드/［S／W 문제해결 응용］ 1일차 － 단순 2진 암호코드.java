import java.util.*;
import java.io.*;

public class Solution {
	static Map<String, Integer> map;
	static ArrayList<Integer> password;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			char[][] arr = new char[N][M];
			
			map = new HashMap<>();
			initMap();
			
			for(int i=0; i<N; i++) {
				String token = sc.next();
				for(int j=0; j<M; j++) {
					arr[i][j] = token.charAt(j);
				}
			}
			
			for(int i=0; i<N; i++) {
				boolean valid = false;
				for(int j=0; j<M-56; j++) {
					String token = "";
					for(int k=j; k<j+56; k++) {
						token += arr[i][k];
					}
					if(checkPw(token)) {
						valid = true;
						break;
					}
				}
				if(valid) {
					break;
				}
			}
			
			int sum = 0;
			for(int num : password) {
				sum += num;
			}
				
			System.out.println("#" + test_case + " " + sum);
		}
	}
	
	static boolean checkPw(String token) {
		password = new ArrayList<>();
		int odd_sum = 0;
		int even_sum = 0;
		for(int i=0; i<token.length(); i+=7) {
			String sub = token.substring(i, i+7);
			int num = map.getOrDefault(sub, -1);
			if(num == -1) return false;
			password.add(num);
		}
		for(int i=0; i<password.size(); i++) {
			if(i%2==0) {
				odd_sum += password.get(i);
			} else {
				even_sum += password.get(i);
			}
		}
		int sum = odd_sum * 3 + even_sum;
		if(sum%10==0) return true;
		else return false;
	}
	
	static void initMap() {
		map.put("0001101", 0);
		map.put("0011001", 1);
		map.put("0010011", 2);
		map.put("0111101", 3);
		map.put("0100011", 4);
		map.put("0110001", 5);
		map.put("0101111", 6);
		map.put("0111011", 7);
		map.put("0110111", 8);
		map.put("0001011", 9);
	}

}
