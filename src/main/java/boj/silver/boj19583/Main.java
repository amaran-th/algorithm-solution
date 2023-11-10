package boj.silver.boj19583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @see <a href="https://www.acmicpc.net/problem/19583">link</a>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();
        Set<String> entrance = new HashSet<>();
        Set<String> result = new HashSet<>();
        String chatting=br.readLine();
        while(chatting!=null){
            st=new StringTokenizer(chatting);
            String timeStamp=st.nextToken();
            String nickName=st.nextToken();

            if(timeStamp.compareTo(S)<=0){
                entrance.add(nickName);
            }else if(timeStamp.compareTo(E)<0) {
            }else if(timeStamp.compareTo(Q)<=0){
                if(entrance.contains(nickName)){
                    result.add(nickName);
                }
            }
            chatting=br.readLine();
        }
        System.out.println(result.size());
    }
}
