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
문제
세계는 균형이 잘 잡혀있어야 한다. 양과 음, 빛과 어둠 그리고 왼쪽 괄호와 오른쪽 괄호처럼 말이다.

정민이의 임무는 어떤 문자열이 주어졌을 때, 괄호들의 균형이 잘 맞춰져 있는지 판단하는 프로그램을 짜는 것이다.

문자열에 포함되는 괄호는 소괄호("()") 와 대괄호("[]")로 2종류이고, 문자열이 균형을 이루는 조건은 아래와 같다.

모든 왼쪽 소괄호("(")는 오른쪽 소괄호(")")와만 짝을 이뤄야 한다.
모든 왼쪽 대괄호("[")는 오른쪽 대괄호("]")와만 짝을 이뤄야 한다.
모든 오른쪽 괄호들은 자신과 짝을 이룰 수 있는 왼쪽 괄호가 존재한다.
모든 괄호들의 짝은 1:1 매칭만 가능하다. 즉, 괄호 하나가 둘 이상의 괄호와 짝지어지지 않는다.
짝을 이루는 두 괄호가 있을 때, 그 사이에 있는 문자열도 균형이 잡혀야 한다.
정민이를 도와 문자열이 주어졌을 때 균형잡힌 문자열인지 아닌지를 판단해보자.

입력
하나 또는 여러줄에 걸쳐서 문자열이 주어진다. 각 문자열은 영문 알파벳, 공백, 소괄호("( )") 대괄호("[ ]")등으로 이루어져 있으며, 길이는 100글자보다 작거나 같다.

입력의 종료조건으로 맨 마지막에 점 하나(".")가 들어온다.
출력
각 줄마다 해당 문자열이 균형을 이루고 있으면 "yes"를, 아니면 "no"를 출력한다.
*/