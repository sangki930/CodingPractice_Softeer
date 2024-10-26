package HanyangPopularityExceedingCompetition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Pair{
    int x;  // 인기도
    int index;
    public Pair(int x, int index){
        this.x = x;
        this.index = index;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            String[] input=br.readLine().split(" ");
            int p = Integer.parseInt(input[0]), c= Integer.parseInt(input[1]);
            arr[i] = new int[]{p,c};
        }

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(0,0));
        stack.push(new Pair(cal_popularity(arr[0][0],arr[0][1],0),0));
        int answer = 0;
        int[] x_dp = new int[n];
        while (!stack.isEmpty()){
            Pair p = stack.pop();
            if(p.index == n-1){
                answer = Math.max(answer,p.x);
                continue;
            }
            int x_tmp = cal_popularity(arr[p.index+1][0],arr[p.index+1][1],p.x);
            if(x_tmp == p.x+1 && x_dp[p.index+1]<x_tmp) {
                x_dp[p.index+1] = x_tmp;
                stack.push(new Pair(x_tmp, p.index + 1));
            }
            if(x_dp[p.index+1]<p.x){
                x_dp[p.index+1] = p.x;
                stack.push(new Pair(p.x,p.index+1));
            }

        }
        System.out.println(answer);

        br.close();
    }

    public static int cal_popularity(int p, int c, int x){
        if(Math.abs(p-x)<=c) return x+1;
        return x;
    }
}
