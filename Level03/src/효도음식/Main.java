package 효도음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] dp1 = new long[n];
        long[] dp2 = new long[n];
        long localMax = arr[0];
        long globalMax = arr[0];
        dp1[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            localMax = Math.max(arr[i], localMax + arr[i]);
            if(localMax > globalMax) {
                globalMax = localMax;
            }
            dp1[i] = globalMax;
        }
        localMax = arr[n-1];
        globalMax = arr[n-1];
        dp2[n-1] = arr[n-1];
        for(int i=arr.length-2;i>=0;i--){
            localMax = Math.max(arr[i], localMax + arr[i]);
            if(localMax > globalMax) {
                globalMax = localMax;
            }
            dp2[i] = globalMax;
        }
        long answer = Long.MIN_VALUE;

        for(int i=0;i<n-2;i++){
            answer = Math.max(answer, dp1[i] + dp2[i+2]);
        }
        System.out.println(answer);

        br.close();
    }

}
