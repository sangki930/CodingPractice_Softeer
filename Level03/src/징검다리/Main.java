package 징검다리;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }else{
                    dp[i] = Math.max(dp[j],dp[i]);
                }
            }
        }
        System.out.println(dp[n-1]);
        br.close();
    }
}