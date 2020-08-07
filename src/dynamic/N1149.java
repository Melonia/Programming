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
����
RGB�Ÿ����� ���� N�� �ִ�. �Ÿ��� �������� ��Ÿ�� �� �ְ�, 1�� ������ N�� ���� ������� �ִ�.

���� ����, �ʷ�, �Ķ� �� �ϳ��� ������ ĥ�ؾ� �Ѵ�. ������ ���� ����, �ʷ�, �Ķ����� ĥ�ϴ� ����� �־����� ��, �Ʒ� ��Ģ�� �����ϸ鼭 ��� ���� ĥ�ϴ� ����� �ּڰ��� ���غ���.

1�� ���� ���� 2�� ���� ���� ���� �ʾƾ� �Ѵ�.
N�� ���� ���� N-1�� ���� ���� ���� �ʾƾ� �Ѵ�.
i(2 �� i �� N-1)�� ���� ���� i-1��, i+1�� ���� ���� ���� �ʾƾ� �Ѵ�.
�Է�
ù° �ٿ� ���� �� N(2 �� N �� 1,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� �� ���� ����, �ʷ�, �Ķ����� ĥ�ϴ� ����� 1�� ������ �� �ٿ� �ϳ��� �־�����. ���� ĥ�ϴ� ����� 1,000���� �۰ų� ���� �ڿ����̴�.

���
ù° �ٿ� ��� ���� ĥ�ϴ� ����� �ּڰ��� ����Ѵ�.
*/