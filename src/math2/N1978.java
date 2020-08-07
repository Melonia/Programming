package math2;

import java.util.ArrayList;
import java.util.Scanner;

public class N1978 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> array = new ArrayList<Integer>();

		for (int i = 1; i <= 1000; i++)
			array.add(i);

		array.remove(0);
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < array.size(); j++)
				if (array.get(j) % (2 + i) == 0 && array.get(j) != (2 + i))
					array.remove(j);
		}

		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.nextInt();
		int[] number = new int[testCase];
		for (int i = 0; i < testCase; i++) {
			number[i] = scanner.nextInt();
		}
		int count = 0;
		for (int i = 0; i < testCase; i++) {
			for (int j = 0; j < array.size(); j++) {
				if (number[i] == array.get(j))
					count++;
			}
		}
		System.out.println(count);

	}

}

/*
����
�־��� �� N�� �߿��� �Ҽ��� �� ������ ã�Ƽ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù �ٿ� ���� ���� N�� �־�����. N�� 100�����̴�. �������� N���� ���� �־����µ� ���� 1,000 ������ �ڿ����̴�.

���
�־��� ���� �� �Ҽ��� ������ ����Ѵ�.
*/