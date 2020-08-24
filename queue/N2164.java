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
문제
N장의 카드가 있다. 각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며, 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.

이제 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다. 우선, 제일 위에 있는 카드를 바닥에 버린다. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.

예를 들어 N=4인 경우를 생각해 보자. 카드는 제일 위에서부터 1234 의 순서로 놓여있다. 1을 버리면 234가 남는다. 여기서 2를 제일 아래로 옮기면 342가 된다. 3을 버리면 42가 되고, 4를 밑으로 옮기면 24가 된다. 마지막으로 2를 버리고 나면, 남는 카드는 4가 된다.

N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N(1≤N≤500,000)이 주어진다.

출력
첫째 줄에 남게 되는 카드의 번호를 출력한다.
*/