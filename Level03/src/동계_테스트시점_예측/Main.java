package 동계_테스트시점_예측;

import java.util.*;
import java.io.*;

public class Main
{
    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int n=Integer.parseInt(input[0]), m=Integer.parseInt(input[1]),answer=0;
        int[][] map = new int[n][m];
        for(int i=0;i<n;i++){
            input = br.readLine().split(" ");
            for(int j=0;j<m;j++)
                map[i][j]=Integer.parseInt(input[j]);
        }

        LinkedList<int[]> melted = new LinkedList<>();
        while(true){
            boolean[][] visited=new boolean[n][m];

            LinkedList<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0,0});
            while(!queue.isEmpty()){
                int[] p = queue.poll();
                int y=p[0], x=p[1];
                if(visited[y][x]) continue;
                visited[y][x]=true;
                for(int k=0;k<4;k++){
                    int nx = x+dx[k], ny = y+dy[k];
                    if(nx>=0 && ny>=0 && nx<m && ny<n && map[ny][nx]==0){
                        queue.offer(new int[]{ny,nx});
                    }
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(map[i][j]==0) continue;
                    int cnt=0;
                    for(int k=0;k<4;k++){
                        int nx = j+dx[k], ny = i+dy[k];
                        if(nx>=0 && ny>=0 && nx<m && ny<n && map[ny][nx]==0 && visited[ny][nx]){
                            cnt++;
                        }
                    }
                    if(cnt>=2) melted.offer(new int[]{i,j});
                }
            }
            if(melted.isEmpty()) break;
            while(!melted.isEmpty()){
                int[] p = melted.poll();
                map[p[0]][p[1]]=0;
            }
            answer++;
        }
        System.out.println(answer);
        br.close();
    }
}