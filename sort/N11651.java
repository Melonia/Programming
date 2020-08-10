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
문제
2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

출력
첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
*/