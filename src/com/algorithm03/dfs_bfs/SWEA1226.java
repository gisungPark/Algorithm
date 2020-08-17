package com.algorithm03.dfs_bfs;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA1226 {

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] map;
    static boolean[][] isVisited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        for(int tc=0; tc<10; tc++) {
            int n = sc.nextInt();
            sc.nextLine();
             
            map = new int[16][16];
            isVisited = new boolean[16][16];
            for(int i=0; i<16; i++) {
                String str = sc.nextLine();
                for(int j=0; j< str.length(); j++) {
                    map[i][j] = str.charAt(j) -'0';
                }
            }
             
            Queue<int[] > q = new LinkedList<int[]>();
            boolean isOk = false;
            q.add(new int[]{1,1});
            isVisited[1][1] = true;
             
            while(!q.isEmpty()) {
                int[] tmp = q.poll();
                int x = tmp[0];
                int y = tmp[1];
                for(int i=0; i<4; i++) {
                    int xx = x+dx[i];
                    int yy = y+dy[i];
                    if(xx == 13 && yy == 13) {
                        isOk = true;
                        break;
                    }
                    if(xx<0 || xx>=16 || yy<0 || yy>=16) continue;
                    if(map[xx][yy] == 0 && isVisited[xx][yy] == false) {
                        isVisited[xx][yy] = true;
                        q.add(new int[] {xx,yy});
                    }
                }
                if(isOk) break;
            }
             
            if(isOk) System.out.println("#"+(tc+1)+" 1");
            else System.out.println("#"+(tc+1)+" 0");
         
        }
    }
}