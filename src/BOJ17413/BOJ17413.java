package BOJ17413;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17413 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Stack<Character> s = new Stack<Character>();
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '<') {
				while(true) {
					if(str.charAt(i++) == '>') {
						System.out.print(str.charAt(i));
						break;
					}else {
						System.out.println(str.charAt(i));
					}
					
				}
			}else {
				
			}
		}
		
	}

}
