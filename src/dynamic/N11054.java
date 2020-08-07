package dynamic;

import java.util.Scanner;

public class N11054 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		int[] seq = new int[N];
		for (int i = 0; i < N; i++) {
			seq[i] = scan.nextInt();
		}

	
		int[] result = new int[N];
		if(N==1) {
			System.out.println(1);
			return;
		}
		for (int i = 0; i < N; i++) {
			int[] dp = new int[N];
			dp[i] = 1;
		
			for (int j = i-1; j >= 0; j--) {
				int max = 0;
				for (int k = j+1; k <= i; k++) {

					if (seq[j] < seq[k]) {
						if (max < dp[k]) {
							max = dp[k];
						}
					}

				}
				dp[j] = max + 1;
			}

			for (int j = i+1; j < N; j++) {
				int max = 0;
				for (int k = j-1; k >= i; k--) {
					if (seq[j] < seq[k]) {
						if (max < dp[k]) {
							max = dp[k];
						}
					}
				}
				dp[j] = max + 1;
			}
		
			result[i] = max(i, dp) - 1;
		}
		
		System.out.println(max(result));
	}

	static int max(int... values) {
		int max = 0;
		for (int value : values) {
			if (max < value)
				max = value;
		}
		return max;
	}

	static int max(int index, int[] dp) {
		int max1 = 0;
		int max2 = 0;
		for (int i = 0; i < index; i++) {
			if (max1 < dp[i])
				max1 = dp[i];
		}
		for (int i = index + 1; i < dp.length; i++) {
			if (max2 < dp[i])
				max2 = dp[i];
		}
		return max1 + max2;
	}
}
/*
����
���� S�� � �� Sk�� �������� S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN�� �����Ѵٸ�, �� ������ ������� �����̶�� �Ѵ�.

���� ���, {10, 20, 30, 25, 20}�� {10, 20, 30, 40}, {50, 40, 25, 10} �� ������� ����������,  {1, 2, 3, 2, 1, 2, 3, 2, 1}�� {10, 20, 30, 40, 20, 30} �� ������� ������ �ƴϴ�.

���� A�� �־����� ��, �� ������ �κ� ���� �� ������� �����̸鼭 ���� �� ������ ���̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� A�� ũ�� N�� �־�����, ��° �ٿ��� ���� A�� �̷�� �ִ� Ai�� �־�����. (1 �� N �� 1,000, 1 �� Ai �� 1,000)

���
ù° �ٿ� ���� A�� �κ� ���� �߿��� ���� �� ������� ������ ���̸� ����Ѵ�.
*/