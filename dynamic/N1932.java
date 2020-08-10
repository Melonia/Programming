package dynamic;

import java.util.Scanner;

public class N1932 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[][] triangle = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i + 1; j++)
				triangle[i][j] = scan.nextInt();
		}

		System.out.println(cal(N, triangle));

	}

	static int cal(int N, int[][] triangle) {
		int[][] array = new int[N][N];

		for (int i = 0; i < N; i++) {
			array[N - 1][i] = triangle[N - 1][i];
		}

		for (int i = N - 1; i > 0; i--)
			for (int j = 0; j < i; j++)
				array[i - 1][j] = max(array[i][j], array[i][j + 1]) + triangle[i - 1][j];

		return array[0][0];

	}

	static int max(int a, int b) {
		return a > b ? a : b;
	}
}

/*
����
7
3   8
8   1   0
2   7   4   4
4   5   2   6   5
�� �׸��� ũ�Ⱑ 5�� ���� �ﰢ���� �� ����̴�.

�� ���� 7���� �����ؼ� �Ʒ��� �ִ� �� �� �ϳ��� �����Ͽ� �Ʒ������� ������ ��, �������� ���õ� ���� ���� �ִ밡 �Ǵ� ��θ� ���ϴ� ���α׷��� �ۼ��϶�. �Ʒ����� �ִ� ���� ���� ������ ���õ� ���� �밢�� ���� �Ǵ� �밢�� �����ʿ� �ִ� �� �߿����� ������ �� �ִ�.

�ﰢ���� ũ��� 1 �̻� 500 �����̴�. �ﰢ���� �̷�� �ִ� �� ���� ��� �����̸�, ������ 0 �̻� 9999 �����̴�.

�Է�
ù° �ٿ� �ﰢ���� ũ�� n(1 �� n �� 500)�� �־�����, ��° �ٺ��� n+1��° �ٱ��� ���� �ﰢ���� �־�����.

���
ù° �ٿ� ���� �ִ밡 �Ǵ� ��ο� �ִ� ���� ���� ����Ѵ�.
*/