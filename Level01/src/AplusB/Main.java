package AplusB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input =  br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        
        for(int i=1;i<=n;i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]);
            System.out.println("Case #"+i+": "+(a+b));
        }   

        br.close();
    }
}