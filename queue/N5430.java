package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class N5430 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < T; i++) {
			try {
				String p = bf.readLine(); //수행할 함수
				int n = Integer.parseInt(bf.readLine()); //데이터의 수
				String x = bf.readLine(); //데이터
			
				IntDeque deck = new IntDeque(n);
				Processor proc = new Processor(deck);
			
				proc.deck_init(x,n);
				proc.run(p);
			}catch(Exception e) {
				System.out.println("error");
			}
		}
	}
}

class Processor{
	
	IntDeque deck;
	boolean ForR = false;//false는 front에서 deque
	
	Processor(IntDeque deck){
		this.deck = deck;
	}
	
	void deck_init(String x,int n) {
		x = x.replace('[', ' ');
		x = x.replace(']', ' ');
		x = x.trim();
		String[] x2 =  x.split(",");
		
		for(int i = 0; i < n; i++) {
			int data = Integer.parseInt(x2[i]);
			deck.enqueRear(data);
		}
	}
	
	void run(String funcGroup) {
		for(int i = 0; i < funcGroup.length(); i++) {
			char func = funcGroup.charAt(i);
			if(func == 'R') 
				R();
			else if(func == 'D')
				D();
		}
		if(!ForR)deck.dump_front();
		else deck.dump_rear();
	}
	
	void R() {
		ForR = !ForR;
	}
	
	void D() {
		if(!ForR) 
			deck.dequeFront();
		else
			deck.dequeRear();
	}
	
}
class IntDeque{
	private int max; // 덱(deck)의 용량
	private int num; // 현재의 데이터 수
	private int front; // 맨 앞 커서
	private int rear; // 맨 뒤 커서
	private int[] que; // 덱(deck)의 본체

	// 실행할 때 예외：큐가 비어 있음
	public class EmptyIntDequeException extends RuntimeException {
		public EmptyIntDequeException() {
		}
	}

	// 실행할 때 예외：큐가 가득 참
	public class OverflowIntDequeException extends RuntimeException {
		public OverflowIntDequeException() {
		}
	}

	// 생성자
	public IntDeque(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = new int[max]; // 덱(deck)본체용 배열을 생성
		} catch (OutOfMemoryError e) { // 생성할 수 없습니다
			max = 0;
		}
	}

	// 덱(deck)에 데이터를 머리쪽부터 인큐
	public int enqueFront(int x) throws OverflowIntDequeException {
		if (num >= max)
			throw new OverflowIntDequeException(); // 덱(deck)이 가득 참
		num++;
		if (--front < 0)
			front = max - 1;
		que[front] = x;
		return x;
	}

	// 덱(deck)에 데이터를 꼬리쪽부터 인큐
	public int enqueRear(int x) throws OverflowIntDequeException {
		if (num >= max)
			throw new OverflowIntDequeException(); // 덱(deck)은 가득 참
		que[rear++] = x;
		num++;
		if (rear == max)
			rear = 0;
		return x;
	}

	// 덱(deck)의 머리부터 데이터를 디큐
	public int dequeFront() throws EmptyIntDequeException {
		if (num <= 0)
			throw new EmptyIntDequeException(); // 덱(deck)이 비어 있음
		int x = que[front++];
		num--;
		if (front == max)
			front = 0;
		return x;
	}

	// 덱(deck)의 꼬리부터 데이터를 디큐
	public int dequeRear() throws EmptyIntDequeException {
		if (num <= 0)
			throw new EmptyIntDequeException(); // 덱(deck)이 비어 있음
		num--;
		if (--rear < 0)
			rear = max - 1;
		return que[rear];
	}

	// 덱(deck)에 쌓인 데이터 수를 반환
	public int size() {
		return num;
	}

	// 덱(deck)내의 데이터를 머리→꼬리의 차례로 나타냄
	public void dump_front() {
		if (num <= 0)
			System.out.println("[]");
		else {
			System.out.print("[");
			for (int i = 0; i < num-1; i++)
				System.out.print(que[(i + front) % max] + ",");
			System.out.println(que[(num-1+front)%max]+"]");
		}
	}
	public void dump_rear() {
		if (num <= 0)
			System.out.println("[]");
		else {
			System.out.print("[");
			for (int i = num-1; i > 0; i--)
				System.out.print(que[(i + front) % max] + ",");
			System.out.println(que[front%max]+"]");
		}
	}
}
/*
문제
선영이는 주말에 할 일이 없어서 새로운 언어 AC를 만들었다. AC는 정수 배열에 연산을 하기 위해 만든 언어이다. 이 언어에는 두 가지 함수 R(뒤집기)과 D(버리기)가 있다.

함수 R은 배열에 있는 숫자의 순서를 뒤집는 함수이고, D는 첫 번째 숫자를 버리는 함수이다. 배열이 비어있는데 D를 사용한 경우에는 에러가 발생한다.

함수는 조합해서 한 번에 사용할 수 있다. 예를 들어, "AB"는 A를 수행한 다음에 바로 이어서 B를 수행하는 함수이다. 예를 들어, "RDD"는 배열을 뒤집은 다음 처음 두 숫자를 버리는 함수이다.

배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. T는 최대 100이다.

각 테스트 케이스의 첫째 줄에는 수행할 함수 p가 주어진다. p의 길이는 1보다 크거나 같고, 100,000보다 작거나 같다.

다음 줄에는 배열에 들어있는 수의 개수 n이 주어진다. (0 ≤ n ≤ 100,000)

다음 줄에는 [x1,...,xn]과 같은 형태로 배열에 들어있는 수가 주어진다. (1 ≤ xi ≤ 100)

전체 테스트 케이스에 주어지는 p의 길이의 합과 n의 합은 70만을 넘지 않는다.

출력
각 테스트 케이스에 대해서, 입력으로 주어진 정수 배열에 함수를 수행한 결과를 출력한다. 만약, 에러가 발생한 경우에는 error를 출력한다.
*/