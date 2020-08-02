package SWEA_1289;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_1289 {
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/SWEA_1289/input_1289.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int tc=0; tc<T; tc++) {
			String N = sc.nextLine();
			char[] charN = N.toCharArray();
			char[] compare = new char[charN.length];
			int cnt = 0;
			//초기화
			for(int i=0; i<charN.length; i++) {
				compare[i] = '0';
			}
			
			
			for(int i=0; i<charN.length; i++) {
				boolean isOk = false;
				char bit = charN[i];
				for(int j=i; j<charN.length; j++) {
					compare[j] = bit;
				}
				cnt++;
				for(int j=0; j<charN.length; j++) {
					if(charN[i] == compare[i]) isOk = true;
				}
				
				if(!isOk) {
					print(compare);
					break;
				}
			}
			System.out.println("#"+(tc+1) +" " + cnt);
			
		}
	}

	private static void print(char[] arr) {
		// TODO Auto-generated method stub
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]);
		System.out.println();
	}
	
}
