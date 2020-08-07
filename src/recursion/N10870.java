package recursion;

import java.util.Scanner;

public class N10870 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		fibo = new int[n + 1];
		System.out.println(fibonacci(n));
	}

	static int[] fibo;

	static int fibonacci(int n) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (fibo[n] != 0)
			return fibo[n];
		fibo[n] = fibonacci(n - 1) + fibonacci(n - 2);
		return fibo[n];

	}
}
/*
����
�Ǻ���ġ ���� 0�� 1�� �����Ѵ�. 0��° �Ǻ���ġ ���� 0�̰�, 1��° �Ǻ���ġ ���� 1�̴�. �� ���� 2��° ���ʹ� �ٷ� �� �� �Ǻ���ġ ���� ���� �ȴ�.

�̸� ������ �Ẹ�� Fn = Fn-1 + Fn-2 (n>=2)�� �ȴ�.

n=17�϶� ���� �Ǻ���ġ ���� �Ẹ�� ������ ����.

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597

n�� �־����� ��, n��° �Ǻ���ġ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� n�� �־�����. n�� 20���� �۰ų� ���� �ڿ��� �Ǵ� 0�̴�.

���
ù° �ٿ� n��° �Ǻ���ġ ���� ����Ѵ�.
*/