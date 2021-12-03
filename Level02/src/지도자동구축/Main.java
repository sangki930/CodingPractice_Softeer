package 지도자동구축;

import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a=3;
        for(int i=2;i<=n;i++)
            a = 2*a-1;
        System.out.println(a*a);
        br.close();
    }
}
