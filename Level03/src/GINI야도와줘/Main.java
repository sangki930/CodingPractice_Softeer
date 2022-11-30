package GINI야도와줘;

import java.util.*;
import java.io.*;

class Point{
    int x,y;
    int time;
    public Point(int x, int y,int time){
        this.x=x;
        this.y=y;
        this.time=time;
    }

    @Override
    public String toString(){
        return "Point [ x : "+this.x+", y : "+this.y+", time : "+this.time+" ]";
    }
}

public class Main
{

    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int r = Integer.parseInt(input[0]), c = Integer.parseInt(input[1]);
        // H : 집, W : 세차장

        int h_x = -1, h_y = -1, w_x = -1, w_y = -1;
        char[][] map = new char[r][c];
        int[][] visited = new int[r][c];
        LinkedList<Point> queue = new LinkedList<>();
        for(int i=0;i<r;i++){
            char[] tmp = br.readLine().toCharArray();
            map[i] = tmp;
            for(int j=0;j<c;j++){
                if(map[i][j]=='H'){
                    h_x = i;h_y = j;
                }else if(map[i][j]=='W'){
                    w_x = i;w_y = j;
                }else if(map[i][j]=='*'){
                    queue.offer(new Point(i,j,0));
                    visited[i][j] = 1;
                }
            }
        }

        queue.offer(new Point(w_x,w_y,0));
        visited[w_x][w_y] = 1;
        while(!queue.isEmpty()){
            Point point = queue.poll();
            for(int i=0;i<4;i++){
                int nx = dx[i]+point.x, ny = dy[i]+point.y;
                if(0<=nx && nx<r && 0<=ny && ny<c){

                    if(map[point.x][point.y]=='*'){
                        // if(visited[nx][ny]==1) continue;
                        if(map[nx][ny]=='.'){
                            map[nx][ny]='*';
                            visited[nx][ny] = 1;
                            queue.offer(new Point(nx,ny,point.time+1));
                        }
                    }else if(map[point.x][point.y]=='W'){
                        // if(visited[nx][ny]==1) continue;
                        if(map[nx][ny]=='.'){
                            map[nx][ny]='W';
                            visited[nx][ny] = 1;
                            queue.offer(new Point(nx,ny,point.time+1));
                        }else if(map[nx][ny]=='H'){
                            System.out.println(point.time+1);
                            return;
                        }
                    }

                }
            }

        }
        System.out.println("FAIL");
        
        br.close();
    }
}