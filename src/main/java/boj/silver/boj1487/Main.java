package boj.silver.boj1487;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @see <a href="https://www.acmicpc.net/problem/1487">link</a>
 */
public class Main  {
    private static List<Stuff> sortedStuffs;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N =Integer.parseInt(br.readLine());
        Stuff[] stuffs = new Stuff[N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int origin = Integer.parseInt(st.nextToken());
            int fee = Integer.parseInt(st.nextToken());
            stuffs[i]=new Stuff(origin, fee);
        }
        sortedStuffs = Arrays.stream(stuffs)
                .sorted(Comparator.comparing(Stuff::getOrigin).reversed())
                .collect(Collectors.toList());
        int maxi=-1;
        int max=0;
        for(int i=N-1;i>=0;i--){
            int pureBenefit=getPureBenefit(sortedStuffs.get(i).getOrigin());
            if(pureBenefit>max){
                max=pureBenefit;
                maxi=i;
            }
        }
        if(maxi==-1) {
            System.out.println(0);
            return;
        }
        int result = sortedStuffs.get(maxi).getOrigin();
        System.out.println(result);

    }

    private static int getPureBenefit(int price) {
        int result = 0;
        for(int i = 0; i<N&&sortedStuffs.get(i).getOrigin()>=price; i++){
            int pureBenefit = price-sortedStuffs.get(i).getFee();
            if(pureBenefit>0) result+= pureBenefit;
        }
        return result;
    }

}

class Stuff{
    private int origin; // 원가
    private int fee; // 배송비
    public Stuff(int origin, int fee){
        this.origin=origin;
        this.fee = fee;
    }
    public int getOrigin(){
        return origin;
    }
    public int getFee(){
        return fee;
    }
}
/*
3
13 8
22 7
35 5
 */