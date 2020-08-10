package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class N2108 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(bf.readLine());
		int[] x = new int[num];
		for (int i = 0; i < num; i++)
			try {
				x[i] = Integer.parseInt(bf.readLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		quickSort(x, 0, num - 1);

		int mode = mode(x, num);
		System.out.println(van(avg(x)));
		System.out.println(x[num / 2]);
		System.out.println(mode);
		System.out.println(abs(max(x) - min(x)));

	}

	static int abs(int x) {
		if (x > 0)
			return x;
		else
			return -x;
	}

	static void quickSort(int[] x, int left, int right) {
		int pl = left;
		int pr = right;
		int pivot = x[(pl + pr) / 2];

		do {
			while (pivot > x[pl])
				pl++;
			while (pivot < x[pr])
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

	static double avg(int... values) {
		int sum = 0;
		for (int value : values) {
			sum += value;
		}
		return (double) sum / values.length;
	}

	static double abs(double x) {
		if (x > 0.0)
			return x;
		else
			return -x;
	}

	static int van(double x) {
		double y = abs(x);
		if (y % 1 >= 0.5)
			y++;

		if (x > 0.0) {
			return (int) (y - (y % 1));
		} else {
			return (int) (-y + (y % 1));
		}

	}

	static int min(int... values) {
		int min = 4000;
		for (int value : values) {
			if (min > value)
				min = value;
		}
		return min;
	}

	static int max(int... values) {
		int max = -4001;
		for (int value : values) {
			if (max < value)
				max = value;
		}
		return max;
	}

	static int mode(int[] x, int num) {
		ArrayList<Integer> array = new ArrayList<>();

		int count = 1;
		int max = 1;
		int[] y = new int[x.length + 1];
		y[x.length] = 4001;

		for (int i = 0; i < x.length; i++) {
			y[i] = x[i];
		}
		int cmp = y[0];
		for (int i = 1; i < num + 1; i++) {
			if (cmp != y[i]) {
				if (max < count) {
					max = count;
					array.clear();
					// System.out.println(max + y[i - 1] + "���ŵ�.");
					array.add(cmp);
				} else if (max == count) {
					array.add(cmp);
				}
				cmp = y[i];
				count = 1;

			} else {
				count++;
			}
		}

		if (array.isEmpty()) {
			return x[0];
		} else if (array.size() > 1) {
			return array.get(1);
		} else {
			return array.get(0);
		}
	}

}

/*
����
���� ó���ϴ� ���� ����п��� ����� �߿��� ���̴�. ����п��� N���� ���� ��ǥ�ϴ� �⺻ ��谪���� ������ ���� �͵��� �ִ�. ��, N�� Ȧ����� ��������.

������ : N���� ������ ���� N���� ���� ��
�߾Ӱ� : N���� ������ �����ϴ� ������ �������� ��� �� �߾ӿ� ��ġ�ϴ� ��
�ֺ� : N���� ���� �� ���� ���� ��Ÿ���� ��
���� : N���� ���� �� �ִ񰪰� �ּڰ��� ����
N���� ���� �־����� ��, �� ���� �⺻ ��谪�� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� ���� N(1 �� N �� 500,000)�� �־�����. �� ���� N���� �ٿ��� �������� �־�����. �ԷµǴ� ������ ������ 4,000�� ���� �ʴ´�.

���
ù° �ٿ��� �������� ����Ѵ�. �Ҽ��� ���� ù° �ڸ����� �ݿø��� ���� ����Ѵ�.

��° �ٿ��� �߾Ӱ��� ����Ѵ�.

��° �ٿ��� �ֺ��� ����Ѵ�. ���� �� ���� ������ �ֺ� �� �� ��°�� ���� ���� ����Ѵ�.

��° �ٿ��� ������ ����Ѵ�.
*/