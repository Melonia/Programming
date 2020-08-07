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
					// System.out.println(max + y[i - 1] + "제거됨.");
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
문제
수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.

산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값
범위 : N개의 수들 중 최댓값과 최솟값의 차이
N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.

출력
첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.

둘째 줄에는 중앙값을 출력한다.

셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.

넷째 줄에는 범위를 출력한다.
*/