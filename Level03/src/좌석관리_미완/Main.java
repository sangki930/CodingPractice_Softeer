package 좌석관리_미완;

import java.util.*;
import java.io.*;

public class Main
{
    static int[] dx = {-1,-1,1,1}, dy = {-1,1,-1,1};
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]), q = Integer.parseInt(input[2]);
        int[][] seats = new int[n][m];
        int[] occupied = new int[10000+1]; // 0 : 점심을 먹지 않음, 1 : 이용 중, -1 : 이미 먹음
        int[][] points = new int[10000+1][2]; // 그 id의 좌표
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<q;i++){
            input = br.readLine().split(" ");
            String cmd = input[0];
            int id = Integer.parseInt(input[1]);
            String result = "";
            switch(cmd){
                case "In":
                    LinkedList<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{0,0}); // (행, 열)
                    int state = 0; // 0 : 모든 사람이 좌석에 앉아있음, 1 : , 2 : 이미 앉아있음
                    int x = -1, y = -1;
                    while(!queue.isEmpty()){
                        int[] point = queue.poll();
                        x = point[0];
                        y = point[1];
                        if(seats[x][y]>0){
                            if(seats[x][y] == id){
                                state = 2;
                                break;
                            }
                            continue;
                        }else if(seats[x][y]==0){
                            state = 1;
                            seats[x][y] = id;
                            occupied[id] = 1;
                            break;
                        }
                        for(int j=0;j<4;j++){
                            int nx = x + dx[j], ny = y + dy[j];
                            if(nx>=0 && ny>=0 && nx<n && ny<m && seats[nx][ny]==0){
                                queue.offer(new int[]{nx,ny});
                            }
                        }
                    }
                    if(state == 2)
                        result = id + " already seated.";
                    else if(state == 1){
                        result = id + " gets the seat ("+(x+1)+", "+(y+1)+").";
                    }else{
                        result = "There are no more seats.";
                    }
                    break;
                case "Out":
                    if(occupied[id]==0){
                        result = id+" didn't eat lunch.";
                    }else if(occupied[id]==-1){
                        result = id+" already left seat.";
                    }else{

                    }
                    break;
            }
            sb.append(result);
        }
        System.out.println(sb);
        br.close();
    }
}
