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
����
������ �����ϴ� ť�� ������ ����, �Է����� �־����� ����� ó���ϴ� ���α׷��� �ۼ��Ͻÿ�.

����� �� ���� �����̴�.

push X: ���� X�� ť�� �ִ� �����̴�.
pop: ť���� ���� �տ� �ִ� ������ ����, �� ���� ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
size: ť�� ����ִ� ������ ������ ����Ѵ�.
empty: ť�� ��������� 1, �ƴϸ� 0�� ����Ѵ�.
front: ť�� ���� �տ� �ִ� ������ ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
back: ť�� ���� �ڿ� �ִ� ������ ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
�Է�
ù° �ٿ� �־����� ����� �� N (1 �� N �� 2,000,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ����� �ϳ��� �־�����. �־����� ������ 1���� ũ�ų� ����, 100,000���� �۰ų� ����. ������ �������� ���� ����� �־����� ���� ����.

���
����ؾ��ϴ� ����� �־��� ������, �� �ٿ� �ϳ��� ����Ѵ�.
*/