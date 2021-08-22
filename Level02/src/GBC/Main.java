package GBC;

import java.util.*;
import java.io.*;

class Pair{
    int high;
    int speed;
	public Pair(int high, int speed) {
		super();
		this.high = high;
		this.speed = speed;
	}
	@Override
	public String toString() {
		return "Pair [high=" + high + ", speed=" + speed + "]";
	}
    
}

public class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input[]=br.readLine().split(" ");
        int n = Integer.parseInt(input[0]),m=Integer.parseInt(input[1]);
        int answer=0;
        LinkedList<Pair> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
        	input = br.readLine().split(" ");
        	int high = Integer.parseInt(input[0]);
        	int speed = Integer.parseInt(input[1]);
        	queue.offer(new Pair(high,speed));
        }
        for(int i=0;i<m;i++) {
        	input = br.readLine().split(" ");
        	int high = Integer.parseInt(input[0]);
        	int speed = Integer.parseInt(input[1]);
        	int val=high;
        	
        	while(!queue.isEmpty()) {
        		
        		Pair p = queue.poll();
        		int tmp = p.high;
        		p.high-=val;
        		val-=tmp;
        		if(p.speed<speed)
        			answer=Math.max(speed-p.speed, answer);
            	if(p.high>0)
            		queue.addFirst(p);
            	if(val<=0)
            		break;
        	}
        }
        
        System.out.println(answer);
        br.close();
    }
}
