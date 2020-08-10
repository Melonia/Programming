package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N11651 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(bf.readLine());
		int[] x = new int[testCase];
		int[] y = new int[testCase];

		for (int i = 0; i < testCase; i++) {
			try {
				String s = bf.readLine();
				String[] s2 = s.split(" ");
				x[i] = Integer.parseInt(s2[0]);
				y[i] = Integer.parseInt(s2[1]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		quickSort(x, y, 0, testCase - 1);

		int k;

		int count = 1;
		int cmp = 100001;
		int[] z = new int[x.length + 1];
		z[x.length] = 100001;
		for (int i = 0; i < x.length; i++)
			z[i] = y[i];

		for (k = 0; k < testCase + 1; k++) {
			if (z[k] != cmp) {
				for (int i = count; i > 0; i--) {
					for (int j = k - count + 1; j < k; j++) {
						if (x[j] < x[j - 1]) {
							swap(z, j - 1, j);
							swap(x, j - 1, j);
						}
					}
				}
				cmp = z[k];
				count = 1;
			} else {
				count++;
			}
		}
		for (int i = 0; i < x.length; i++) {
			y[i] = z[i];
		}
		for (int i = 0; i < testCase; i++) {
			bw.write(x[i] + " " + y[i] + "\n");

		}
		bw.flush();
	}

	static void quickSort(int[] x, int[] y, int left, int right) {
		int pl = left;
		int pr = right;
		int pivot = y[(pl + pr) / 2];

		do {
			while (pivot > y[pl])
				pl++;
			while (pivot < y[pr])
				pr--;
			if (pl <= pr) {
				swap(x, pl, pr);
				swap(y, pl++, pr--);
			}
		} while (pl <= pr);

		if (left < pr)
			quickSort(x, y, left, pr);
		if (pl < right)
			quickSort(x, y, pl, right);
	}

	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
}

/*
����
2���� ��� ���� �� N���� �־�����. ��ǥ�� y��ǥ�� �����ϴ� ������, y��ǥ�� ������ x��ǥ�� �����ϴ� ������ ������ ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� ���� N (1 �� N �� 100,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� i������ ��ġ xi�� yi�� �־�����. (-100,000 �� xi, yi �� 100,000) ��ǥ�� �׻� �����̰�, ��ġ�� ���� �� ���� ����.

���
ù° �ٺ��� N���� �ٿ� ���� ������ ����� ����Ѵ�.
*/