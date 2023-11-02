package boj.silver.boj14594;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @see <a href="https://www.acmicpc.net/problem/14594">link</a>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int N = Integer.parseInt(br.readLine());
        int[] rooms = new int[N+1];
        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            stringTokenizer=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(stringTokenizer.nextToken());
            int y=Integer.parseInt(stringTokenizer.nextToken());
            for(int j=x;j<y;j++){
                rooms[j]=-1;
            }
        }
        int result = 0;
        for(int i=0;i<N+1;i++){
            if(rooms[i]==0) result++;
        }
        System.out.println(result-1);
    }
}


// N개의 방('n'은 벽을 의미)
//'0' 1 '1' 2 '2' 3 '3' 4 '4' 5 '5' ... N 'N'
//2 4 -> 3 5
//방 5개
//2 4-> 2, 3이 사라짐->벽 2개가 사라지면 방도 2개가 사라짐=>사라진 벽의 개수만큼 방이 사라짐
