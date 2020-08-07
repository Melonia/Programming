package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N15651 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

	
		int[] array = new int[M];
		int depth = 0;
		permutation(depth, N, M, array);

	}

	static void permutation(int depth, int N, int M, int[] array) throws IOException {
		if (depth == array.length) {
			print(array);
			return;
		}
		for (int i = 0; i < N; i++) {

			array[depth] = i + 1;
			permutation(depth + 1, N, M, array);
			array[depth] = 0;

		}
	}

	static void print(int[] array) throws IOException {
		
		for (int i : array) {
			bw.write(i+" ");
		}
		bw.write("\n");
		bw.flush();
	}
}

/*
����
�ڿ��� N�� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

1���� N���� �ڿ��� �߿��� M���� ���� ����
���� ���� ���� �� ��� �ȴ�.
�Է�
ù° �ٿ� �ڿ��� N�� M�� �־�����. (1 �� M �� N �� 7)

���
�� �ٿ� �ϳ��� ������ ������ �����ϴ� ������ ����Ѵ�. �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�, �� ������ �������� �����ؼ� ����ؾ� �Ѵ�.

������ ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.
*/