package math1;

import java.util.Scanner;

public class N1193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k;
		int count = 0;
		int number;

		Scanner scan = new Scanner(System.in);

		number = scan.nextInt();

		outer: for (int i = 1;; i++) {
			
			k = i;
			
			for (int j = 1; j <= i; j++) {
				count++;
				if (i % 2 == 0) {
					if (count == number) {
						System.out.println(j + "/" + k);
						break outer;
					}

				} else {
					if (count == number) {
						System.out.println(k + "/" + j);
						break outer;
					}

				}

				k--;
			}

		}

	}

}

/*
����
�̿� ���� ������ �м����� 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> �� �� ���� ������� ������ ���ʴ�� 1��, 2��, 3��, 4��, 5��, �� �м���� ����.

X�� �־����� ��, X��° �м��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� X(1 �� X �� 10,000,000)�� �־�����.

���
ù° �ٿ� �м��� ����Ѵ�.
*/