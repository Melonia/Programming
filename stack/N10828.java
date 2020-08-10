package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10828 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine()); //��ɾ� ���� �Է¹���.
		
		Stack stack = new Stack(N);
		Processor proc = new Processor(stack);
		for(int i = 0; i < N; i++) {
			String command = bf.readLine();
			proc.setCommand(command);
			proc.processing();
		}
	}
}

class Processor{

	Stack stack;
	String command;
	
	Processor(Stack stack){
		this.stack = stack;
	}
	
	public void setCommand(String command) {
		this.command = command;
	}

	void processing() {
		if(command.contains("push")) {
			stack.push(Integer.parseInt(command.split(" ")[1]));
		}
		if(command.contains("pop")) {
			System.out.println(stack.pop());
		}
		if(command.contains("size")) {
			System.out.println(stack.size());
		}
		if(command.contains("empty")) {
			System.out.println(stack.isEmpty());
		}
		if(command.contains("top")) {
			System.out.println(stack.peek());
		}
	}
}

class Stack{
	private int max; //���� �뷮(�ִ� ������ ��)
	private int ptr; //���� ������(���� ������ ���� �ǹ��ϸ� top+1�� ����Ų��.)
	private int[] stk; //���� �迭
	
	//������ ��� �ִ� ��� �߻��ϴ� ���� ó��
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() {}
	}
	
	//������ ���� á�� �� �߻��ϴ� ���� ó��
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {}
	}
	
	//���� ������(�ʱ�ȭ)
	Stack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max]; //���� �迭�� ����
		}catch(OutOfMemoryError e) { //���� ���� ����
			max = 0;
		}
	}
	
	//���� �޼ҵ��
	
	//���ÿ� ���� ����(top����)
	public int push(int x) throws OverflowIntStackException{
		if(ptr >= max) // ������ ���� ���� push�� �Ұ����� ���
			throw new OverflowIntStackException();
		return stk[ptr++] = x; //���ÿ� ���� push�ϰ� ptr�� ������Ŵ.
	}
	
	//���� top ���� 
	public int pop() throws EmptyIntStackException{
		if(ptr <= 0) // ������ ��� �־ pop�� �Ұ����� ���
			//throw new EmptyIntStackException();
			return -1;
		return stk[--ptr]; //������ top�� �����ϸ鼭 ptr�� ���ҽ�Ŵ. ���� �迭���� ���� ���������� ����.
	}
	
	//���� top ����
	public int peek() throws EmptyIntStackException{
		if(ptr <= 0)
			//throw new EmptyIntStackException();
			return -1;
		return stk[ptr-1]; //������ top�� ����
	}
	
	//���ÿ� � ���� �����ϸ� �� ���� ��ġ�� ��ȯ
	public int indexOf(int x) {
		for(int i = ptr - 1; i >= 0; i--)
			if(stk[i] == x)
				return i; //�˻� ���� �� �ε��� ��ȯ
		return -1; //�˻� ���� �� -1�� ��ȯ
	}
	
	//���� ���
	public void clear() {
		ptr = 0 ;
	}
	
	//������ �ִ� �뷮 ��ȯ
	public int capacity() {
		return max;
	}
	
	//������ ���� ������ ���� ��ȯ. ptr�� �� �������� ���� �ǹ���.
	public int size() {
		return ptr;
	}
	
	//������ ��� �ִ°�?
	public int isEmpty() {
		if(ptr <= 0)
			return 1;
		else
			return 0;
		//return ptr <= 0;
	}
	
	//������ �� �� �ִ°�?
	public boolean isFull() {
		return ptr >= max;
	}
	
	//���ÿ� �ִ� �����͸� ���� ���
	public void dump() {
		if(ptr <= 0)
			System.out.println("������ ��� ����.");
		else {
			for(int i = 0; i < ptr; i++)
				System.out.print(stk[i] + " ");
			System.out.println();
		}
	}
}
/*
����
������ �����ϴ� ������ ������ ����, �Է����� �־����� ����� ó���ϴ� ���α׷��� �ۼ��Ͻÿ�.

����� �� �ټ� �����̴�.

push X: ���� X�� ���ÿ� �ִ� �����̴�.
pop: ���ÿ��� ���� ���� �ִ� ������ ����, �� ���� ����Ѵ�. ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
size: ���ÿ� ����ִ� ������ ������ ����Ѵ�.
empty: ������ ��������� 1, �ƴϸ� 0�� ����Ѵ�.
top: ������ ���� ���� �ִ� ������ ����Ѵ�. ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
�Է�
ù° �ٿ� �־����� ����� �� N (1 �� N �� 10,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ����� �ϳ��� �־�����. �־����� ������ 1���� ũ�ų� ����, 100,000���� �۰ų� ����. ������ �������� ���� ����� �־����� ���� ����.

���
����ؾ��ϴ� ����� �־��� ������, �� �ٿ� �ϳ��� ����Ѵ�.
*/


/*
14
push 1
push 2
top
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
top

2
2
0
2
1
-1
0
1
-1
0
3
*/