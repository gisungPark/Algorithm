package com.algorithm01.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
						
	// jsbs[][] 작업이 요청되는 시점, 작업의 소요시간
	public static int solution(int[][] jobs) {	
		PriorityQueue<Controll> pq = new PriorityQueue<Controll>();
		for(int i=0; i<jobs.length; i++) {
			pq.add(new Controll(jobs[i][0], jobs[i][1]));
		}
		
//		System.out.println("start\t end");
		int time = 0;
		int diff = 0;
		int curTime = 0;
		while(!pq.isEmpty()) {
//			System.out.println(ct.start+"\t" + ct.end);
			Controll next = pq.poll();
			if(next.start <= curTime) {
				//컨트롤러 동작 수행
						// (현재시간+동작시간) - 요청시간
				diff = (curTime+next.end) - next.start;	
				time += diff;
				curTime += next.end;
			}else {
				// 해당 컨트롤러가 현재시간에 동작이 불가 하다면,
				List<Controll> list = new ArrayList<>();
				
				// 현재시간에 동작가능한 컨트롤러가 존재하는지 탐색한다.
				while(!pq.isEmpty()) {
					Controll pos = pq.poll();
					// pq 컨트롤러의 시작시간이 비교 컨트롤러의 종료시간보다 늦다면 break
					if(pos.start>=next.end) break;
					else {
						list.add(pos);
					}
				}
				// 앞서 꺼낸 컨트롤러를 다시 삽입한다.
				pq.add(next);
				
				if(list.size() != 0) {
					int rmidx = -1;
					// 리스트에 담긴 컨트롤러를 비교하며, 현재시간에 동작가능한지 확인한다.
					for(int i=0; i<list.size(); i++) {
						if(list.get(i).start <= curTime) {
							next = list.get(i);
							rmidx = i;
							break;
						}
					}
					for(int i=0; i<list.size(); i++) {
						if(i == rmidx) continue;
						pq.add(list.get(i));
					}
					
					// 현재 시간에 동작가능한 컨트롤러가 있다면, 시간처리
					if(rmidx != -1) {
						diff = (curTime+next.end) - next.start;	
						time += diff;
						curTime += next.end;
					}else {
						curTime++;
					}
				}else {
					//현재 시간에 동작가능한 컨트롤러가 없다면 시간 증가 
					curTime++;
				}
			}
		}
		
		return time/jobs.length;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0, 3}, {1, 9}, {2, 6}}));
	}
	
	public static class Controll implements Comparable<Controll>{
		int start;
		int end;
		
		public Controll(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Controll o) {
			if(this.end == o.end)
				return this.start - o.start;
			return this.end - o.end;
		}
	}
}
