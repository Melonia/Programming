package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N14889 {

	static int min = 40000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] S = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] team = new int[N / 2];
		int depth = 0;
		boolean[] visited = new boolean[N];
		int next = 0;
		dfs(depth, next, team, S, visited);
		System.out.println(min);
	}

	static void dfs(int depth, int next, int[] team, int[][] S, boolean[] visited) {
		if (depth == team.length) {
			int result = operate(team, S);
			if (min > result)
				min = result;
			return;
		}
		for (int i = next; i < visited.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				team[depth] = i;
				dfs(depth + 1, i, team, S, visited);
				team[depth] = 0;
				visited[i] = false;
			}
		}
	}

	static int operate(int[] team, int[][] S) {
		int N = team.length * 2;
		int Ssum1 = 0;
		for (int i = 0; i < team.length; i++) {
			for (int j = 0; j < team.length; j++) {
				if (i == j)
					continue;
				Ssum1 += S[team[i]][team[j]];
			}
		}

		int[] team2 = new int[team.length];
		int k = 0;
		for (int i = 0; i < N; i++) {
			int count = 0;
			for (int j = 0; j < N / 2; j++) {
				if (team[j] == i)
					count++;
			}
			if (count == 0)
				team2[k++] = i;
		}

		int Ssum2 = 0;
		for (int i = 0; i < team2.length; i++) {
			for (int j = 0; j < team2.length; j++) {
				if (i == j)
					continue;
				Ssum2 += S[team2[i]][team2[j]];
			}
		}

		return abs(Ssum2 - Ssum1);
	}

	static int abs(int num) {
		if (num > 0)
			return num;
		else
			return -num;
	}
}

/*
����
������ ��ŸƮ��ũ�� �ٴϴ� ������� �𿩼� �౸�� �غ����� �Ѵ�. �౸�� ���� ���Ŀ� �ϰ� �ǹ� ������ �ƴϴ�. �౸�� �ϱ� ���� ���� ����� �� N���̰� �ű��ϰԵ� N�� ¦���̴�. ���� N/2������ �̷���� ��ŸƮ ���� ��ũ ������ ������� ������ �Ѵ�.

BOJ�� ��ϴ� ȸ�� ��� ������� ��ȣ�� 1���� N������ �����߰�, �Ʒ��� ���� �ɷ�ġ�� �����ߴ�. �ɷ�ġ Sij�� i�� ����� j�� ����� ���� ���� ������ ��, ���� �������� �ɷ�ġ�̴�. ���� �ɷ�ġ�� ���� ���� ��� ���� �ɷ�ġ Sij�� ���̴�. Sij�� Sji�� �ٸ� ���� ������, i�� ����� j�� ����� ���� ���� ������ ��, ���� �������� �ɷ�ġ�� Sij�� Sji�̴�.

N=4�̰�, S�� �Ʒ��� ���� ��츦 ���캸��.

i\j	1	2	3	4
1	 	1	2	3
2	4	 	5	6
3	7	1	 	2
4	3	4	5	 
���� ���, 1, 2���� ��ŸƮ ��, 3, 4���� ��ũ ���� ���� ��쿡 �� ���� �ɷ�ġ�� �Ʒ��� ����.

��ŸƮ ��: S12 + S21 = 1 + 4 = 5
��ũ ��: S34 + S43 = 2 + 5 = 7
1, 3���� ��ŸƮ ��, 2, 4���� ��ũ ���� ���ϸ�, �� ���� �ɷ�ġ�� �Ʒ��� ����.

��ŸƮ ��: S13 + S31 = 2 + 7 = 9
��ũ ��: S24 + S42 = 6 + 4 = 10
�౸�� ����ְ� �ϱ� ���ؼ� ��ŸƮ ���� �ɷ�ġ�� ��ũ ���� �ɷ�ġ�� ���̸� �ּҷ� �Ϸ��� �Ѵ�. ���� ������ ���� ��쿡�� 1, 4���� ��ŸƮ ��, 2, 3�� ���� ��ũ ���� ���ϸ� ��ŸƮ ���� �ɷ�ġ�� 6, ��ũ ���� �ɷ�ġ�� 6�� �Ǿ ���̰� 0�� �ǰ� �� ���� �ּ��̴�.

�Է�
ù° �ٿ� N(4 �� N �� 20, N�� ¦��)�� �־�����. ��° �ٺ��� N���� �ٿ� S�� �־�����. �� ���� N���� ���� �̷���� �ְ�, i�� ���� j��° ���� Sij �̴�. Sii�� �׻� 0�̰�, ������ Sij�� 1���� ũ�ų� ����, 100���� �۰ų� ���� �����̴�.

���
ù° �ٿ� ��ŸƮ ���� ��ũ ���� �ɷ�ġ�� ������ �ּڰ��� ����Ѵ�.
*/