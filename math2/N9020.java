package math2;

import java.util.Scanner;

public class N9020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int testCase = scan.nextInt();

		for (int i = 0; i < testCase; i++) {
			int number = scan.nextInt();
			boolean[] A = new boolean[number + 1];
			for (int j = 2; j < number / 2; j++) {
				if (A[j] == false) {
					for (int k = 2; k * j <= number; k++) {
						A[j * k] = true;
					}
				}

			}
			A[1] = true;
			int x;
			for (int k = number / 2; k > 0; k--) {
				if (A[k] == false && A[number - k] == false) {
					System.out.println(k + " " + (number - k));
					break;
				}
			}
		}
	}

}

/*
����
1���� ū �ڿ��� �߿���  1�� �ڱ� �ڽ��� ������ ����� ���� �ڿ����� �Ҽ���� �Ѵ�. ���� ���, 5�� 1�� 5�� ������ ����� ���� ������ �Ҽ��̴�. ������, 6�� 6 = 2 �� 3 �̱� ������ �Ҽ��� �ƴϴ�.

�������� ������ ������ �������� ���ذ� ������, 2���� ū ��� ¦���� �� �Ҽ��� ������ ��Ÿ�� �� �ִٴ� ���̴�. �̷��� ���� ������ ����� �Ѵ�. ��, ¦���� �� �Ҽ��� ������ ��Ÿ���� ǥ���� �� ���� ������ ��Ƽ���̶�� �Ѵ�. ���� ���, 4 = 2 + 2, 6 = 3 + 3, 8 = 3 + 5, 10 = 5 + 5, 12 = 5 + 7, 14 = 3 + 11, 14 = 7 + 7�̴�. 10000���� �۰ų� ���� ��� ¦�� n�� ���� ������ ��Ƽ���� �����Ѵ�.

2���� ū ¦�� n�� �־����� ��, n�� ������ ��Ƽ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. ���� ������ n�� ������ ��Ƽ���� ���� ������ ��쿡�� �� �Ҽ��� ���̰� ���� ���� ���� ����Ѵ�.

�Է�
ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ְ� ¦�� n�� �־�����. (4 �� n �� 10,000)

���
�� �׽�Ʈ ���̽��� ���ؼ� �־��� n�� ������ ��Ƽ���� ����Ѵ�. ����ϴ� �Ҽ��� ���� �ͺ��� ���� ����ϸ�, �������� �����Ѵ�.
*/