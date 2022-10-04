package 통근버스출발순서검증하기;

import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n+1][n+1];
        int[] buses = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i=n-1;i>=0;i--){
            for(int j=1;j<n+1;j++){
                if(buses[i]<j)
                    dp[j][i] = dp[j][i+1]+1;
                else
                    dp[j][i] = dp[j][i+1];
            }
        }

        long answer = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(buses[i]<buses[j])
                    answer+=dp[buses[i]][j];
            }
        }

        System.out.println(answer);

        br.close();
    }
}
