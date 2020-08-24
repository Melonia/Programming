package queue;

import java.util.Scanner;

public class N1021 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		IntDeque1 deck = new IntDeque1(N);
		for(int i = 1; i <= N; i++) {
			deck.enqueRear(i);
		}
		
		Processor2 proc = new Processor2(deck);
		int count = 0;
		for(int i = 0; i < M; i++) {
			proc.input(scan.nextInt());
			proc.judge();
			count += proc.getCount();
			
		}
		System.out.println(count);
	}
}

class Jimin{
	IntDeque1 deck;
	Jimin(IntDeque1 deck){
		this.deck = deck;
	}
	void extract() {
		deck.dequeFront();
	}
	void left() {
		deck.enqueRear(deck.dequeFront());
	}
	void right() {
		deck.enqueFront(deck.dequeRear());
	}
}

class Processor2{
	Jimin jimin;
	IntDeque1 deck;
	int data;
	int count;
	
	Processor2(IntDeque1 deck){
		this.deck = deck;
		jimin = new Jimin(this.deck);
	}
	
	void input(int data) {
		this.data = data;
	}
	
	void judge() {
		this.count = 0;
		
		if(abs(deck.frontIdx() - deck.indexOf(data))<Math.ceil((double)deck.size()/2)) {
			while(true) {
				if(deck.peekFront() == data) {
					jimin.extract();
					break;
				}
				jimin.left();
				count++;
			}
		}
		else {
			while(true) {
				if(deck.peekFront() == data) {
					jimin.extract();
					break;
				}
				jimin.right();
				count++;
			}
		}
	}
	int getCount() {
		return count;
	}
	
	int abs(int x) {
		if(x > 0)
			return x;
		else
			return -x;
	}
}

class IntDeque1{
	private int max;
	private int num;
	private int front;
	private int rear;
	private int[] que;
	
	public class EmptyIntDequeException extends RuntimeException{
		public EmptyIntDequeException() {}
	}
	
	public class OverflowIntDequeException extends RuntimeException{
		public OverflowIntDequeException() {}
	}
	
	public IntDeque1(int capacity){
		num = front = rear = 0;
		max = capacity;
		try {
			que = new int[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public int frontIdx() {
		return front;
	}
	
	public int enqueFront(int x) throws OverflowIntDequeException{
		if(num >= max)
			throw new OverflowIntDequeException();
		num++;
		if(--front < 0)
			front = max - 1;
		que[front] = x;
		return x;
	}
	public int enqueRear(int x) throws OverflowIntDequeException{
		if(num >= max)
			throw new OverflowIntDequeException();
		que[rear++] = x;
		num++;
		if( rear == max)
			rear = 0;
		return x;
	}
	public int dequeFront() throws EmptyIntDequeException{
		if(num <= 0)
			throw new EmptyIntDequeException();
		int x = que[front++];
		num--;
		if(front == max)
			front = 0;
		return x;
	}
	public int dequeRear() throws EmptyIntDequeException{
		if(num <= 0)
			throw new EmptyIntDequeException();
		num--;
		if(--rear < 0) 
			rear = max - 1;
		return que[rear];
	}
	
	public int peekFront() throws EmptyIntDequeException{
		if(num <= 0)
			throw new EmptyIntDequeException();
		return que[front];
	}
	public int peekRear() throws EmptyIntDequeException{
		if(num <= 0)
			throw new EmptyIntDequeException();
		return que[rear == 0 ? max-1 : rear-1];
	}
	
	public int indexOf(int x) {
		for(int i = 0; i < num; i++)
			if(que[(i+front)%max] == x)
				return i + front;
		return 0;
	}
	
	
	public void clear() {
		num = front = rear = 0;
	}
	
	public int capacity() {
		return max;
	}
	
	public int size() {
		return num;
	}
	public boolean isEmpty() {
		return num <= 0;
	}
	public boolean isFull() {
		return num >= max;
	}
	public void dump() {
		if(num <= 0)
			System.out.println("��(deck)�� ����ֽ��ϴ�.");
		else {
			for(int i = 0; i < num; i++)
				System.out.print(que[(i+front)%max] + " ");
			System.out.println();
		}
	}
}

/*
����
�����̴� N���� ���Ҹ� �����ϰ� �ִ� ����� ��ȯ ť�� ������ �ִ�. �����̴� �� ť���� �� ���� ���Ҹ� �̾Ƴ����� �Ѵ�.

�����̴� �� ť���� ������ ���� 3���� ������ ������ �� �ִ�.

ù ��° ���Ҹ� �̾Ƴ���. �� ������ �����ϸ�, ���� ť�� ���Ұ� a1, ..., ak�̾��� ���� a2, ..., ak�� ���� �ȴ�.
�������� �� ĭ �̵���Ų��. �� ������ �����ϸ�, a1, ..., ak�� a2, ..., ak, a1�� �ȴ�.
���������� �� ĭ �̵���Ų��. �� ������ �����ϸ�, a1, ..., ak�� ak, a1, ..., ak-1�� �ȴ�.
ť�� ó���� ���ԵǾ� �ִ� �� N�� �־�����. �׸��� �����̰� �̾Ƴ����� �ϴ� ������ ��ġ�� �־�����. (�� ��ġ�� ���� ó�� ť������ ��ġ�̴�.) �̶�, �� ���Ҹ� �־��� ������� �̾Ƴ��µ� ��� 2��, 3�� ������ �ּڰ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ť�� ũ�� N�� �̾Ƴ����� �ϴ� ���� ���� M�� �־�����. N�� 50���� �۰ų� ���� �ڿ����̰�, M�� N���� �۰ų� ���� �ڿ����̴�. ��° �ٿ��� �����̰� �̾Ƴ����� �ϴ� ���� ��ġ�� ������� �־�����. ��ġ�� 1���� ũ�ų� ����, N���� �۰ų� ���� �ڿ����̴�.
*/