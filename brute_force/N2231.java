package brute_force;

import java.util.Scanner;

public class N2231 {

	static int exp(int x, int n) {
		int sum = 1;
		for (int i = 0; i < n; i++)
			sum *= x;
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int number = scan.nextInt();

		int count = 0;
		for (int i = 0; i < 6; i++) {

			if (number / exp(10, i) > 0)
				count++;
			else
				break;
		}

		for (int i = number - (count * 10); i < number; i++) {

			int sum = 0;
			int j = i;

			while (true) {
				sum += j % 10;
				j /= 10;
				if (j <= 0) {
					break;
				}
			}

			if (number == sum + i) {
				System.out.println(i);
				return;
			}

		}
		System.out.println(0);
	}

}

/*
����
� �ڿ��� N�� ���� ��, �� �ڿ��� N�� �������� N�� N�� �̷�� �� �ڸ����� ���� �ǹ��Ѵ�. � �ڿ��� M�� �������� N�� ���, M�� N�� �����ڶ� �Ѵ�. ���� ���, 245�� �������� 256(=245+2+4+5)�� �ȴ�. ���� 245�� 256�� �����ڰ� �ȴ�. ����, � �ڿ����� ��쿡�� �����ڰ� ���� ���� �ִ�. �ݴ��, �����ڰ� ���� ���� �ڿ����� ���� �� �ִ�.

�ڿ��� N�� �־����� ��, N�� ���� ���� �����ڸ� ���س��� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �ڿ��� N(1 �� N �� 1,000,000)�� �־�����.

���
ù° �ٿ� ���� ����Ѵ�. �����ڰ� ���� ��쿡�� 0�� ����Ѵ�.
*/