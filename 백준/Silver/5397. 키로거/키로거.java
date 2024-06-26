import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            // 스택 이용
            ArrayDeque<String> left = new ArrayDeque<>();
            ArrayDeque<String> right = new ArrayDeque<>();

            for (int j = 0; j < word.length(); j++) {
                char s = word.charAt(j);

                switch (s) {
                    case '<': {
                        if (!left.isEmpty()) {
                            right.push(left.pop());
                        }
                        break;
                    }

                    case '>': {
                        if (!right.isEmpty()) {
                            left.push(right.pop());
                        }
                        break;
                    }

                    case '-': {
                        if (!left.isEmpty()) {
                            left.pop();
                        }
                        break;
                    }

                    default: {
                        left.push(String.valueOf(s));
                        break;
                    }
                }
            }

            while (!right.isEmpty()) {
                left.push(right.pop());
            }

            while (!left.isEmpty()) {
                sb.append(left.pollLast());
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
        
    }
}
