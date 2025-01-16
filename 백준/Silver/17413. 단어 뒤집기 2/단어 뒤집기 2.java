import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		String answer = "";
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='<') {
				for(int j=i; j<str.length(); j++) {
					answer += str.charAt(j);
					if(str.charAt(j)=='>') {
						i = j;
						break;
					}
				}
			} else if(str.charAt(i)==' ') {
				answer += str.charAt(i);
			} else {
				stack.add(str.charAt(i));
				if(i+1==str.length() || str.charAt(i+1)=='<' || str.charAt(i+1)==' ') {
					int size = stack.size();
					for(int j=0; j<size; j++) {
						answer+=stack.pop();
					}
				}
			}
		}
		
		System.out.println(answer);
				
	}

}
