package 비밀메뉴;

import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m=Integer.parseInt(input[0]), n=Integer.parseInt(input[1]), k=Integer.parseInt(input[2]);
        String control = br.readLine(), answer="normal";
        input = br.readLine().split(" ");
        int l=input.length;
        if(n<m){
            answer="normal";
        }else{
            loop : for(int h=0;h<l;h++){
                StringBuilder sb = new StringBuilder();
                for(int i=h;i<l;i++){
                    for(int j=i;j<l;j++){
                        sb.append(input[j]).append(" ");
                        if(sb.toString().trim().equals(control)){
                            answer="secret";
                            break loop;
                        }
                    }
                }
            }
        }
        System.out.println(answer);

        br.close();
    }
}
