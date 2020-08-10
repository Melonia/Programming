package stack;

import java.util.Scanner;

public class N1874 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//수열의 길이 입력
		int n = scan.nextInt();
		int[] seq = new int[n];
		
		//수열 초기화
		for(int i = 0; i < n; i++)
			seq[i] = scan.nextInt();
		
		//스택 초기화
		SequenceStack stack = new SequenceStack(n);
		int index = 0; //수열 배열의 인덱스
		char[] operation = new char[2*n]; //push, pop 기록을 담는 배열
		int k = 0; //operation 배열의 인덱스
		
		for(int i = 1; i <= n; i++) {
			
			//1부터 차례대로 push 
			stack.push(i);
			operation[k++]='+';
			
			//stack의 top값이 수열의 값과 같으면 pop
			while(stack.peek() == seq[index]) {
				stack.pop();
				operation[k++]='-';
				index++; //수열의 다음 숫자로 넘어감.
				//수열을 완성함
				if(index >= n)
					break;
			}
			
			if(index >= n)
				break;
		}
		
		//index는 pop()을 호출한 횟수이고 n은 수열의 길이이므로  둘이 일치하면 수열을 완성한 것.
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
			return -1; //수열에는 음수가 없으므로 -1을 반환하여 불일치를 만든다.
		return stk[ptr-1];
	}
	boolean isEmpty() {
		return ptr <= 0;
	}
}

/*
문제
스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.

1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.

입력
첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다. 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 물론 같은 정수가 두 번 나오는 일은 없다.

출력
입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.
*/