import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int K = sc.nextInt();
			String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
			
			ArrayList<Double> student = new ArrayList<>();
			for(int i=0; i<N; i++) {
				double sum = 0;
				double middle = sc.nextDouble();
				double finalEx = sc.nextDouble();
				double hw = sc.nextDouble();
				sum = (middle * 35 / 100) + (finalEx * 45 / 100) + (hw * 20 / 100);
				student.add(sum);
			}
			
			double K_temp = student.get(K-1);
			int rank = 0;
			Collections.sort(student, Collections.reverseOrder());
			for(int i=0; i<student.size(); i++) {
				if(student.get(i)==K_temp) {
					rank = i;
				}
			}
			
			String result = grade[(int)Math.floor((rank/(double)N *10.0))];
			
			
			System.out.println("#" + test_case + " " + result);
			
		}
	}
}
