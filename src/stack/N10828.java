package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10828 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine()); //명령어 개수 입력받음.
		
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
	private int max; //스택 용량(최대 데이터 수)
	private int ptr; //스택 포인터(현재 데이터 수를 의미하며 top+1을 가리킨다.)
	private int[] stk; //스택 배열
	
	//스택이 비어 있는 경우 발생하는 예외 처리
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() {}
	}
	
	//스택이 가득 찼을 때 발생하는 예외 처리
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {}
	}
	
	//스택 생성자(초기화)
	Stack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max]; //스택 배열을 생성
		}catch(OutOfMemoryError e) { //스택 생성 실패
			max = 0;
		}
	}
	
	//스택 메소드들
	
	//스택에 값을 삽입(top위에)
	public int push(int x) throws OverflowIntStackException{
		if(ptr >= max) // 스택이 가득 차서 push가 불가능한 경우
			throw new OverflowIntStackException();
		return stk[ptr++] = x; //스택에 값을 push하고 ptr을 증가시킴.
	}
	
	//스택 top 제거 
	public int pop() throws EmptyIntStackException{
		if(ptr <= 0) // 스택이 비어 있어서 pop이 불가능한 경우
			//throw new EmptyIntStackException();
			return -1;
		return stk[--ptr]; //스택의 top을 리턴하면서 ptr을 감소시킴. 실제 배열에서 값이 삭제되지는 않음.
	}
	
	//스택 top 리턴
	public int peek() throws EmptyIntStackException{
		if(ptr <= 0)
			//throw new EmptyIntStackException();
			return -1;
		return stk[ptr-1]; //스택의 top을 리턴
	}
	
	//스택에 어떤 값이 존재하면 그 값의 위치를 반환
	public int indexOf(int x) {
		for(int i = ptr - 1; i >= 0; i--)
			if(stk[i] == x)
				return i; //검색 성공 시 인덱스 반환
		return -1; //검색 실패 시 -1을 반환
	}
	
	//스택 비움
	public void clear() {
		ptr = 0 ;
	}
	
	//스택의 최대 용량 반환
	public int capacity() {
		return max;
	}
	
	//스택의 현재 데이터 수를 반환. ptr이 곧 데이터의 수를 의미함.
	public int size() {
		return ptr;
	}
	
	//스택이 비어 있는가?
	public int isEmpty() {
		if(ptr <= 0)
			return 1;
		else
			return 0;
		//return ptr <= 0;
	}
	
	//스택이 꽉 차 있는가?
	public boolean isFull() {
		return ptr >= max;
	}
	
	//스택에 있는 데이터를 전부 출력
	public void dump() {
		if(ptr <= 0)
			System.out.println("스택이 비어 있음.");
		else {
			for(int i = 0; i < ptr; i++)
				System.out.print(stk[i] + " ");
			System.out.println();
		}
	}
}
/*
문제
정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 다섯 가지이다.

push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
입력
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

출력
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
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