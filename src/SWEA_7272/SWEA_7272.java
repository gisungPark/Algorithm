package SWEA_7272;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_7272 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String zero = "CEFGHIJKLMNSTUVWXYZ";
		String one = "ADOPQR";
 		String two = "B";
 		int T;
 		
 		System.setIn(new FileInputStream("src/SWEA_7272/input_7272.txt"));
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			boolean isOk = false;
			int case1=0, case2=0;
            String s1 = sc.next();
			String s2 = sc.next();
			
			if(s1.length() == s2.length()) {
				for(int i=0; i<s1.length(); i++) {
					for(int j=0; j<zero.length(); j++) {
						if(s1.charAt(i) == zero.charAt(j)) case1=0;
						if(s2.charAt(i) == zero.charAt(j)) case2=0;
					}
						
					
					for(int j=0; j<one.length(); j++) { 
						if(s1.charAt(i) == one.charAt(j)) case1=1;
						if(s2.charAt(i) == one.charAt(j)) case2=1;
					}
					
					if(s1.charAt(i) == two.charAt(0)) case1=2;
					if(s2.charAt(i) == two.charAt(0)) case2=2;
					
					if(case1 != case2) {
						isOk = true;
						break;
					}
				}
			}else {
				isOk = true;
			}
			
			if(isOk)
				System.out.println("#"+(tc+1)+" DIFF");
			else
				System.out.println("#"+(tc+1)+" SAME");
		}
		sc.close();
	}
}
