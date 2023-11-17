package boj.silver.boj28075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @see <a href="https://www.acmicpc.net/problem/28075">link</a>
 */
public class Main {
    private static int N;
    private static int M;

    private static int count=0;
    private static int[] points;
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        points =new int[7];

        st=new StringTokenizer(br.readLine());
        points[0] = Integer.parseInt(st.nextToken());
        points[1] = Integer.parseInt(st.nextToken());
        points[2] = Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        points[3] = Integer.parseInt(st.nextToken());
        points[4] = Integer.parseInt(st.nextToken());
        points[5] = Integer.parseInt(st.nextToken());

        getTotalPoint(0,0,-1,-1);
        System.out.println(count);
    }
    private static void getTotalPoint(int index, int point, int lastIndex, int nextPointIndex){
        int newPoint=point;
        if(nextPointIndex!=-1){
            if(lastIndex!=-1 && lastIndex%3 == nextPointIndex%3){
                newPoint+=points[nextPointIndex]/2;
            }else{
                newPoint+=points[nextPointIndex];
            }
        }

        if(newPoint>=M){
            count+=Math.pow(6,N-index);
            return;
        }
        if(index==N) {
            return;
        }

        getTotalPoint(index+1, newPoint, nextPointIndex, 0);
        getTotalPoint(index+1, newPoint, nextPointIndex, 1);
        getTotalPoint(index+1, newPoint, nextPointIndex, 2);
        getTotalPoint(index+1, newPoint, nextPointIndex, 3);
        getTotalPoint(index+1, newPoint, nextPointIndex, 4);
        getTotalPoint(index+1, newPoint, nextPointIndex, 5);

    }
}
