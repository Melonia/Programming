package dynamic;

import java.util.Scanner;

public class N1149 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[][] rgbs = new int[N][3];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++)
				rgbs[i][j] = scan.nextInt();
		}

		System.out.println(cal(N, rgbs));

	}

	static int cal(int N, int[][] rgbs) {
		int[][] array = new int[N][3];
		array[0][0] = rgbs[0][0];
		array[0][1] = rgbs[0][1];
		array[0][2] = rgbs[0][2];

		for (int i = 1; i < N; i++) {
			array[i][0] = min(array[i - 1][1], array[i - 1][2]) + rgbs[i][0];
			array[i][1] = min(array[i - 1][0], array[i - 1][2]) + rgbs[i][1];
			array[i][2] = min(array[i - 1][0], array[i - 1][1]) + rgbs[i][2];
		}

		return min(array[N - 1][0], array[N - 1][1], array[N - 1][2]);

	}

	static int min(int a, int b) {
		return a > b ? b : a;
	}

	static int min(int... values) {
		int min = 1000000;
		for (int value : values) {
			if (min > value)
				min = value;
		}
		return min;
	}

}
/*
 * static int cal(int N, int[][] rgbs) { int[] dp = new int[N]; dp[0] =
 * min(rgbs, 0); for (int i = 1; i < N; i++) { dp[i] = dp[i - 1] + min(rgbs, i);
 * } return dp[N - 1]; }
 * 
 * static int min(int[][] rgbs, int index) { int min = 1000; if (index == 0) {
 * for (int i = 0; i < 3; i++) { if (rgbs[index][i] < min) { min =
 * rgbs[index][i]; rgbs[index][3] = i; } } } else { for (int i = 0; i < 3; i++)
 * { if (rgbs[index - 1][3] != i) { if (min > rgbs[index][i]) { min =
 * rgbs[index][i]; rgbs[index][3] = i; } } } } return min; } }
 */

/*
문제
RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.

집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

1번 집의 색은 2번 집의 색과 같지 않아야 한다.
N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
입력
첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
*/