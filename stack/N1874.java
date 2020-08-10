package stack;

import java.util.Scanner;

public class N1874 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//������ ���� �Է�
		int n = scan.nextInt();
		int[] seq = new int[n];
		
		//���� �ʱ�ȭ
		for(int i = 0; i < n; i++)
			seq[i] = scan.nextInt();
		
		//���� �ʱ�ȭ
		SequenceStack stack = new SequenceStack(n);
		int index = 0; //���� �迭�� �ε���
		char[] operation = new char[2*n]; //push, pop ����� ��� �迭
		int k = 0; //operation �迭�� �ε���
		
		for(int i = 1; i <= n; i++) {
			
			//1���� ���ʴ�� push 
			stack.push(i);
			operation[k++]='+';
			
			//stack�� top���� ������ ���� ������ pop
			while(stack.peek() == seq[index]) {
				stack.pop();
				operation[k++]='-';
				index++; //������ ���� ���ڷ� �Ѿ.
				//������ �ϼ���
				if(index >= n)
					break;
			}
			
			if(index >= n)
				break;
		}
		
		//index�� pop()�� ȣ���� Ƚ���̰� n�� ������ �����̹Ƿ�  ���� ��ġ�ϸ� ������ �ϼ��� ��.
		if(n == index) {
			for(int i = 0; i < operation.length; i++) {
				System.out.println(operation[i]);
			}
		}
		else {
			System.out.println("NO");
		}
	}
}

class SequenceStack{
	private int max;
	private int ptr;
	private int[] stk;
	
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {}
	}
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() {}
	}
	
	SequenceStack(int capacity){
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	int push(int x) throws OverflowIntStackException{
		if(ptr >= max)
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}
	int pop() throws EmptyIntStackException{
		if(ptr <= 0)
			throw new EmptyIntStackException();
		return stk[--ptr];
	}
	int peek() throws EmptyIntStackException{
		if(ptr <= 0)
			return -1; //�������� ������ �����Ƿ� -1�� ��ȯ�Ͽ� ����ġ�� �����.
		return stk[ptr-1];
	}
	boolean isEmpty() {
		return ptr <= 0;
	}
}

/*
����
���� (stack)�� �⺻���� �ڷᱸ�� �� �ϳ���, ��ǻ�� ���α׷��� �ۼ��� �� ���� �̿�Ǵ� �����̴�. ������ �ڷḦ �ִ� (push) �Ա��� �ڷḦ �̴� (pop) �Ա��� ���� ���� ���߿� �� �ڷᰡ ���� ���� ������ (LIFO, Last in First out) Ư���� ������ �ִ�.

1���� n������ ���� ���ÿ� �־��ٰ� �̾� �þ�������ν�, �ϳ��� ������ ���� �� �ִ�. �̶�, ���ÿ� push�ϴ� ������ �ݵ�� ���������� ��Ű���� �Ѵٰ� ����. ������ ������ �־����� �� ������ �̿��� �� ������ ���� �� �ִ��� ������, �ִٸ� � ������ push�� pop ������ �����ؾ� �ϴ����� �˾Ƴ� �� �ִ�. �̸� ����ϴ� ���α׷��� �ۼ��϶�.

�Է�
ù �ٿ� n (1 �� n �� 100,000)�� �־�����. ��° �ٺ��� n���� �ٿ��� ������ �̷�� 1�̻� n������ ������ �ϳ��� ������� �־�����. ���� ���� ������ �� �� ������ ���� ����.

���
�Էµ� ������ ����� ���� �ʿ��� ������ �� �ٿ� �� ���� ����Ѵ�. push������ +��, pop ������ -�� ǥ���ϵ��� �Ѵ�. �Ұ����� ��� NO�� ����Ѵ�.
*/