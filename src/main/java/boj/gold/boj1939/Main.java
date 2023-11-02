package boj.gold.boj1939;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @see <a href="https://www.acmicpc.net/problem/1939">link</a>
 * fail
 */
public class Main {
    private static int ans;
    private static List<City>[] edges;
    private static boolean[] isVisit;
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        edges=new ArrayList[N];
        for(int i=0;i<N;i++){
            edges[i] = new ArrayList<>();
        }

        int low = 0;
        int high = 0;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken())-1;
            int B = Integer.parseInt(st.nextToken())-1;
            int C = Integer.parseInt(st.nextToken());

            edges[A].add(new City(B, C));
            edges[B].add(new City(A, C));

            high = Math.max(high, C);
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken())-1;
        int end = Integer.parseInt(st.nextToken())-1;
        while(low <= high){
            int mid = (low+high)/2;
            ans=-1;
            isVisit=new boolean[N];
            search(start, end, mid);
            if(ans!=-1){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        System.out.println(high);
    }
    private static void search(int start, int end, long weight){
        if(start==end){
            ans=start;
            return;
        }
        isVisit[start]=true;

        for(City city: edges[start]){
            if(!isVisit[city.neighborCity] && weight<=city.weight){
                search(city.neighborCity, end, weight);
            }
        }
    }

}
class City {
    int neighborCity;
    int weight;

    public City(int neighborCity, int weight) {
        this.neighborCity = neighborCity;
        this.weight = weight;
    }
}
//섬 사이에 다리가 존재.
//- 양방향 그래프
//- 간선에 가중치 존재
//- 두 섬 사이에 2개 이상의 다리 존재 가능


