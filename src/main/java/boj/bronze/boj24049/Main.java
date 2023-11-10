package boj.bronze.boj24049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @see <a href="https://www.acmicpc.net/problem/24049">link</a>
 */
public class Main {
    private static boolean[][] garden;
    public static void main(String[] args) throws IOException {
        final BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        garden = new boolean[N+1][M+1];

        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            garden[i][0]=st.nextToken().equals("1");
        }
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=M;i++){
            garden[0][i]=st.nextToken().equals("1");
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                garden[i][j]=garden[i-1][j]!=garden[i][j-1];
            }
        }
        System.out.println(garden[N][M]?"1":"0");
    }
}

// flower(n,m)=flower(n-1,m)!=flower(n,m-1);
// flower(n,m)=flower(n-2,m)!=flower(n,m-2);
// ...
// flower(n,m)=flower(n-2^x,m)!=flower(n,m-2^x);
