package stack;

import java.util.Scanner;

public class N10773 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int K = scan.nextInt();
		
		Jaemin stack = new Jaemin(K);
		OldProcessor proc = new OldProcessor(stack);
		
		for(int i = 0; i < K; i++) {
			int num = scan.nextInt();
			proc.processing(num);
		}
		proc.sum();
	}
}

class OldProcessor{
	
	Jaemin stack;
	
	OldProcessor(Jaemin stack){
		this.stack = stack;
	}
	
	void processing(int num) {
		if(num == 0)
			stack.pop();
		else
			stack.push(num);
	}
	
	void sum() {
		System.out.println(stack.sum());
	}
	
}
class Jaemin{

	private int max;
	private int ptr;
	private int[] stk;
	
	Jaemin(int capacity){
		max = capacity;
		ptr = 0;
		try {
			stk = new int[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {}
	}
	
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() {}
	}
	
	public void push(int x) {
		if(ptr >= max)
			throw new OverflowIntStackException();
		stk[ptr++] = x;
	}
	
	public void pop() {
		--ptr;
	}
	
	public int sum() {
		int sum = 0;
		for(int i = 0; i < ptr; i++)
			sum += stk[i];
		return sum;
	}
}
/*
����
���ڴ� ���� ����̴� ���Ƹ� ȸ���� �غ��ϱ� ���ؼ� ��θ� �����ϴ� ���̴�.

�����̴� ����̸� ���ͼ� ���� �����ϴ� ���ε�, �ּ��ϰԵ� �׻� ���ž��� �����̴� ���� �Ǽ��� �߸� �θ��� ��� ġ�� �Ͼ�����.

�����̴� �߸��� ���� �θ� ������ 0�� ���ļ�, ���� �ֱٿ� ����̰� �� ���� ����� ��Ų��.

����̴� �̷��� ��� ���� �޾� ���� �� �� ���� ���� �˰� �;� �Ѵ�. ����̸� ��������!

�Է�
ù ��° �ٿ� ���� K�� �־�����. (1 �� K �� 100,000)

���� K���� �ٿ� ������ 1���� �־�����. ������ 0���� 1,000,000 ������ ���� ������, ������ "0" �� ��쿡�� ���� �ֱٿ� �� ���� �����, �ƴ� ��� �ش� ���� ����.

������ "0"�� ��쿡 ���� �� �ִ� ���� ������ ������ �� �ִ�.

���
����̰� ���������� ���� �� ���� ���� ����Ѵ�. ���������� ��� ���� ���� 231-1���� �۰ų� ���� �����̴�.
*/