package math2;

import java.util.Scanner;

public class N4948 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int test = scanner.nextInt();

			if (test == 0)
				break;

			int end = 2 * test;
			boolean[] A = new boolean[end + 1];
			for (int i = 2; i < A.length; i++) {
				if (!A[i]) {
					for (int j = 2; i * j <= end; j++) {
						A[i * j] = true;
					}
				}
			}
			int count = 0;
			for(int i = test + 1; i <= end; i++)
				if(!A[i]) count++;
			System.out.println(count);
		}
	}

}

/*
����
����Ʈ�� ������ ������ �ڿ��� n�� ���Ͽ�, n���� ũ��, 2n���� �۰ų� ���� �Ҽ��� ��� �ϳ� �����Ѵٴ� ������ ��� �ִ�.

�� ������ ������ ����Ʈ���� 1845�⿡ �����߰�, ������Ƽ ü������� 1850�⿡ �����ߴ�.

���� ���, 10���� ũ��, 20���� �۰ų� ���� �Ҽ��� 4���� �ִ�. (11, 13, 17, 19) ��, 14���� ũ��, 28���� �۰ų� ���� �Ҽ��� 3���� �ִ�. (17,19, 23)

n�� �־����� ��, n���� ũ��, 2n���� �۰ų� ���� �Ҽ��� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�. 

�Է�
�Է��� ���� ���� �׽�Ʈ ���̽��� �̷���� �ִ�. �� ���̽��� n�� �����ϸ�, �� �ٷ� �̷���� �ִ�. (n �� 123456)

�Է��� ���������� 0�� �־�����.

���
�� �׽�Ʈ ���̽��� ���ؼ�, n���� ũ��, 2n���� �۰ų� ���� �Ҽ��� ������ ����Ѵ�.
*/