package dynamic;

import java.util.Scanner;

public class N1463 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		int[] dp = new int[N + 1];

		dp[1] = 0;

		for (int i = 2; i < N + 1; i++) {
			if (i % 3 == 0 && i % 2 == 0) {
				dp[i] = min(dp[i / 3], dp[i / 2], dp[i - 1]) + 1;
			} else if (i % 3 == 0 && i % 2 != 0) {
				dp[i] = min(dp[i / 3], dp[i - 1]) + 1;
			} else if (i % 3 != 0 && i % 2 == 0)
				dp[i] = min(dp[i / 2], dp[i - 1]) + 1;
			else {
				dp[i] = dp[i - 1] + 1;
			}
		}

		System.out.println(dp[N]);
	}

	static int min(int a, int b) {
		return a > b ? b : a;
	}

	static int min(int a, int b, int c) {
		int min;
		return min(min(a, b), c);
	}
}

/*
����
���� X�� ����� �� �ִ� ������ ������ ���� �� ���� �̴�.

X�� 3���� ������ ��������, 3���� ������.
X�� 2�� ������ ��������, 2�� ������.
1�� ����.
���� N�� �־����� ��, ���� ���� ���� �� ���� ������ ����ؼ� 1�� ������� �Ѵ�. ������ ����ϴ� Ƚ���� �ּڰ��� ����Ͻÿ�.

�Է�
ù° �ٿ� 1���� ũ�ų� ����, 106���� �۰ų� ���� ���� N�� �־�����.

���
ù° �ٿ� ������ �ϴ� Ƚ���� �ּڰ��� ����Ѵ�.
*/