package math2;

import java.util.ArrayList;
import java.util.Scanner;

public class N2581 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> array = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		int start = scan.nextInt();
		int end = scan.nextInt();
		for (int i = start; i < end + 1; i++) {
			array.add(i);
		}

		for (int i = 0; i < end + 1; i++) {
			for (int j = 0; j < array.size(); j++) {
				if (array.get(j) % (i + 2) == 0 && array.get(j) != (i + 2) || array.get(j) == 1)
					array.remove(j);

			}
		}
		if(array.size() == 0) {
			System.out.println(-1);
			return;
		}
		int sum = 0;
		for(int i = 0 ; i < array.size(); i++)
			sum += array.get(i);
		System.out.println(sum);
		int min = end;
		for(int i = 0; i <array.size();i++) {
			if(min > array.get(i))
				min = array.get(i);
		}
		System.out.println(min);

	}

}

/*
����
�ڿ��� M�� N�� �־��� �� M�̻� N������ �ڿ��� �� �Ҽ��� ���� ��� ��� �̵� �Ҽ��� �հ� �ּڰ��� ã�� ���α׷��� �ۼ��Ͻÿ�.

���� ��� M=60, N=100�� ��� 60�̻� 100������ �ڿ��� �� �Ҽ��� 61, 67, 71, 73, 79, 83, 89, 97 �� 8���� �����Ƿ�, �̵� �Ҽ��� ���� 620�̰�, �ּڰ��� 61�� �ȴ�.

�Է�
�Է��� ù° �ٿ� M��, ��° �ٿ� N�� �־�����.

M�� N�� 10,000������ �ڿ����̸�, M�� N���� �۰ų� ����.

���
M�̻� N������ �ڿ��� �� �Ҽ��� ���� ��� ã�� ù° �ٿ� �� ����, ��° �ٿ� �� �� �ּڰ��� ����Ѵ�. 

��, M�̻� N������ �ڿ��� �� �Ҽ��� ���� ���� ù° �ٿ� -1�� ����Ѵ�.
*/