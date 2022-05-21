package ¼ºÀûÆò±Õ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), k = Integer.parseInt(input[1]);
        double d[]=new double[n+1];
        input = br.readLine().split(" ");
        for(int i=1;i<=n;i++){
            d[i]=d[i-1]+Double.parseDouble(input[i-1]);
        }
        for(int i=0;i<k;i++){
            input = br.readLine().split(" ");
            double s = Double.parseDouble(input[0]), e = Double.parseDouble(input[1]);
            double avg = (d[(int)e]-d[(int)s-1])/(e-s+1.0);
            System.out.println(Math.round(avg*100)/100.00);
        }
        br.close();
    }
}