package 근무시간;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        for(int i=0;i<5;i++){
            String[] tmp = br.readLine().split(" ");
            answer+=(convert(tmp[1])-convert(tmp[0]));
        }
        System.out.println(answer);
        br.close();
    }

    public static int convert(String time){
        String[] tmp = time.split(":");
        return Integer.parseInt(tmp[0])*60+Integer.parseInt(tmp[1]);
    }
}