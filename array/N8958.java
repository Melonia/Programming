package array;

import java.util.Scanner;

public class N8958{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum;
		int count;
		String[] array = TestCase1.initialize_string();

		for (int i = 0; i < array.length; i++) {
			sum = 0;
			count = 0;
			for (int j = 0; j < array[i].length(); j++) {
				if (array[i].charAt(j) == 'O') {
					count++;
					sum += count;
				}

				else {
					count = 0;
				}

			}

			System.out.println(sum);
		}
	}

}

class TestCase1 {

	static int[] array_int;
	static String[] array_string;
	
	static int[] initialize_int() {

		Scanner scan = new Scanner(System.in);

		int testCase = scan.nextInt();

		array_int = new int[testCase];

		for (int i = 0; i < testCase; i++) {
			array_int[i] = scan.nextInt();
		}

		return array_int;

	}

	static String[] initialize_string() {
		Scanner scan = new Scanner(System.in);

		int testCase = scan.nextInt();

		array_string = new String[testCase];
		
		if(scan.hasNextLine()) {
			scan.nextLine();
		}
		
		for (int i = 0; i < testCase; i++) {
			array_string[i] = scan.nextLine();
		}

		return array_string;
	}

}

/*
����
"OOXXOXXOOO"�� ���� OX������ ����� �ִ�. O�� ������ ���� ���̰�, X�� ������ Ʋ�� ���̴�. ������ ���� ��� �� ������ ������ �� �������� ���ӵ� O�� ������ �ȴ�. ���� ���, 10�� ������ ������ 3�� �ȴ�.

"OOXXOXXOOO"�� ������ 1+2+0+0+1+0+0+1+2+3 = 10���̴�.

OX������ ����� �־����� ��, ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �׽�Ʈ ���̽��� ������ �־�����. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ְ�, ���̰� 0���� ũ�� 80���� ���� ���ڿ��� �־�����. ���ڿ��� O�� X������ �̷���� �ִ�.

���
�� �׽�Ʈ ���̽����� ������ ����Ѵ�.
*/