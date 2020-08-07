package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		for(int i = N-1; i >= 0; i--)
			A[i] = Integer.parseInt(bf.readLine());
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			count += K/A[i];
			K %= A[i];
			if(K==0)
				break;
		}
		System.out.println(count);
	}
}
/*
BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

String s = bf.readLine();
StringTokenizer st = new StringTokenizer(s);
int N = Integer.parseInt(st.nextToken());
int K = Integer.parseInt(st.nextToken());

int[] array = new int[N];
for(int i = 0; i < N; i++) {
	array[i] = Integer.parseInt(bf.readLine());
}

int sum = 0;
int count = 0;
for(int i = N-1; i >= 0; i--) {
	if(K-sum>=array[i]) {
		count += (K-sum)/array[i];
		sum += ((K-sum)/array[i])*array[i];
	}
	if(sum>=K) break;
}
System.out.println(count);
}
*/
/*
����
�ر԰� ������ �ִ� ������ �� N�����̰�, ������ ������ �ſ� ���� ������ �ִ�.

������ ������ ����ؼ� �� ��ġ�� ���� K�� ������� �Ѵ�. �̶� �ʿ��� ���� ������ �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� N�� K�� �־�����. (1 �� N �� 10, 1 �� K �� 100,000,000)

��° �ٺ��� N���� �ٿ� ������ ��ġ Ai�� ������������ �־�����. (1 �� Ai �� 1,000,000, A1 = 1, i �� 2�� ��쿡 Ai�� Ai-1�� ���)

���
ù° �ٿ� K���� ����µ� �ʿ��� ���� ������ �ּڰ��� ����Ѵ�.
*/