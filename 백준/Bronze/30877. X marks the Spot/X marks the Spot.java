import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine().toUpperCase());
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            int idx = str1.indexOf('X');
            sb.append(str2.charAt(idx));
        }
        
        System.out.println(sb);
    }
}