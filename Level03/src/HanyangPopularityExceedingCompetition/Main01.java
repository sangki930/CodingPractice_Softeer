package HanyangPopularityExceedingCompetition;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            String[] input=br.readLine().split(" ");
            int p = Integer.parseInt(input[0]), c= Integer.parseInt(input[1]);
            arr[i] = new int[]{p,c};
        }

        int[][] dp = new int[2][n];
        dp[0][0] = cal_popularity(arr[0][0],arr[0][1],0);
        int answer = Math.max(dp[0][0],dp[1][0]);
        for(int i=1;i<n;i++){
            dp[0][i] = Math.max(cal_popularity(arr[i][0],arr[i][1],dp[0][i-1]),cal_popularity(arr[i][0],arr[i][1],dp[1][i-1]));
            dp[1][i] = Math.max(dp[0][i-1], dp[1][i-1]);
            answer = Math.max(answer,Math.max(dp[0][i],dp[1][i]));
        }

        System.out.println(answer);

        br.close();
    }

    public static int cal_popularity(int p, int c, int x){
        if(Math.abs(p-x)<=c) return x+1;
        return x;
    }
}
