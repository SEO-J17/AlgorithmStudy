import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<String> leftStack = new Stack<>();
        Stack<String> rightStack = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            leftStack.push(String.valueOf(word.charAt(i)));
        }

        for (int i = 0; i < n; i++) {
            String[] cmd = br.readLine().split(" ");
            if (cmd.length == 1) {
                if (cmd[0].equals("L")) {
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                } else if (cmd[0].equals("D")) {
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                } else if (cmd[0].equals("B")) {
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                }
            } else if (cmd.length == 2) {
                if (cmd[0].equals("P")) {
                    leftStack.push(cmd[1]);
                }
            }
        }

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        System.out.println(sb);
    }
}