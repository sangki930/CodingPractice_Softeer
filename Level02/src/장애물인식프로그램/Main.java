package 장애물인식프로그램;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Point{
	int x;int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}

public class Main {

	static int dx[]= {-1,0,1,0};
	static int dy[]= {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String map[][]=new String[n][n];
		boolean visited[][]=new boolean[n][n];
		
		for(int i=0;i<n;i++)
			map[i] = br.readLine().split("");
		
		LinkedList<Integer> result = new LinkedList<>();
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++) {
				
				if(visited[i][j] || map[i][j].equals("0"))
					continue;
				LinkedList<Point> queue=  new LinkedList<>();
				queue.offer(new Point(j,i));
				int cnt=0;
				while(!queue.isEmpty()) {
					Point p=queue.poll();
					
					if(visited[p.y][p.x])
						continue;
					visited[p.y][p.x]=true;cnt++;
					for(int k=0;k<4;k++) {
						
						int nx = p.x+dx[k];
						int ny = p.y+dy[k];
						
						if(nx>=0 && nx<n && ny>=0 && ny<n && map[ny][nx].equals("1") && !visited[ny][nx]) {
							queue.offer(new Point(nx,ny));
						}
						
					}
					
				}
				result.offer(cnt);
			}
		StringBuilder sb = new StringBuilder(result.size()+"\n");
		result.sort((a,b)->a-b);
		for(int i:result)
			sb.append(i).append("\n");
		System.out.println(sb);
		br.close();
	}

}

