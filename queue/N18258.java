package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N18258 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		int N = Integer.parseInt(bf.readLine());
		
		Queue1 que = new Queue1(N);

		for(int i = 0; i < N; i++) {
			String command = bf.readLine();
			if(command.contains("push")) {
				que.push(Integer.parseInt(command.split(" ")[1]));
			}
			if(command.contains("pop")) {
				bw.write(que.pop()+"\n");
			}
			if(command.contains("size")) {
				bw.write(que.size()+"\n");
			}
			if(command.contains("empty")) {
				bw.write(que.empty()+"\n");
			}
			if(command.contains("front")){
				bw.write(que.front()+"\n");
			}
			if(command.contains("back")){
				bw.write(que.back()+"\n");
			}
		}
		bw.flush();
	}
}

class Queue1{
	private int max;
	private int num;
	private int front;
	private int back;
	private int[] que;
	
	Queue1(int capacity){
		max = capacity;
		num = front = back = 0;
		try {
			que = new int[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	class EmptyIntQueueException extends RuntimeException{
		EmptyIntQueueException(){}
	}
	class OverflowIntQueueException extends RuntimeException{
		OverflowIntQueueException(){}
	}
	
	int push(int x) throws OverflowIntQueueException{
		if(num >= max)
			throw new OverflowIntQueueException();
		que[back++] = x;
		num++;
		if(back==max)
			back = 0;
		return x;
	}
	
	int pop() throws EmptyIntQueueException{
		if(num <= 0)
			return -1;
		int x = que[front++];
		num --;
		if(front == max)
			front = 0;
		return x;
	}
	
	int size() {
		return num;
	}
	int empty() {
		if(num <= 0)
			return 1;
		else
			return 0;
	}
	int front() {
		if(num <= 0)
			return -1;
		return que[front];
	}
	int back() {
		if(num <= 0)
			return -1;
		else {
			if(back == 0)
				return que[max-1];
			else {
				return que[back-1];
			}
		}
	}
}
/*
문제
정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여섯 가지이다.

push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
입력
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 2,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

출력
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
*/