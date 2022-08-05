package 수퍼바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    private static final long MOD = 1000000007;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long k = Long.parseLong(input[0]), p = Long.parseLong(input[1]), n = Long.parseLong(input[2]);
        System.out.println((func(p,10*n)*k)%MOD);
        br.close();
    }

    public static long func(long p,long n){
        if(n==1) return p;
        long ret = func(p,n/2);
        ret = ret * ret % MOD;
        if(n%2==1) ret = (ret*p)%MOD;
        return ret;
    }
}
