package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1966 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int testCase = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < testCase; i++) {
			st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int ptr = M;
			
			String doc = bf.readLine();
			st = new StringTokenizer(doc);
			Queue4 que = new Queue4(N);
			for(int j = 0; j < N; j++) {
				que.enque(Integer.parseInt(st.nextToken()));
			}
			
			int count = 0;
			while(que.size() != 0) {
				int front = que.peek();
				boolean print = true;
				for(int j = 0; j < que.size(); j++) {
					if(front < que.indexOf(j)) {
						print = false;
						break;
					}
				}
				if(print == false) {
					que.enque(que.deque());
					if(ptr != 0) {
						ptr--;
					}
					else {
						ptr = que.size()-1;
					}
				}
				else {
					que.deque();
					count++;
					if(ptr != 0)
						ptr--;
					else {
						System.out.println(count);
						break;
					}
				}
				
			}
			
		}
	}
}
class Queue4{
	private int max;
	private int num;
	private int[] que;
	
	Queue4(int capacity){
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
		for(int i = 0;i < num-1; i++)
			que[i] = que[i+1];
		num--;
		return x;
	}
	int size() {
		return num;
	}
	int peek() {
		if(num <= 0)
			return -1;
		return que[0];
	}
	int indexOf(int x) {
		return que[x];
	}
	void dump() {
		if(num <= 0) {
			System.out.println("ť�� ��� �ֽ��ϴ�.");
			return;
		}
		for(int i = 0; i < num; i++)
			System.out.print(que[i] + " ");
		System.out.println();
	}
}
/*
����
�����е� �˴ٽ��� �������� ������ ���� �������� �μ��ϰ��� �ϴ� ������ �μ� ����� ���� ��������Ρ�, �� ���� ��û�� ���� ���� �μ��Ѵ�. ���� ���� ������ ���δٸ� Queue �ڷᱸ���� �׿��� FIFO - First In First Out - �� ���� �μⰡ �ǰ� �ȴ�. ������ ����̴� ���ο� �����ͱ� ���� ����Ʈ��� �����Ͽ��µ�, �� �����ͱ�� ������ ���� ���ǿ� ���� �μ⸦ �ϰ� �ȴ�.

���� Queue�� ���� �տ� �ִ� ������ ���߿䵵���� Ȯ���Ѵ�.
������ ������ �� ���� �������� �߿䵵�� ���� ������ �ϳ��� �ִٸ�, �� ������ �μ����� �ʰ� Queue�� ���� �ڿ� ���ġ �Ѵ�. �׷��� �ʴٸ� �ٷ� �μ⸦ �Ѵ�.
���� ��� Queue�� 4���� ����(A B C D)�� �ְ�, �߿䵵�� 2 1 4 3 ��� C�� �μ��ϰ�, �������� D�� �μ��ϰ� A, B�� �μ��ϰ� �ȴ�.

�������� �� ����, ���� Queue�� �ִ� ������ ���� �߿䵵�� �־����� ��, � �� ������ �� ��°�� �μ�Ǵ��� �˾Ƴ��� ���̴�. ���� ��� ���� ������ C������ 1��°��, A������ 3��°�� �μ�ǰ� �ȴ�.

�Է�
ù �ٿ� test case�� ���� �־�����. �� test case�� ���ؼ� ������ �� N(100����)�� �� ��°�� �μ�Ǿ����� �ñ��� ������ ���� Queue�� � ��ġ�� �ִ����� �˷��ִ� M(0�̻� N�̸�)�� �־�����. �����ٿ� N�� ������ �߿䵵�� �־����µ�, �߿䵵�� 1 �̻� 9 �����̴�. �߿䵵�� ���� ������ ���� �� ���� ���� �ִ�. ���� ���� N=4, M=0(A������ �ñ��ϴٸ�), �߿䵵�� 2 1 4 3�� �ȴ�.

���
�� test case�� ���� ������ �� ��°�� �μ�Ǵ��� ����Ѵ�.
*/