package boj.bronze.boj16171;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = br.read();
        StringBuilder pureTextBook= new StringBuilder();
        while(a!=10){
            if(a<48||a>57){
                pureTextBook.append((char)a);
            }
            a=br.read();
        }
        System.out.println(pureTextBook.toString().contains(br.readLine())?1:0);



    }

}
