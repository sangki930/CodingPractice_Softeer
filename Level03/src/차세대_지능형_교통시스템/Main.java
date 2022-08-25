package 차세대_지능형_교통시스템;

import java.util.*;
import java.io.*;

class Point{
    int x,y,d;
    public Point(int x, int y, int d){
        this.x=x;
        this.y=y;
        this.d=d;
    }
}

public class Main
{

    static int[] dx={1,0,-1,0}, dy={0,-1,0,1};
    static int[][] signals = { {},
    {0,1,3},{1,0,2},{2,1,3},{3,0,2},
    {0,1},{1,2},{2,3},{3,0},
    {0,3},{1,0},{2,1},{3,2}
    	};
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[]=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]), t=Integer.parseInt(input[1]);
        int[][][] seq=new int[100][100][4];
        boolean[][][][] visited=new boolean[100][100][4][4];
        boolean[][] ans = new boolean[101][101];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                input = br.readLine().split(" ");
                for(int k=0;k<4;k++){
                    seq[i][j][k]=Integer.parseInt(input[k]);
                }
            }
        LinkedList<Point> queue = new LinkedList<>();
        queue.offer(new Point(0,0,1));
        visited[0][0][0][1]=true;
        ans[0][0]=true;
        int answer=0;
        int time=0;
        while(!queue.isEmpty()){
            int sz = queue.size();
            if(time==t) break;
            for(int i=0;i<sz;i++){
                Point point = queue.poll();
                int y=point.y, x=point.x, d=point.d;
                if(signals[seq[y][x][time%4]][0]!=d) continue;
 
                for(int k : signals[seq[y][x][time%4]]){
                    int ny = y+dy[k], nx = x+dx[k];
                    if(ny<0||nx<0||ny>=n||nx>=n||visited[ny][nx][time%4][k]) continue;
                    visited[ny][nx][time%4][k]=true;
                    queue.offer(new Point(nx,ny,k));
                    ans[ny][nx]=true;
                }
            }
            time++;
        }

        for(int i=0;i<101;i++)
            for(int j=0;j<101;j++)
                if(ans[i][j])
                    answer++;

        System.out.println(answer);

        br.close();
    }
}