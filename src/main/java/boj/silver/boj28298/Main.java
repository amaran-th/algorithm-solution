package boj.silver.boj28298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @see <a href="https://www.acmicpc.net/problem/28298">link</a>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] tiles = new char[N][M];
        List<Character>[][] patterns = new List[K][K];
        char[][] result = new char[K][K];
        int count = 0;

        for(int i=0;i<K;i++){
            for(int j=0;j<K;j++){
                patterns[i][j]=new ArrayList<>();
            }
        }
        for(int i=0;i<N;i++){
            String line=br.readLine();
            for(int j=0;j<M;j++){
                tiles[i][j] = line.charAt(j);
                patterns[i%K][j%K].add(tiles[i][j]);
            }
        }

        for(int i=0;i<K;i++){
            for(int j=0;j<K;j++){
                Map<Character, Integer> map = new HashMap<>();
                for(char tile : patterns[i][j]){
                    map.put(tile,map.getOrDefault(tile,0)+1);
                }
                int max=0;
                char maxChar=' ';
                for(Map.Entry<Character, Integer> entry : map.entrySet()){
                    if(entry.getValue()>max){
                        max=entry.getValue();
                        maxChar=entry.getKey();
                    }
                }
                result[i][j]= maxChar;
                count+=(N/K)*(M/K)-max;
            }
        }
        System.out.println(count);
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(result[i%K][j%K]);
            }
            System.out.println();
        }
    }

}
