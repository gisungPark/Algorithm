package SWEA_1234;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_1234 {
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/SWEA_1234/input_1234.txt"));
		Scanner sc = new Scanner(System.in);

		for(int tc=0; tc<10; tc++) {
			int N = sc.nextInt();
			String str = sc.nextLine();
			for(int i=0; i<str.length()-1; i++) {
				if(str.charAt(i) == str.charAt(i+1)) {
					if(i==0) str = str.substring(i+2)+"";
					else str = str.substring(0, i)+""+str.substring(i+2);
					i-=2;
				}
				
			}
			System.out.println("#"+(tc+1)+" "+str);
		}
	}
}
