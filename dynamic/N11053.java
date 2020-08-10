package dynamic;

import java.util.Scanner;

public class N11053 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		int[] seq = new int[N];
		for (int i = 0; i < N; i++) {
			seq[i] = scan.nextInt();
		}

		int[] dp = new int[N];

		dp[N - 1] = 1;
		for (int i = N - 2; i >= 0; i--) {
			int max = 0;
			for (int j = i + 1; j < N; j++) {
				if (seq[i] < seq[j]) {
					if (max < dp[j])
						max = dp[j];
				}
			}
			dp[i] = max + 1;
		}
	

		System.out.println(max(dp));
	}
	
	static int max(int ...values) {
		int max = 0;
		for(int value: values) {
			if(max<value)
				max = value;
		}
		return max;
	}
}

/*
문제
수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.

둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
*/