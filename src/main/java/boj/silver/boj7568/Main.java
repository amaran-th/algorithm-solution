package boj.silver.boj7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @see <a href="https://www.acmicpc.net/problem/7568">link</a>
 */
public class Main {
    private static int N;
    private static Size[] sizes;
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sizes=new Size[N];
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            sizes[i]=new Size(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        String[] result = new String[N];
        for(int i=0;i<N;i++){
            result[i]=String.valueOf(getRanking(i));
        }
        System.out.println(String.join(" ",result));
    }
    private static int getRanking(int index){
        int count = 1;
        for(int i=0;i<N;i++){
            if(i==index) continue;
           if( sizes[i].isBiggerThan(sizes[index])) count++;
        }
        return count;
    }

}

class Size{
    int weight;
    int length;

    public Size(int weight, int length){
        this.weight=weight;
        this.length=length;
    }
    public boolean isBiggerThan(Size compare){
        return weight>compare.weight&&length>compare.length;
    }
}
