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
문제
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

입력
첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.

출력
첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
*/