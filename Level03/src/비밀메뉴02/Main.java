package 비밀메뉴02;

import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]), m =Integer.parseInt(input[1]), k = Integer.parseInt(input[2]);
        int[] A = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int[][] dp = new int[n][m];
        int answer = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(A[i]==B[j]){
                    if(i==0 || j==0) dp[i][j]=1;
                    else dp[i][j] = dp[i-1][j-1]+1;
                    answer = Math.max(answer,dp[i][j]);
                }
            }
        }
        System.out.println(answer);
        br.close();
    }
}