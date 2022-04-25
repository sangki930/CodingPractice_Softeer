package Garage_game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

class Info{
	int y,x;

	public Info(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
	
}

public class Main
{
	static int[] dx={0,1,0,-1};
	static int[] dy={-1,0,1,0};
	static int[][] arr;
	static int num,answer;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        num = Integer.parseInt(br.readLine());
        String[] input;
        arr = new int[num*3][num];
        for(int i=0;i<3*num;i++) {
        	input = br.readLine().split(" ");
        	for(int j=0;j<num;j++) {
        		arr[i][j] = Integer.parseInt(input[j]);
        	}
        }
        
        dfs(0,0);
        bw.write(answer+"");
        
        bw.close();
        br.close();   
    }
    
    static void dfs(int cnt, int sum){
        boolean[][] check = new boolean[num][num];
        int[][] dup = copyArray(arr);
        //dup에 현재 arr상태 복사
       
        for(int i=2*num;i<3*num;i++){
            for(int j=0;j<num;j++){
                int val = dup[i][j];
                if(val==0 || check[i-2*num][j]) continue;        //빈 경우, 이미 검사한 곳
                //초기화
//                memcpy(arr,dup,sizeof(arr));
                arr = copyArray(dup);
                int minX = j;
                int maxX = j;
                int minY = i;
                int maxY = i;
//                queue<info> q;
                LinkedList<Info> q = new LinkedList<>();
                int same = 1;
                q.offer(new Info(i,j));
                check[i-2*num][j]=true;
                while(!q.isEmpty()){
                	Info info = q.poll();
                    int cx = info.x;
                    int cy = info.y;
                    //빈 처리
                    arr[cy][cx]=0;
                    
                    minX = Math.min(minX,cx);
                    maxX = Math.max(maxX,cx);
                    minY = Math.min(minY,cy);
                    maxY = Math.max(maxY,cy);
                    for(int k=0;k<4;k++){
                        int nx = cx+dx[k];
                        int ny = cy+dy[k];
                        if(nx>=0 && ny>=2*num &&nx<num && ny<3*num && !check[ny-2*num][nx] && dup[ny][nx]==val){
                            check[ny-2*num][nx]=true;
                            q.offer(new Info(ny,nx));
                            same++;
                        }
                    }
                }
                if(cnt<2){   
                    //아래로 내림
                    for(int k=minX;k<=maxX;k++){
                        for(int m=maxY;m>=minY;m--){
                            if(arr[m][k]>0) continue;
                            int jump=0;
                            //jump칸씩 내림
                            for(int l=m-1;l>=0;l--){
                                if(arr[l][k]!=0){
                                    jump=m-l;
                                    break;
                                }
                            }
                            if(jump>0){
                                for(int l=m;l>=jump;l--){
                                    arr[l][k]=arr[l-jump][k];
                                    arr[l-jump][k]=0;
                                }
                            }
                        }
                    }
                    dfs(cnt+1,sum+same+(maxX-minX+1)*(maxY-minY+1));
                }
                else{
                    answer = Math.max(answer, sum+same+(maxX-minX+1)*(maxY-minY+1));
                    continue;
                }
            }
        }
    }
    
    public static int[][] copyArray(int[][] arr) {
    	if(arr.length==0 || arr==null)
    		return null;
    	int n = arr.length,m = arr[0].length;
    	int[][] ret= new int[n][];
    	for(int i=0;i<n;i++)
    		ret[i] = arr[i].clone();
    	return ret;
    }
    
}
