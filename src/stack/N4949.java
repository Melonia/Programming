package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String_Stack stack = null;
		Checker checker = null;
		
		while(true) {
			String s = bf.readLine();
			if(s.equals("."))
				break;
			stack = new String_Stack(s.length());
			checker = new Checker(s,stack);
			checker.stacker();
			checker.isBalanced();
		}
	}
}

class Checker{
	String s;
	String_Stack stack;
	boolean balance;
	
	Checker(String s, String_Stack stack){
		this.s = s;
		this.stack = stack;
	}
	
	void isBalanced() {
		if(balance == false) {
			System.out.println("no");
		}
		else {
			System.out.println("yes");
		}
	}
	
	void stacker() {
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c=='('||c=='[') {
				stack.push(c);
			}
			else if(c == ')') {
				if(stack.peek()=='(') {
					stack.pop();
				}else {
					balance = false;
					return;
				}
			}
			else if(c == ']') {
				if(stack.peek()=='[') {
					stack.pop();
				}else {
					balance = false;
					return;
				}
			}
			//stack.dump();
		}
		balance = stack.isEmpty();
	}
}

class String_Stack{
	
	private int max;
	private int ptr;
	private char[] stk;
	
	String_Stack(int capacity){
		ptr = 0;
		max = capacity;
		try {
			stk = new char[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	void push(char x) {
		if(ptr < max)
			stk[ptr++] = x;
	}
	void pop() {
		--ptr;
	}
	
	char peek() {
		if(ptr <= 0)
			return 'x';
		return stk[ptr-1];
	}
	
	boolean isEmpty() {
		return ptr <= 0;
	}
	
	void dump() {
		for(int i = 0; i < ptr; i++)
			System.out.print(stk[i]+ " ");
		System.out.println();
	}
}
/*
����
����� ������ �� �����־�� �Ѵ�. ��� ��, ���� ��� �׸��� ���� ��ȣ�� ������ ��ȣó�� ���̴�.

�������� �ӹ��� � ���ڿ��� �־����� ��, ��ȣ���� ������ �� ������ �ִ��� �Ǵ��ϴ� ���α׷��� ¥�� ���̴�.

���ڿ��� ���ԵǴ� ��ȣ�� �Ұ�ȣ("()") �� ���ȣ("[]")�� 2�����̰�, ���ڿ��� ������ �̷�� ������ �Ʒ��� ����.

��� ���� �Ұ�ȣ("(")�� ������ �Ұ�ȣ(")")�͸� ¦�� �̷�� �Ѵ�.
��� ���� ���ȣ("[")�� ������ ���ȣ("]")�͸� ¦�� �̷�� �Ѵ�.
��� ������ ��ȣ���� �ڽŰ� ¦�� �̷� �� �ִ� ���� ��ȣ�� �����Ѵ�.
��� ��ȣ���� ¦�� 1:1 ��Ī�� �����ϴ�. ��, ��ȣ �ϳ��� �� �̻��� ��ȣ�� ¦�������� �ʴ´�.
¦�� �̷�� �� ��ȣ�� ���� ��, �� ���̿� �ִ� ���ڿ��� ������ ������ �Ѵ�.
�����̸� ���� ���ڿ��� �־����� �� �������� ���ڿ����� �ƴ����� �Ǵ��غ���.

�Է�
�ϳ� �Ǵ� �����ٿ� ���ļ� ���ڿ��� �־�����. �� ���ڿ��� ���� ���ĺ�, ����, �Ұ�ȣ("( )") ���ȣ("[ ]")������ �̷���� ������, ���̴� 100���ں��� �۰ų� ����.

�Է��� ������������ �� �������� �� �ϳ�(".")�� ���´�.
���
�� �ٸ��� �ش� ���ڿ��� ������ �̷�� ������ "yes"��, �ƴϸ� "no"�� ����Ѵ�.
*/