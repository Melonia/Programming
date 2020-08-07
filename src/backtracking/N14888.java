package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class N14888 {
	static int max = -1000000000;
	static int min = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] number = new int[testCase];
		for (int i = 0; i < testCase; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int[] operation = new int[testCase - 1];
		int j = 0;
		for (int i = 0; i < 4; i++) {
			int k = j;
			int next = Integer.parseInt(st.nextToken());
			for (; j < k + next;) {
				operation[j] = i;
				j++;
			}
		}
		int depth = 0;
		boolean[] visited = new boolean[operation.length];
		int[] array = new int[operation.length];
		dfs(depth, number, operation, array, visited);
		System.out.println(max);
		System.out.print(min);
	}

	static void dfs(int depth, int[] number, int[] operation, int[] array, boolean[] visited) {
		if (depth == operation.length) {
			int result = operate(array, number);
			if (max < result) {
				max = result;
			}
			if (min > result) {
				min = result;
			}
			return;
		}
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				array[depth] = operation[i];
				dfs(depth + 1, number, operation, array, visited);
				array[depth] = 0;
				visited[i] = false;
			}
		}
	}

	static int operate(int[] array, int[] number) {
		int result = number[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0)
				result = result + number[i + 1];
			else if (array[i] == 1)
				result = result - number[i + 1];
			else if (array[i] == 2)
				result = result * number[i + 1];
			else if (array[i] == 3 && result > 0)
				result = result / number[i + 1];
			else if (array[i] == 3 && result < 0) {
				result = -result / number[i + 1];
				result = -result;
			}
		}
		return result;
	}
}

/*
����
N���� ���� �̷���� ���� A1, A2, ..., AN�� �־�����. ��, ���� �� ���̿� �������� �� �ִ� N-1���� �����ڰ� �־�����. �����ڴ� ����(+), ����(-), ����(��), ������(��)���θ� �̷���� �ִ�.

�츮�� ���� �� ���̿� �����ڸ� �ϳ��� �־, ������ �ϳ� ���� �� �ִ�. �̶�, �־��� ���� ������ �ٲٸ� �� �ȴ�.

���� ���, 6���� ���� �̷���� ������ 1, 2, 3, 4, 5, 6�̰�, �־��� �����ڰ� ����(+) 2��, ����(-) 1��, ����(��) 1��, ������(��) 1���� ��쿡�� �� 60������ ���� ���� �� �ִ�. ���� ���, �Ʒ��� ���� ���� ���� �� �ִ�.

1+2+3-4��5��6
1��2+3+4-5��6
1+2��3��4-5+6
1��2��3-4+5+6
���� ����� ������ �켱 ������ �����ϰ� �տ������� �����ؾ� �Ѵ�. ��, �������� ���� ���������� �� ���Ѵ�. ������ ����� ���� ���� C++14�� ������ ������. ��, ����� �ٲ� �� ���� ���ϰ�, �� ���� ������ �ٲ� �Ͱ� ����. �̿� ����, ���� �� 4���� ����� ����غ��� �Ʒ��� ����.

1+2+3-4��5��6 = 1
1��2+3+4-5��6 = 12
1+2��3��4-5+6 = 5
1��2��3-4+5+6 = 7
N���� ���� N-1���� �����ڰ� �־����� ��, ���� �� �ִ� ���� ����� �ִ��� �Ͱ� �ּ��� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� ���� N(2 �� N �� 11)�� �־�����. ��° �ٿ��� A1, A2, ..., AN�� �־�����. (1 �� Ai �� 100) ��° �ٿ��� ���� N-1�� 4���� ������ �־����µ�, ���ʴ�� ����(+)�� ����, ����(-)�� ����, ����(��)�� ����, ������(��)�� �����̴�. 

���
ù° �ٿ� ���� �� �ִ� ���� ����� �ִ���, ��° �ٿ��� �ּڰ��� ����Ѵ�. �����ڸ� ��� �����־ �׻� -10�ﺸ�� ũ�ų� ����, 10�ﺸ�� �۰ų� ���� ����� ������ �Է¸� �־�����. ����, �տ������� ������� ��, �߰��� ���Ǵ� ���� ����� �׻� -10�ﺸ�� ũ�ų� ����, 10�ﺸ�� �۰ų� ����.
*/