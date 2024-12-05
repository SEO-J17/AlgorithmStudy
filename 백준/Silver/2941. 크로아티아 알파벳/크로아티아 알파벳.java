import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String pattern : croatia) {
            while (input.contains(pattern)) {
                input = input.replaceFirst(pattern, "@"); 
            }
        }

        System.out.println(input.length());
    }
}
