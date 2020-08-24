package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10866 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		DeckProcessor dp = new DeckProcessor(new Deque<Integer>());
		for(int i = 0; i < N; i++) {
			String command = bf.readLine();
			dp.run(command);
		}
	}
}

class DeckProcessor{
	
	Deque<Integer> deck;
	
	DeckProcessor(Deque deck){
		this.deck = deck;
	}
	
	void run(String command) {
		if(command.contains("push_front")) {
			deck.push_front(Integer.parseInt(command.split(" ")[1]));
		}
		if(command.contains("push_back")) {
			deck.push_back(Integer.parseInt(command.split(" ")[1]));
		}
		if(command.contains("pop_front")) {
			Integer data = deck.pop_front();
			if(data == null) {
				System.out.println(-1);
			}
			else {
				System.out.println(data);
			}
		}
		if(command.contains("pop_back")) {
			Integer data = deck.pop_back();
			if(data == null) {
				System.out.println(-1);
			}
			else {
				System.out.println(data);
			}
		}
		if(command.contains("size")){
			System.out.println(deck.size());
		}
		if(command.contains("empty")) {
			if(deck.empty()) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
		if(command.equals("front")) {
			if(deck.empty()) {
				System.out.println(-1);
			}else {
				System.out.println(deck.begin());
			}
		}
		if(command.equals("back")) {
			if(deck.empty()) {
				System.out.println(-1);
			}else {
				System.out.println(deck.end());
			}
		}
	}
}

class Node<E> {

	private E data;
	private Node<E> next;
	private Node<E> prev;

	Node(E data) {

		this.data = data;
		this.next = null;
		this.prev = null;

	}

	void setNext(Node<E> next) {
		this.next = next;
	}

	void setPrev(Node<E> prev) {
		this.prev = prev;
	}

	void setData(E data) {
		this.data = data;
	}

	Node<E> getNext() {
		return next;
	}

	Node<E> getPrev() {
		return prev;
	}

	E getData() {
		return data;
	}

}

class Deque<E> {

	private Node<E> front;
	private Node<E> back;

	Deque() {
		front = null;
		back = null;
	}

	void setFront(Node<E> front) {
		this.front = front;
	}

	void setBack(Node<E> back) {
		this.back = back;
	}

	Node<E> getFront() {
		return front;
	}

	Node<E> getBack() {
		return back;
	}

	boolean empty() {

		if (front == null)
			return true;

		else
			return false;

	}

	boolean push_front(E data) {

		if (empty()) {

			front = new Node<E>(data);
			back = front;
			return true;
		}

		front.setPrev(new Node<E>(data));
		front.getPrev().setNext(front);
		front = front.getPrev();
		return true;
	}

	boolean push_back(E data) {

		if (empty()) {
			back = new Node<E>(data);
			front = back;
			return true;
		}

		back.setNext(new Node<E>(data));
		back.getNext().setPrev(back);
		back = back.getNext();
		return true;
	}

	E pop_front() {

		if (empty())
			return null;
		
		E tmp = front.getData();

		if (front == back) {

			front = null;
			back = null;
			return tmp;

		}

		front = front.getNext();
		front.setPrev(null);
		return tmp;
	}

	E pop_back() {

		if (empty())
			return null;

		E tmp = back.getData();

		if (front == back) {
			front = null;
			back = null;
			return tmp;
		}

		back = back.getPrev();
		back.setNext(null);
		return tmp;
	}

	E begin() {
		return front.getData();
	}

	E end() {
		return back.getData();
	}
	
	int size() {
		if(empty())
			return 0;
		
		Node<E> node = front;
		int count = 1;
		while(true) {
			node = node.getNext();
			if(node == null)
				break;
			count++;
		}
		return count;
	}
}

/*
문제
정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여덟 가지이다.

push_front X: 정수 X를 덱의 앞에 넣는다.
push_back X: 정수 X를 덱의 뒤에 넣는다.
pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 덱에 들어있는 정수의 개수를 출력한다.
empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
입력
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

출력
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
*/