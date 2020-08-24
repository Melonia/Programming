package queue;

import java.util.Scanner;

public class N2164 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		Queue2 que = new Queue2(N);
		for(int i = 1; i <= N; i++) {
			que.enque(i);
		}
		while(que.size() != 1) {
			que.deque();
			que.enque(que.deque());
		}
		System.out.println(que.peek());
	}
}
class Queue2{
	private int max;
	private int num;
	private int front;
	private int rear;
	private int[] que;
	
	Queue2(int capacity){
		max = capacity;
		num = front = rear = 0;
		try {
			que = new int[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	int enque(int x) {
		if(num >= max)
			return -1;
		que[rear++] = x;
		num ++;
		if(rear == max)
			rear = 0;
		return x;
	}
	int deque() {
		if(num <= 0)
			return -1;
		int x = que[front++];
		num --;
		if(front == max)
			front = 0;
		return x;
	}
	int size() {
		return num;
	}
	int peek() {
		if(num <= 0)
			return -1;
		return que[front];
	}
}
/*
����
N���� ī�尡 �ִ�. ������ ī��� ���ʷ� 1���� N������ ��ȣ�� �پ� ������, 1�� ī�尡 ���� ����, N�� ī�尡 ���� �Ʒ��� ���·� ������� ī�尡 ���� �ִ�.

���� ������ ���� ������ ī�尡 �� �� ���� ������ �ݺ��ϰ� �ȴ�. �켱, ���� ���� �ִ� ī�带 �ٴڿ� ������. �� ����, ���� ���� �ִ� ī�带 ���� �Ʒ��� �ִ� ī�� ������ �ű��.

���� ��� N=4�� ��츦 ������ ����. ī��� ���� ���������� 1234 �� ������ �����ִ�. 1�� ������ 234�� ���´�. ���⼭ 2�� ���� �Ʒ��� �ű�� 342�� �ȴ�. 3�� ������ 42�� �ǰ�, 4�� ������ �ű�� 24�� �ȴ�. ���������� 2�� ������ ����, ���� ī��� 4�� �ȴ�.

N�� �־����� ��, ���� �������� ���� �Ǵ� ī�带 ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� N(1��N��500,000)�� �־�����.

���
ù° �ٿ� ���� �Ǵ� ī���� ��ȣ�� ����Ѵ�.
*/