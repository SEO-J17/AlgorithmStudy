import java.io.*;
import java.util.*;

public class Main {
    private static class Team {
        int teamNum;
        int submitCnt;
        int score;
        int lastSubmitTime;

        private Team(int teamNum, int submitCnt, int score, int lastSubmitTime) {
            this.teamNum = teamNum;
            this.submitCnt = submitCnt;
            this.score = score;
            this.lastSubmitTime = lastSubmitTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int problem = Integer.parseInt(st.nextToken());
            int myTeam = Integer.parseInt(st.nextToken());
            int log = Integer.parseInt(st.nextToken());

            int teamScore[][] = new int[n + 1][problem + 1];
            int submitCnt[] = new int[n + 1];
            int submitTime[] = new int[n + 1];

            for (int i = 0; i < log; i++) {
                st = new StringTokenizer(br.readLine());
                int teamNum = Integer.parseInt(st.nextToken());
                int problemNum = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                teamScore[teamNum][problemNum] = Math.max(teamScore[teamNum][problemNum], score);
                submitCnt[teamNum]++;
                submitTime[teamNum] = i + 1;
            }

            List<Team> list = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                int sum = 0;
                for (int j = 1; j <= problem; j++) {
                    sum += teamScore[i][j];
                }
                list.add(new Team(i, submitCnt[i], sum, submitTime[i]));
            }

            list.sort((o1, o2) -> {
                if (o1.score == o2.score) {
                    if (o1.submitCnt == o2.submitCnt) {
                        return o1.lastSubmitTime - o2.lastSubmitTime;
                    }
                    return o1.submitCnt - o2.submitCnt;
                }
                return o2.score - o1.score;
            });

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).teamNum == myTeam) {
                    sb.append(i + 1).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}