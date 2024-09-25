package 효도음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[] dp = new long[n];
        long[] dp2 = new long[n];
        Arrays.fill(dp, Long.MIN_VALUE);
        Arrays.fill(dp2, Long.MIN_VALUE);

        int left = 0, right = 0;
        long sum = arr[0];
        dp[0] = sum;
        while(0<=left && left<n-2 && 0 <= right && right<n-2){

            if(left == right || sum + arr[right] >= sum){
                sum+=arr[++right];
            }else{
                sum-=arr[left++];
            }
            dp[right] = Math.max(Math.max(dp[right], sum),dp[right-1]);
            //System.out.println("sum : "+sum+", left : "+left+", right : "+right);
        }
        left = n-1; right = n-1;
        sum = arr[n-1];
        dp2[n-1] = sum;
        while(2<=left && left<n && 2 <= right && right<n){

            if(left == right || sum + arr[left] >= sum){
                sum+=arr[--left];
            }else{
                sum-=arr[right--];
            }
            dp2[left] = Math.max(Math.max(dp2[left], sum),dp2[left+1]);
            //System.out.println("sum : "+sum+", left : "+left+", right : "+right);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(dp2));

        br.close();
    }

}
