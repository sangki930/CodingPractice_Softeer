package 바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long k = Long.parseLong(input[0]), p = Long.parseLong(input[1]), n=Long.parseLong(input[2]);
        for(int i=1;i<=n;i++){
            k=(k * p) % 1000000007;
        }
        System.out.println(k);
        br.close();
    }
}