package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(bf.readLine());
	
		PS_Stack stack = null;
		PS_Processor proc = null;
		for(int i = 0; i < T; i++) {
			String PS = bf.readLine(); //Parenthesis String �Է�
			stack = new PS_Stack(PS.length());
			proc = new PS_Processor(stack);
			proc.checker(PS);
			proc.isVPS();
		}
	}
}

class PS_Processor{
	
	PS_Stack stack;
	boolean isVPS;
	
	PS_Processor(PS_Stack stack){
		this.stack = stack;
	}
	
	public void isVPS() {
		if(isVPS == false) {
			System.out.println("NO");
		}
		else {
			System.out.println("YES");
		}
	}
	
	public void checker(String PS) {
		for(int i = 0; i < PS.length(); i++) {
			if(PS.charAt(i)=='(') {
				stack.push(1);
			}
			else if(PS.charAt(i)==')'){
				int result = stack.pop();
				if(result == -1) {
					isVPS = false;
					return;
				}
			}
		}
		isVPS = stack.isEmpty();
	}
}

class PS_Stack{
	
	private int ptr;
	private int max;
	private int[] stk;
	
	PS_Stack(int capacity){
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public void push(int x) {
		if(ptr < max)
			stk[ptr++] = x;
	}
	
	public int pop() {
		if(ptr <= 0)
			return -1;
		else
			return stk[--ptr];
	}
	
	public boolean isEmpty() {
		return ptr <= 0;
	}
}
/*
����
��ȣ ���ڿ�(Parenthesis String, PS)�� �� ���� ��ȣ ��ȣ�� ��(�� �� ��)�� ������ �����Ǿ� �ִ� ���ڿ��̴�. �� �߿��� ��ȣ�� ����� �ٸ��� ������ ���ڿ��� �ùٸ� ��ȣ ���ڿ�(Valid PS, VPS)�̶�� �θ���. �� ���� ��ȣ ��ȣ�� �� ��( )�� ���ڿ��� �⺻ VPS �̶�� �θ���. ���� x �� VPS ��� �̰��� �ϳ��� ��ȣ�� ���� ���ο� ���ڿ� ��(x)���� VPS �� �ȴ�. �׸��� �� VPS x �� y�� ����(concatenation)��Ų ���ο� ���ڿ� xy�� VPS �� �ȴ�. ���� ��� ��(())()���� ��((()))�� �� VPS ������ ��(()(��, ��(())()))�� , �׸��� ��(()�� �� ��� VPS �� �ƴ� ���ڿ��̴�. 

�������� �Է����� �־��� ��ȣ ���ڿ��� VPS ���� �ƴ����� �Ǵ��ؼ� �� ����� YES �� NO �� ��Ÿ����� �Ѵ�. 

�Է�
�Է� �����ʹ� ǥ�� �Է��� ����Ѵ�. �Է��� T���� �׽�Ʈ �����ͷ� �־�����. �Է��� ù ��° �ٿ��� �Է� �������� ���� ��Ÿ���� ���� T�� �־�����. �� �׽�Ʈ �������� ù° �ٿ��� ��ȣ ���ڿ��� �� �ٿ� �־�����. �ϳ��� ��ȣ ���ڿ��� ���̴� 2 �̻� 50 �����̴�. 

���
����� ǥ�� ����� ����Ѵ�. ���� �Է� ��ȣ ���ڿ��� �ùٸ� ��ȣ ���ڿ�(VPS)�̸� ��YES��, �ƴϸ� ��NO���� �� �ٿ� �ϳ��� ���ʴ�� ����ؾ� �Ѵ�. 
*/