package 플레이페어암호;

import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String key = br.readLine();
        StringBuilder sbkey = new StringBuilder();
        boolean[] alphabet = new boolean['Z'-'A'+1];
        alphabet['J'-'A'] = true;
        for(int i=0;i<key.length();i++){
            char c = key.charAt(i);
            if(!alphabet[c-'A']){
                sbkey.append(c);
                alphabet[c-'A'] = true;
            }
        }

        for(int i=0;i<'Z'-'A'+1;i++){
            char c = (char)('A'+i);
            if(!alphabet[c-'A']){
                sbkey.append(c);
                alphabet[c-'A'] = true;
            }
        }

        Map<Character,int[]> location = new HashMap<>();
        // System.out.println(sbkey);
        char[][] map = new char[5][5];
        for(int i=0;i<sbkey.length();i++){
            char ch = sbkey.charAt(i);
            int r = i/5, c = i%5;
            map[r][c] = ch;
            location.put(ch,new int[]{r,c});
        }
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<str.length();){
            String pair="";
            if(i==str.length()-1){
                pair = str.charAt(str.length()-1)+"X";
                i++;
            }else{
                if(str.charAt(i)==str.charAt(i+1)){
                    pair = str.charAt(i)+"";
                    if(str.charAt(i)=='X')
                        pair+="Q";
                    else
                        pair+="X";
                    i++;
                }else{
                    pair = str.charAt(i)+""+str.charAt(i+1);
                    i+=2;
                }
            }
            char c1 = pair.charAt(0), c2 = pair.charAt(1);
            int[] loc1 = location.get(c1), loc2 = location.get(c2);
            if(loc1[0]==loc2[0]){
                answer.append(map[loc1[0]][(loc1[1]+1)%5]).append(map[loc2[0]][(loc2[1]+1)%5]);
            }else if(loc1[1]==loc2[1]){
                answer.append(map[(loc1[0]+1)%5][loc1[1]]).append(map[(loc2[0]+1)%5][loc2[1]]);
            }else{
                answer
                .append(map[loc1[0]][loc2[1]])
                .append(map[loc2[0]][loc1[1]]);
            }
        }

        System.out.println(answer);

        br.close();
    }
}