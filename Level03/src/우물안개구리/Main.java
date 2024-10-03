package 우물안개구리;

import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n =Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        int[] w = new int[n+1], c = new int[n+1], s = new int[n+1];
        int answer=0;
        for(int i=1;i<=n;i++){
            w[i]=Integer.parseInt(input[i-1]);
        }
        for(int i=0;i<m;i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]), b=Integer.parseInt(input[1]);
            c[a]++;c[b]++;
            if(w[a]<w[b]){
                s[a]--;s[b]++;
            }else if(w[a]>w[b]){
                s[a]++;s[b]--;
            }
        }
        for(int i=1;i<=n;i++){
            if(s[i]==c[i] || c[i]==0) answer++;
        }
        System.out.println(answer);
        br.close();
    }
}