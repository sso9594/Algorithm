import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		int left = 0;
		
		for(int right=0; right<N; right++) {
			map.put(arr[right], map.getOrDefault(arr[right], 0)+1);
			while(map.size()>2) {
				map.put(arr[left], map.get(arr[left]) -1);
				if(map.get(arr[left])==0) {
					map.remove(arr[left]);
				}
				left++;
			}
			
			max = Math.max(max, right-left+1);
		}
		
		System.out.println(max);
	}
	
}
