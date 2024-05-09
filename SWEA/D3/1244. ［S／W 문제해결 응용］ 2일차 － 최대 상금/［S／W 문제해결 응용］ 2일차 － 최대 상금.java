import java.util.*;
import java.io.*;

class Solution
{
	 static int answer = -99;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            answer = -99;
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int limit = Integer.parseInt(st.nextToken());

            char numArr[] = num.toCharArray();
            if (numArr.length < limit) {
                limit = numArr.length;
            }

            calc(0, limit, numArr);
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void calc(int cnt, int limit, char[] numArr) {
        if (cnt == limit) {
            StringBuilder num = new StringBuilder();
            for (char d : numArr) {
                num.append(d);
            }
            answer = Math.max(Integer.parseInt(num.toString()), answer);
            return;
        }

        for (int i = 0; i < numArr.length; i++) {
            for (int j = i + 1; j < numArr.length; j++) {
                char temp = numArr[i];
                numArr[i] = numArr[j];
                numArr[j] = temp;

                calc(cnt + 1, limit, numArr);

                temp = numArr[i];
                numArr[i] = numArr[j];
                numArr[j] = temp;
            }
        }
    }
}