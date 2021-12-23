package 스마트_물류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), k =Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        char[] ch=input[0].toCharArray();
        int answer=0;
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='P'){
                for(int j=-k;j<=k;j++){
                    if(i+j>=0 && i+j<ch.length){
                        if(ch[i+j]=='H'){
                            ch[i]='X';
                            ch[i+j]='X';
                            answer++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
        br.close();   
    }
}