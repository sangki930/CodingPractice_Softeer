package 주행거리비교하기;

import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int A = Integer.parseInt(tmp[0]), B = Integer.parseInt(tmp[1]);
        String answer = "";
        if(A>B){
            answer = "A";
        }else if(A<B) answer = "B";
        else answer = "same";
        System.out.println(answer);

        br.close();
    }
}
