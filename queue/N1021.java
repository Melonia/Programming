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
			System.out.println("덱(deck)이 비어있습니다.");
		else {
			for(int i = 0; i < num; i++)
				System.out.print(que[(i+front)%max] + " ");
			System.out.println();
		}
	}
}

/*
문제
지민이는 N개의 원소를 포함하고 있는 양방향 순환 큐를 가지고 있다. 지민이는 이 큐에서 몇 개의 원소를 뽑아내려고 한다.

지민이는 이 큐에서 다음과 같은 3가지 연산을 수행할 수 있다.

첫 번째 원소를 뽑아낸다. 이 연산을 수행하면, 원래 큐의 원소가 a1, ..., ak이었던 것이 a2, ..., ak와 같이 된다.
왼쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.
오른쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.
큐에 처음에 포함되어 있던 수 N이 주어진다. 그리고 지민이가 뽑아내려고 하는 원소의 위치가 주어진다. (이 위치는 가장 처음 큐에서의 위치이다.) 이때, 그 원소를 주어진 순서대로 뽑아내는데 드는 2번, 3번 연산의 최솟값을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 큐의 크기 N과 뽑아내려고 하는 수의 개수 M이 주어진다. N은 50보다 작거나 같은 자연수이고, M은 N보다 작거나 같은 자연수이다. 둘째 줄에는 지민이가 뽑아내려고 하는 수의 위치가 순서대로 주어진다. 위치는 1보다 크거나 같고, N보다 작거나 같은 자연수이다.
*/