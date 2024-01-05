import java.io.*;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        calc(s, t);

        System.out.println(answer);
    }

    private static void calc(String s, String t) {
        if (t.length() <= s.length()) {
            if (s.equals(t)) {
                answer = 1;
            }
            return;
        }

        if (t.charAt(t.length() - 1) == 'A') {
            calc(s, t.substring(0, t.length() - 1));
        }

        if (t.charAt(0) == 'B') {
            calc(s, new StringBuilder(t.substring(1, t.length())).reverse().toString());
        }
    }
}