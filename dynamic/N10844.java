package dynamic;

import java.util.Scanner;

public class N10844 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();

		int[][] dp = new int[N][10];

		for (int i = 0; i < 10; i++) {
			dp[0][i] = 1;
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j + 1]%1000000000;
				} else if (j == 9) {
					dp[i][j] = dp[i - 1][j - 1]%1000000000;
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1])%1000000000;
				}
			}
		}
		
		
		long sum = 0;
		for(int i = 1; i < 10; i++) {
			sum+=dp[N-1][i];
		}
		
		System.out.println(sum%1000000000);
	}
}

/*
����
45656�̶� ���� ����.

�� ���� ������ ��� �ڸ����� ���̰� 1�� ����. �̷� ���� ��� ����� �Ѵ�.

�����̴� ���� ���̰� N�� ��� ���� �� �� �ִ��� �ñ�������.

N�� �־��� ��, ���̰� N�� ��� ���� �� �� �� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. (0���� �����ϴ� ���� ����.)

�Է�
ù° �ٿ� N�� �־�����. N�� 1���� ũ�ų� ����, 100���� �۰ų� ���� �ڿ����̴�.

���
ù° �ٿ� ������ 1,000,000,000���� ���� �������� ����Ѵ�.
*/