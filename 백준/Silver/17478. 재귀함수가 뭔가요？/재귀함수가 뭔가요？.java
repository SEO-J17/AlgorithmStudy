import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		basicStr();
		calc(1, n);
		sb.append("라고 답변하였지.");
		System.out.println(sb.toString());
	}

	private static void calc(int depth, int n) {
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			sb2.append("____");
		}
		String prefix = sb2.toString();
		
		if (depth == n) {
			sb
			.append(prefix)
			.append("\"재귀함수가 뭔가요?\"\n")
			.append(prefix)
			.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n")
			.append(prefix)
			.append("라고 답변하였지.\n");
			return;
		}
		
		sb
		.append(prefix)
		.append("\"재귀함수가 뭔가요?\"\n")
		.append(prefix)
		.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n")
		.append(prefix)
		.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n")
		.append(prefix)
		.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		calc(depth + 1, n);
		sb.append(prefix).append("라고 답변하였지.\n");
	}

	private static void basicStr() {
		sb
		.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n")
		.append("\"재귀함수가 뭔가요?\"\n")
		.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n"
				+ "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n"
				+ "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
	}
}
