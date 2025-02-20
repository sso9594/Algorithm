import java.io.*;
import java.util.*;

public class Solution {
	static final String front = "([{<";
	static final String back = ")]}>";
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// int T = Integer.parseInt(br.readLine());
		int T = 10;
		
		for (int test_case = 1; test_case <= T; test_case++) {		
			int N = Integer.parseInt(br.readLine());
			Stack<Character> stack = new Stack<>();
			String token = br.readLine();
			boolean valid = true;
			for (int i = 0; i < token.length(); i++) {
				char current = token.charAt(i);
				if(front.contains(current+"")){
					stack.push(current);
				} else {
					char opposite = stack.pop();
					switch (opposite) {
						case '(':
							if(current!=')'){
								valid = false;
							}
							break;
						case '<':
							if(current!='>'){
								valid = false;
							}
							break;
						case '{':
							if(current!='}'){
								valid = false;
							}
							break;
						case '[':
							if(current!=']'){
								valid = false;
							}
							break;
						default:
							break;
					}
					if(!valid){
						break;
					}
				}
			}
			System.out.println("#" + test_case + " " + (valid ? 1 : 0));
		}
		
	}		

}
