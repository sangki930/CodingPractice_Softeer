package 거리합구하기;

import java.util.*;
import java.io.*;

class Node{
	int node;
	long w;
	public Node(int node, long w) {
		this.node = node;
		this.w = w;
	}
}

public class Main
{
	static LinkedList<Node>[] map;
	static long[] distSum;
	static long[] subtreeSize;
	static int n;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        // Map<Integer,LinkedList<Integer>> map = new HashMap<>();
        map = new LinkedList[n+1];
        distSum = new long[n+1];
        subtreeSize = new long[n+1];
        String[] input;
		map[0] = new LinkedList<Node>();
        for(int i=0;i<n-1;i++){
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]), e = Integer.parseInt(input[1]), w = Integer.parseInt(input[2]);

            LinkedList<Node> arr1 = map[s]==null?new LinkedList<Node>():map[s];
            LinkedList<Node> arr2 = map[e]==null?new LinkedList<Node>():map[e];

            arr1.add(new Node(e,w));
            arr2.add(new Node(s,w));

            map[s] = arr1;
            map[e] = arr2;
        }
        
        dfs1(1,1);
        dfs2(1,1);
        
        for(int i=1;i<=n;i++)
        	System.out.println(distSum[i]);
        
        br.close();
    }
    
    private static void dfs1(int current, int parent) {
    	subtreeSize[current] = 1;
    	LinkedList<Node> list = map[current];
		if(list==null) list = new LinkedList<>();
    	for(Node e  : list) {
    		int child = e.node;
    		long w = e.w;
    		if(child!=parent) {
    			dfs1(child,current);
    			distSum[current] += distSum[child] + subtreeSize[child]*w;
    			subtreeSize[current] += subtreeSize[child];
    		}
    	}
    }
    
    private static void dfs2(int current, int parent) {
    	
    	LinkedList<Node> list = map[current];
		if(list==null) list = new LinkedList<>();
    	for(Node e  : list) {
    		int child = e.node;
    		long w = e.w;
    		if(child!=parent) {
    			distSum[child] = distSum[current] + (n-2*subtreeSize[child])*w;
    			dfs2(child,current);
    		}
    	}
    }
}