import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			Queue<Integer> queue = new LinkedList<>();
			
			for(int i=0; i<8; i++) {
				queue.add(sc.nextInt());
			}
			int head = queue.peek();
			int count = 1;
			while(head>0) {
				head = queue.poll();
				head -= count;
				if(head>=0) {
					queue.add(head);
				} else {
					queue.add(0);
				}
				count = count++ % 5 + 1;
			}
			
			System.out.print("#" + test_case + " ");
			int size = queue.size();
			for(int i=0; i<size; i++) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println("");
		}
	}

}
