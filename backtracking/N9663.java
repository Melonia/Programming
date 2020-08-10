package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9663 {
	static int count = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = solution(Integer.parseInt(br.readLine()));
		System.out.println(result);
	}

	public static int solution(int n) {
		boolean[][] idx = new boolean[n][n];
		int depth = 0;
		dfs(depth, n, idx);
		return count;
	}

	private static void dfs(int depth, int n, boolean[][] idx) {
		if (depth == n) {
			count++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (check(depth, i, idx)) {
				idx[depth][i] = true;
				dfs(depth + 1, n, idx);
				idx[depth][i] = false;
			}
		}
	}

	private static boolean check(int x, int y, boolean[][] idx) {
		int tmpX = x, tmpY = y;

		while (true) {
			int nx = x - 1;
			if (nx < 0)
				break;
			if (idx[nx][y])
				return false;
			x = nx;
		}
		x = tmpX;

		while (true) {
			int nx = x - 1;
			int ny = y - 1;
			if (nx < 0 || ny < 0)
				break;
			if (idx[nx][ny])
				return false;

			x = nx;
			y = ny;

		}
		x = tmpX;
		y = tmpY;

		while (true) {
			int nx = x - 1;
			int ny = y + 1;
			if (nx < 0 || ny >= idx.length)
				break;
			if (idx[nx][ny])
				return false;
			x = nx;
			y = ny;

		}
		return true;
	}
}

/*
문제
N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (1 ≤ N < 15)

출력
첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
*/