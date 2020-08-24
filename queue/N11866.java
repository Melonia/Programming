package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue3 que = new Queue3(N);
		
		//ť�� ������� ��ȣ�� ����
		for(int i = 1; i <= N; i++) {
			que.enque(i);
		}
		
		System.out.print("<");
		while(que.size()>1) { //������ ��ȣ�� ,�� �����Ƿ� �����ϱ� ���� ����
			for(int i = 0; i < K-1; i++) {
				que.enque(que.deque()); //K��°�� �����ϰ�� ���� ť���� ���� ���� �ٽ� �ִ´�.
			}
			System.out.print(que.deque()+", ");
		}
		System.out.print(que.deque()+">");
	}
}
class Queue3{
	
	private int max;
	private int num;
	private int[] que;
	
	Queue3(int capacity){
		max = capacity;
		num = 0;
		try {
			que = new int[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	int enque(int x) {
		if(num >= max)
			return -1;
		return que[num++] = x;
	}
	int deque() {
		if(num <= 0)
			return -1;
		int x = que[0];
		for(int i = 0; i < num-1; i++)
			que[i] = que[i+1];
		num--;
		return x;
	}
	int size() {
		return num;
	}
}
/*
����
�似Ǫ�� ������ ������ ����.

1������ N������ N���� ����� ���� �̷�鼭 �ɾ��ְ�, ���� ���� K(�� N)�� �־�����. ���� ������� K��° ����� �����Ѵ�. �� ����� ���ŵǸ� ���� ������ �̷���� ���� ���� �� ������ ����� ������. �� ������ N���� ����� ��� ���ŵ� ������ ��ӵȴ�. ������ ������� ���ŵǴ� ������ (N, K)-�似Ǫ�� �����̶�� �Ѵ�. ���� ��� (7, 3)-�似Ǫ�� ������ <3, 6, 2, 7, 5, 1, 4>�̴�.

N�� K�� �־����� (N, K)-�似Ǫ�� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� N�� K�� �� ĭ�� ���̿� �ΰ� ������� �־�����. (1 �� K �� N �� 1,000)

���
������ ���� �似Ǫ�� ������ ����Ѵ�.
*/