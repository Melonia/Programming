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
				String p = bf.readLine(); //������ �Լ�
				int n = Integer.parseInt(bf.readLine()); //�������� ��
				String x = bf.readLine(); //������
			
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
	boolean ForR = false;//false�� front���� deque
	
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
	private int max; // ��(deck)�� �뷮
	private int num; // ������ ������ ��
	private int front; // �� �� Ŀ��
	private int rear; // �� �� Ŀ��
	private int[] que; // ��(deck)�� ��ü

	// ������ �� ���ܣ�ť�� ��� ����
	public class EmptyIntDequeException extends RuntimeException {
		public EmptyIntDequeException() {
		}
	}

	// ������ �� ���ܣ�ť�� ���� ��
	public class OverflowIntDequeException extends RuntimeException {
		public OverflowIntDequeException() {
		}
	}

	// ������
	public IntDeque(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = new int[max]; // ��(deck)��ü�� �迭�� ����
		} catch (OutOfMemoryError e) { // ������ �� �����ϴ�
			max = 0;
		}
	}

	// ��(deck)�� �����͸� �Ӹ��ʺ��� ��ť
	public int enqueFront(int x) throws OverflowIntDequeException {
		if (num >= max)
			throw new OverflowIntDequeException(); // ��(deck)�� ���� ��
		num++;
		if (--front < 0)
			front = max - 1;
		que[front] = x;
		return x;
	}

	// ��(deck)�� �����͸� �����ʺ��� ��ť
	public int enqueRear(int x) throws OverflowIntDequeException {
		if (num >= max)
			throw new OverflowIntDequeException(); // ��(deck)�� ���� ��
		que[rear++] = x;
		num++;
		if (rear == max)
			rear = 0;
		return x;
	}

	// ��(deck)�� �Ӹ����� �����͸� ��ť
	public int dequeFront() throws EmptyIntDequeException {
		if (num <= 0)
			throw new EmptyIntDequeException(); // ��(deck)�� ��� ����
		int x = que[front++];
		num--;
		if (front == max)
			front = 0;
		return x;
	}

	// ��(deck)�� �������� �����͸� ��ť
	public int dequeRear() throws EmptyIntDequeException {
		if (num <= 0)
			throw new EmptyIntDequeException(); // ��(deck)�� ��� ����
		num--;
		if (--rear < 0)
			rear = max - 1;
		return que[rear];
	}

	// ��(deck)�� ���� ������ ���� ��ȯ
	public int size() {
		return num;
	}

	// ��(deck)���� �����͸� �Ӹ��沿���� ���ʷ� ��Ÿ��
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
����
�����̴� �ָ��� �� ���� ��� ���ο� ��� AC�� �������. AC�� ���� �迭�� ������ �ϱ� ���� ���� ����̴�. �� ���� �� ���� �Լ� R(������)�� D(������)�� �ִ�.

�Լ� R�� �迭�� �ִ� ������ ������ ������ �Լ��̰�, D�� ù ��° ���ڸ� ������ �Լ��̴�. �迭�� ����ִµ� D�� ����� ��쿡�� ������ �߻��Ѵ�.

�Լ��� �����ؼ� �� ���� ����� �� �ִ�. ���� ���, "AB"�� A�� ������ ������ �ٷ� �̾ B�� �����ϴ� �Լ��̴�. ���� ���, "RDD"�� �迭�� ������ ���� ó�� �� ���ڸ� ������ �Լ��̴�.

�迭�� �ʱⰪ�� ������ �Լ��� �־����� ��, ���� ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����. T�� �ִ� 100�̴�.

�� �׽�Ʈ ���̽��� ù° �ٿ��� ������ �Լ� p�� �־�����. p�� ���̴� 1���� ũ�ų� ����, 100,000���� �۰ų� ����.

���� �ٿ��� �迭�� ����ִ� ���� ���� n�� �־�����. (0 �� n �� 100,000)

���� �ٿ��� [x1,...,xn]�� ���� ���·� �迭�� ����ִ� ���� �־�����. (1 �� xi �� 100)

��ü �׽�Ʈ ���̽��� �־����� p�� ������ �հ� n�� ���� 70���� ���� �ʴ´�.

���
�� �׽�Ʈ ���̽��� ���ؼ�, �Է����� �־��� ���� �迭�� �Լ��� ������ ����� ����Ѵ�. ����, ������ �߻��� ��쿡�� error�� ����Ѵ�.
*/