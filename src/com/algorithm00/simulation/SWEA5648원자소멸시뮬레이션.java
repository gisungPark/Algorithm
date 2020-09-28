package com.algorithm00.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA5648원자소멸시뮬레이션 {

	public static class atom {
		boolean life;
		int x, y;
		int dir, energy;
		
		public atom(int x, int y, int dir, int energy) {
			this.life = true;
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.energy = energy;
		}
		
		public void go() {
			if(dir == 0) y++;
			else if(dir==1) y--;
			else if(dir==2) x--;
			else if(dir==3) x++;
 		}
	}

	static int T, N, ANS;
	static ArrayList<atom> list;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc =0; tc<T; tc++) {
			N = sc.nextInt();
			list = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int dir = sc.nextInt();
				int energy = sc.nextInt();
				
				list.add(new atom(x*2, y*2, dir, energy));
			}
			
			ANS = 0;
			for(int time=0; time<=4000; time++) {
				for(int i=0; i<list.size(); i++) {
					atom cur = list.get(i);
					cur.go();
					if(cur.x >2000 || cur.y >2000
							|| cur.x < -2000 || cur.y<-2000) {
						list.remove(i);
					}
				}
				
				boolean check = false;
				for(int i=0; i<list.size()-1; i++) {
					atom cur = list.get(i);
					if(!cur.life) continue;
					boolean isOk = false;
					
					for(int j=i+1; j<list.size(); j++) {
						atom next = list.get(j);
						if(!next.life) continue;
						
						if(cur.x == next.x && cur.y == next.y) {
							next.life = false;
							isOk = true;
						}
						/*********** 가지치기   *********/
						else {
							if(!check) {
									
								
								
							}
							
							
							
						}
					}
					if(isOk) {
						cur.life = false;
					}
				}
				
				for(int i=list.size()-1; i>=0; i--) {
					if(!list.get(i).life) {
						ANS += list.get(i).energy;
						list.remove(i);
					}
				}
				if(list.size()<2) break;
			}
			System.out.println("#"+(tc+1) + " " + ANS);
		}
		
	}

}
