package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N10814 {

	static String[] buff;

	static void mergeSort(String[] x, int left, int right) {
		if (left < right) {
			int i;
			int center = (left + right) / 2;
			int p = 0;
			int j = 0;
			int k = left;

			mergeSort(x, left, center);
			mergeSort(x, center + 1, right);
			for (i = left; i <= center; i++)
				buff[p++] = x[i];
			while (i <= right && j < p)
				x[k++] = (Integer.parseInt(buff[j].split(" ")[0]) <= Integer.parseInt(x[i].split(" ")[0])) ? buff[j++]
						: x[i++];
			while (j < p)
				x[k++] = buff[j++];

		}
	}

	static void mergesort(String[] x, int n) {
		buff = new String[n];
		mergeSort(x, 0, n - 1);
		buff = null;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(bf.readLine());
		String[] info = new String[testCase];
		for (int i = 0; i < testCase; i++) {
			info[i] = bf.readLine();
		}

		mergesort(info, testCase);
		for (int i = 0; i < testCase; i++) {
			bw.write(info[i] + "\n");
		}
		bw.flush();
	}
}

/*
문제
온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다. 이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)

둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다. 나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고, 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다. 입력은 가입한 순서로 주어진다.

출력
첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.
*/