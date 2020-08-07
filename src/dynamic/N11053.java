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
����
���� A�� �־����� ��, ���� �� �����ϴ� �κ� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

���� ���, ���� A = {10, 20, 10, 30, 20, 50} �� ��쿡 ���� �� �����ϴ� �κ� ������ A = {10, 20, 10, 30, 20, 50} �̰�, ���̴� 4�̴�.

�Է�
ù° �ٿ� ���� A�� ũ�� N (1 �� N �� 1,000)�� �־�����.

��° �ٿ��� ���� A�� �̷�� �ִ� Ai�� �־�����. (1 �� Ai �� 1,000)

���
ù° �ٿ� ���� A�� ���� �� �����ϴ� �κ� ������ ���̸� ����Ѵ�.
*/