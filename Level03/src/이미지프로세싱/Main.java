package 이미지프로세싱;

import java.util.*;
import java.io.*;


public class Main
{
    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int h = Integer.parseInt(input[0]), w = Integer.parseInt(input[1]);
        int[][] img = new int[h][w];
        for(int k=0;k<h;k++){
            input = br.readLine().split(" ");
            for(int l=0;l<w;l++){
                img[k][l] = Integer.parseInt(input[l]);
            }
        }
        int t = Integer.parseInt(br.readLine());

        for(int k=0;k<t;k++){
            input = br.readLine().split(" ");
            int i = Integer.parseInt(input[0])-1, j = Integer.parseInt(input[1])-1, c= Integer.parseInt(input[2]);
            int num = img[i][j];
            if(num==c) continue;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{i,j});
            img[i][j] = c;
            while(!queue.isEmpty()){
                int[] p = queue.poll();
                
                for(int l=0;l<4;l++){
                    int[] np = {p[0]+dx[l], p[1]+dy[l]};
                    if(np[0]>=0 && np[0]<h && np[1]>=0 && np[1]<w && img[np[0]][np[1]]==num){
                        img[np[0]][np[1]] = c;
                        queue.offer(np);
                    }
                }
            }

            // System.out.println(Arrays.toString(img[0]));
        }
        StringBuilder sb = new StringBuilder();
        for(int k=0;k<h;k++){
            for(int l : img[k]){
                sb.append(l).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}