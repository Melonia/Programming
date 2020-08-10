package sort;

import java.util.Scanner;

public class N1427 {

	static void quickSort(int[] x, int left, int right) {
		int pl = left;
		int pr = right;
		int pivot = x[(pl + pr) / 2];

		do {
			while (pivot < x[pl])
				pl++;
			while (pivot > x[pr])
				pr--;
			if (pl <= pr)
				swap(x, pl++, pr--);

		} while (pl <= pr);

		if (left < pr)
			quickSort(x, left, pr);
		if (pl < right)
			quickSort(x, pl, right);
	}

	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();

		int[] x = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			x[i] = Integer.parseInt(Character.toString(s.charAt(i)));
		}
		quickSort(x, 0, s.length() - 1);
		for (int i = 0; i < s.length(); i++) {
			System.out.print(x[i]);
		}
	}
}

/*
����
�迭�� �����ϴ� ���� ����. ���� �־�����, �� ���� �� �ڸ����� ������������ �����غ���.

�Է�
ù° �ٿ� �����ϰ����ϴ� �� N�� �־�����. N�� 1,000,000,000���� �۰ų� ���� �ڿ����̴�.

���
ù° �ٿ� �ڸ����� ������������ ������ ���� ����Ѵ�.
*/