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
����
�¶��� ������ ������ ������� ���̿� �̸��� ������ ������� �־�����. �̶�, ȸ������ ���̰� �����ϴ� ������, ���̰� ������ ���� ������ ����� �տ� ���� ������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �¶��� ���� ȸ���� �� N�� �־�����. (1 �� N �� 100,000)

��° �ٺ��� N���� �ٿ��� �� ȸ���� ���̿� �̸��� �������� ���еǾ� �־�����. ���̴� 1���� ũ�ų� ������, 200���� �۰ų� ���� �����̰�, �̸��� ���ĺ� ��ҹ��ڷ� �̷���� �ְ�, ���̰� 100���� �۰ų� ���� ���ڿ��̴�. �Է��� ������ ������ �־�����.

���
ù° �ٺ��� �� N���� �ٿ� ���� �¶��� ���� ȸ���� ���� ��, ���̰� ������ ������ ������ �� �ٿ� �� �� ���̿� �̸��� �������� ������ ����Ѵ�.
*/