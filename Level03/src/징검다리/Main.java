package 징검다리;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }
        int answer = 0;

        for(int d  : dp) answer = Math.max(answer,d);
        System.out.println(answer);
        br.close();
    }
}