package 코딩테스트_세트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 참고 : softeer 알고튜터
public class Main
{
    static long[] a,b;
    static int n,t;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        t = Integer.parseInt(input[1]);

        for(int i=0;i<t;i++){
            input = br.readLine().split(" ");
            a = new long[n]; b = new long[n-1];
            for(int j=0;j<2*n-1;j++){
                if(j%2==0) a[j/2] = Long.parseLong(input[j]);
                else b[j/2] = Long.parseLong(input[j]);
            }
            long answer = 0;
            long low = 0, high = (2L)*(long)Math.pow(10,12), mid = 0;
            
            System.out.println(binarySearch(low,high));
        }

        br.close();
    }

    public static boolean test(long mid){
        long[] s = new long[t];
        long now = a[0];
        for(int j=0;j<n-1;j++){
            if(now>=mid){
                now = a[j+1] + b[j];
            }else if(now+b[j]>=mid){
                now = a[j+1] + (now+b[j]-mid);
            }else{
                return false;
            }
        }
        if(now<mid) return false;
        return true;
    }

    public static long binarySearch(long start,long end){
        if(start==end)
            return start;
        long mid = (start+end+1)/2;
        if(test(mid))
            mid = binarySearch(mid,end);
        else
            mid = binarySearch(start,mid-1);
        return mid;
    }
}
