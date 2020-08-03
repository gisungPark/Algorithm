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

	private static BufferedReader br;
	private static BufferedWriter bw;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/BOJ17413/input17413.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> s = new Stack<Character>();

		int ch = 0;
		while((ch = br.read()) != -1) {
			if((char)ch == '<') {
				while(!s.isEmpty()) bw.write(s.pop());
				
				while(true) {
					bw.write((char)ch);
					if((char)ch == '>') break;
					else ch = br.read();
				}
			}else {
				if((char)ch == ' ') {			//공백을 만나면 스택을 비운다.
					while(!s.isEmpty()) bw.write(s.pop());
					bw.write(' ');
				}else s.push((char)ch);			//문자열을 만나면 스택에 넣는다.
			}
		}
		
		while(!s.isEmpty()) bw.write(s.pop());
		bw.flush();
	}
}
