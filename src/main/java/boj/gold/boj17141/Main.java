package boj.gold.boj17141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @see <a href="https://www.acmicpc.net/problem/17141">link</a>
 * fail
 */
public class Main {
    static int N, M;
    static int[][] lab;
    static int min = Integer.MAX_VALUE;
    static int max = -1;
    static List<Position> virusList;
    static boolean[][] visited;
    static int[][] copy_lab;
    static boolean[] virusVisited;
    static int[] virusArr;
    static int[] drow = {-1, 1, 0, 0};
    static int[] dcol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        virusList=new ArrayList<>();
        lab = new int[N][N];
        copy_lab = new int[N][N];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                lab[i][j]=Integer.parseInt(st.nextToken());
                if(lab[i][j]==2){
                    virusList.add(new Position(i, j, 0));
                }
            }
        }
        virusVisited = new boolean[virusList.size()];
        virusArr=new int[M];
        makeVirus(0,0);
        if(min==Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(min);
    }

    private static void makeVirus(int index, int count){
        if(count == M){
            spread();
            return;
        }
        for(int i=index;i<virusList.size();i++){
            if(!virusVisited[i]){
                virusArr[count]=i;
                virusVisited[i]=true;
                makeVirus(i+1, count+1);
                virusVisited[i]=false;

            }
        }
    }
    private static void spread(){
        max = -1;
        copy();
        visited=new boolean[N][N];
        Queue<Position> q=new LinkedList<>();
        for(int i=0;i<M;i++){
            Position virusPos = virusList.get(virusArr[i]);
            q.add(virusPos);
            copy_lab[virusPos.row][virusPos.col] = 2;
        }

        while(!q.isEmpty()){
            Position currentPos = q.poll();
            int crow = currentPos.row;
            int ccol = currentPos.col;
            int ctime = currentPos.time;
            max = Math.max(max, ctime);
            for(int i=0;i<4;i++){
                int nrow = crow + drow[i];
                int ncol = ccol + dcol[i];
                if(ncol<0||nrow<0||ncol>=N||nrow>=N){
                    continue;
                }
                if(!visited[nrow][ncol]&&(copy_lab[nrow][ncol]==0)){
                    copy_lab[nrow][ncol] = 2;
                    visited[nrow][ncol]=true;
                    q.add(new Position(nrow, ncol, ctime+1));
                }
            }

        }
        if(isEmptyExist()) return;
        min=Math.min(min,max);
    }
    private static void copy(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(lab[i][j]==2){
                    copy_lab[i][j]=0;
                }else{
                    copy_lab[i][j]=lab[i][j];
                }
            }
        }
    }
    public static boolean isEmptyExist(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(copy_lab[i][j]==0)
                    return true;
            }
        }
        return false;
    }

}

class Position{
    int row;
    int col;
    int time;

    public Position(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
